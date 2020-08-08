package com.dao;

import com.pojo.Persion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersionMapper {
    Integer addPersion(Persion persion);
    Persion getPersion(@Param("pName") String pName);
    List<Persion> getAllPersion();
    Integer updateCheck(@Param("pId") Integer pId);
    List<Persion> getSomePersion(@Param("pagenow") Integer pagenow);
    Integer updatePersion(Persion persion);
    List<Persion> selectPersion(@Param("pName") String pName,@Param("pTel")String pTel,@Param("pAddress")String pAddress,@Param("pCheck")String pCheck,@Param("pagenow")Integer pagenow);
    List<Persion> selectallPersion(@Param("pName") String pName,@Param("pTel")String pTel,@Param("pAddress")String pAddress,@Param("pCheck")String pCheck);
}
