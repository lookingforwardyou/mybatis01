package com.service.impl;

import com.dao.PersionMapper;
import com.pojo.Persion;
import com.service.IPersionService;
import com.utils.MybatisSession;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class PersionServiceImpl implements IPersionService {
    @Override
    public Integer addPersion(Persion persion) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        int i=persionMapper.addPersion(persion);
        if(i>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return i;
    }

    @Override
    public Persion getPersion(String pName) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        Persion persion=persionMapper.getPersion(pName);
        return persion;
    }

    @Override
    public List<Persion> getAllPersion() {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        List<Persion> list=new ArrayList<Persion>();
        list=persionMapper.getAllPersion();
        return list;
    }

    @Override
    public Integer updateCheck(Integer pId) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        int i=persionMapper.updateCheck(pId);
        if(i>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return i;
    }

    @Override
    public List<Persion> getSomePersion(Integer pagenow) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        List<Persion> list=new ArrayList<Persion>();
        list=persionMapper.getSomePersion(pagenow);
        return list;
    }

    @Override
    public Integer updatePersion(Persion persion) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        int i=persionMapper.updatePersion(persion);
        if(i>0){
            sqlSession.commit();
        }else{
            sqlSession.rollback();
        }
        return i;
    }

    @Override
    public List<Persion> selectPersion(String pName,String pTel,String pAddress,String pCheck,Integer pagenow) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        List<Persion> list=new ArrayList<Persion>();
        list=persionMapper.selectPersion(pName,pTel,pAddress,pCheck,pagenow);
        return list;
    }

    @Override
    public List<Persion> selectallPersion(String pName, String pTel, String pAddress, String pCheck) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        PersionMapper persionMapper=sqlSession.getMapper(PersionMapper.class);
        List<Persion> list=new ArrayList<Persion>();
        list=persionMapper.selectallPersion(pName,pTel,pAddress,pCheck);
        return list;
    }
}
