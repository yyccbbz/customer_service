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
            csUser.setPhoneNumber(18899990000L + i);
            csUser.setProductName("国庆节专享ABC" + i + "期" + i + "号");
            csUser.setSettlementCapital(10000d + i);
            csUser.setInceptionDate(new Date());
            csUser.setDueDate(new Date());
            String s = "";
            Random random = new Random();
            s += random.nextInt(9) + 1;
            for (int j = 0; j < 18 - 1; j++) {
                s += random.nextInt(10);
            }
            csUser.setIdNo(s);
            csUser.setUserName("张三三" + i);
            csUser.setMtime(DateUtil.getFirstDateOfMonth(new Date()));
            csUser.setCtime(csUser.getMtime());
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
