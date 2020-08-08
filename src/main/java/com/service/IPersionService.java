package com.service;

import com.pojo.Persion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IPersionService {
    Integer addPersion(Persion persion);
    Persion getPersion(String pName);
    List<Persion> getAllPersion();
    Integer updateCheck(@Param("pId") Integer pId);
    List<Persion> getSomePersion(Integer pagenow);
    Integer updatePersion(Persion persion);
    List<Persion> selectPersion(String pName,String pTel,String pAddress,String pCheck,Integer pagenow);
    List<Persion> selectallPersion( String pName,String pTel,String pAddress,String pCheck);
        }
