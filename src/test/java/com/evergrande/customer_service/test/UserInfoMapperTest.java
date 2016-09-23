package com.evergrande.customer_service.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cuican on 2016-8-15.
 *
 * 往数据库里添加用户
 *
 */
public class UserInfoMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test(){
//        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsername("seoul");
//        userInfo.setPassword(DigestUtils.md5Hex("111111"));
//        userInfoMapper.insert(userInfo);
//        System.out.println(userInfo.getUsername());
//        System.out.println(userInfo.getPassword());
    }

}
