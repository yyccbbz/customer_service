package com.evergrande.customer_service.test;

import com.evergrande.customer_service.mapper.CsUserMapper;
import com.evergrande.customer_service.model.CsUser;
import com.evergrande.customer_service.util.DateUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * Created by cuican on 2016-9-23.
 */
public class CsUserMapperTest extends BasicTest {

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void addCsUserTest() {
        //获取当前mapper
        CsUserMapper csUserMapper = sqlSession.getMapper(CsUserMapper.class);
        //批量添加用户
        for (int i = 0; i < 1000; i++) {
            CsUser csUser = new CsUser();

            csUserMapper.insert(csUser);
        }


    }

    /**
     * 产生18位的随机数
     *
     * @param a
     */
    public static void main(String[] a) {
        String s = "";
        Random random = new Random();
        s += random.nextInt(9) + 1;
        for (int i = 0; i < 18 - 1; i++) {
            s += random.nextInt(10);
            System.out.println("s = " + s);
        }
        BigInteger bigInteger = new BigInteger(s);
        System.out.println(bigInteger);
    }

}
