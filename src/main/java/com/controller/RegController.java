package com.controller;

import com.pojo.Persion;
import com.pojo.User;
import com.service.IPersionService;
import com.service.IUserService;
import com.service.impl.PersionServiceImpl;
import com.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RegController {
    //管理员登录
    @RequestMapping("/login")
    public String login(User user){
        System.out.println(user);
        IUserService ius=new UserServiceImpl();
        User users=ius.getUser(user);
        if(users!=null){
            return "success";
        }else{
            return "redirect:/login.jsp";
        }

    }
    //前往注册
    @RequestMapping("reg")
    public String reg(){
        return "redirect:/reg.jsp";
    }

    //注册
    @ResponseBody
    @RequestMapping("doreg")
    public String doreg(Persion per, @RequestParam("file") MultipartFile file)throws Exception{
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        file.transferTo(new File("D:\\520\\idea\\maven_file\\mybatis01\\src\\main\\webapp\\img\\"+file.getOriginalFilename()));
        per.setpCheck("待审核");
        per.setpPhoto(file.getOriginalFilename());
        per.setpAddtime(sdf.format(date));
        System.out.println(per);
        IPersionService ips=new PersionServiceImpl();
        int i=ips.addPersion(per);
        if(i>0){
            return "<script type='text/javascript'>alert('zhucechenggong');window.location.href='login.jsp'</script>";
        }else{
            return "<script type='text/javascript'>alert('zhuceshibai');window.location.href='reg.jsp'</script>";
        }

    }
    //ajax验证账户名
    @ResponseBody
    @RequestMapping("doajax")
    public String doajax(String userName){
        System.out.println(userName);
        IPersionService ips=new PersionServiceImpl();
        Persion persion=ips.getPersion(userName);
        if(persion==null){
            return "true";
        }else{
            return "false";
        }

    }
    //查看用户注册表
    @RequestMapping("seeList")
    public String seeList(HttpSession session){
        List<Persion> list=new ArrayList<Persion>();
        IPersionService ips=new PersionServiceImpl();
        list=ips.getAllPersion();
        int i=0;
        if(list.size()%2==0){
            i=list.size()/2;
        }else{
            i=list.size()/2+1;
        }
        session.setAttribute("pageLarge",i);
        List<Persion> list1=new ArrayList<Persion>();
        list1=ips.getSomePersion((1-1)*2);
        session.setAttribute("pageNow",1);
        session.setAttribute("PersionList",list1);
        return "show";
    }

    //审核
    @ResponseBody
    @RequestMapping("docheck")
    public String docheck(Integer pid){
        IPersionService ips=new PersionServiceImpl();
        int i=ips.updateCheck(pid);
        if(i>0){
            return "true";
        }else{
            return "false";
        }
    }
    //首页
    @RequestMapping("shouye")
    public String shouye(HttpSession session){
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();
        if(session.getAttribute("selectdepersion")==null){
            list1=ips.getSomePersion((1-1)*2);
        }else{
            Persion per=(Persion)session.getAttribute("selectdepersion");
           list1=ips.selectPersion(per.getpName(),per.getpTel(),per.getpAddress(),per.getpCheck(),0);
        }
        session.setAttribute("pageNow",1);
        session.setAttribute("PersionList",list1);
        return "show";
    }
    //尾页
    @RequestMapping("weiye")
    public String weiye(HttpSession session){
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();

        int i=0;
        if(session.getAttribute("selectdepersion")==null){
            i=(int)session.getAttribute("pageLarge");
            list1=ips.getSomePersion((i-1)*2);
        }else{
            Persion per=(Persion)session.getAttribute("selectdepersion");
            i=(int)session.getAttribute("pageLarge1");
            list1=ips.selectPersion(per.getpName(),per.getpTel(),per.getpAddress(),per.getpCheck(),(i-1)*2);
        }

        session.setAttribute("pageNow",i);
        session.setAttribute("PersionList",list1);
        return "show";
    }
    //跳转
    @RequestMapping("tiaozhuan")
    public String tiaozhuan(String page,HttpSession session){
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();
        int i=0;
        int j=0;

        if(session.getAttribute("selectdepersion")==null){
            i=(int)session.getAttribute("pageLarge");
            j=Integer.parseInt(page);
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.getSomePersion((j-1)*2);
        }else{
            Persion per=(Persion)session.getAttribute("selectdepersion");
            i=(int)session.getAttribute("pageLarge1");
            j=Integer.parseInt(page);
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.selectPersion(per.getpName(),per.getpTel(),per.getpAddress(),per.getpCheck(),(j-1)*2);
        }

        session.setAttribute("pageNow",j);
        session.setAttribute("PersionList",list1);
        return "show";
    }
    //上一页
    @RequestMapping("shangyiye")
    public String shangyiye(String page,HttpSession session){
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();

        int i=0;
        int j=0;

        if(session.getAttribute("selectdepersion")==null){
            i=(int)session.getAttribute("pageLarge");
            j=Integer.parseInt(page)-1;
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.getSomePersion((j-1)*2);
        }else{
            Persion per=(Persion)session.getAttribute("selectdepersion");
            i=(int)session.getAttribute("pageLarge1");
            j=Integer.parseInt(page)-1;
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.selectPersion(per.getpName(),per.getpTel(),per.getpAddress(),per.getpCheck(),(j-1)*2);
        }

        session.setAttribute("pageNow",j);
        session.setAttribute("PersionList",list1);
        return "show";
    }
    //下一页
    @RequestMapping("xiayiye")
    public String xiayiye(String page,HttpSession session){
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();

        int i=0;
        int j=0;

        if(session.getAttribute("selectdepersion")==null){
             i=(int)session.getAttribute("pageLarge");
             j=Integer.parseInt(page)+1;
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.getSomePersion((j-1)*2);
        }else{
            Persion per=(Persion)session.getAttribute("selectdepersion");
            i=(int)session.getAttribute("pageLarge1");
            j=Integer.parseInt(page)+1;
            if(j>i){
                j=i;
            }else if(j<1){
                j=1;
            }
            list1=ips.selectPersion(per.getpName(),per.getpTel(),per.getpAddress(),per.getpCheck(),(j-1)*2);
        }
        session.setAttribute("pageNow",j);
        session.setAttribute("PersionList",list1);
        return "show";
    }
    //修改
    @RequestMapping("updatepersion")
    public String updatepersion(Persion per,String pid,@RequestParam("file") MultipartFile file,HttpSession session)throws Exception{
        file.transferTo(new File("D:\\520\\idea\\maven_file\\mybatis01\\src\\main\\webapp\\img\\"+file.getOriginalFilename()));
        int p=Integer.parseInt(pid);
        per.setpId(p);
        per.setpPhoto(file.getOriginalFilename());
        System.out.println(per);
        IPersionService ips=new PersionServiceImpl();
        int i=ips.updatePersion(per);
        if(i>0){
            String msg="修改成功";
            session.setAttribute("message",msg);
            return "redirect:/seeList";
//            return "show";
        }else{
            return "redirect:/err.jsp";
        }

    }
    //查询操作
    @RequestMapping("chaxunpersion")
    public String chaxunpersion(String pName,String pTel,String pAddress,String pCheck,HttpSession session){
        Persion persion=new Persion();
        persion.setpName(pName);
        persion.setpTel(pTel);
        persion.setpAddress(pAddress);
        persion.setpCheck(pCheck);
        session.setAttribute("selectdepersion",persion);
        IPersionService ips=new PersionServiceImpl();
        List<Persion> list1=new ArrayList<Persion>();
        list1=ips.selectallPersion(pName,pTel,pAddress,pCheck);
        int i=0;
        if(list1.size()%2==0){
            i=list1.size()/2;
        }else{
            i=list1.size()/2+1;
        }
        session.setAttribute("pageLarge1",i);
        List<Persion> list=new ArrayList<Persion>();
        list=ips.selectPersion(pName,pTel,pAddress,pCheck,0);
        session.setAttribute("pageNow",1);
        session.setAttribute("PersionList",list);
        return "show";
    }
}
