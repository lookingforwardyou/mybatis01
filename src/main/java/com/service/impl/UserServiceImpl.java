package com.service.impl;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.IUserService;
import com.utils.MybatisSession;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements IUserService {
    @Override
    public User getUser(User user) {
        SqlSession sqlSession= MybatisSession.getSqlSession();
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User users=userMapper.getUser(user);
        return users;
    }
}
