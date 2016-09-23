package com.evergrande.customer_service.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by cuican on 2016/9/23.
 */
public class PageMapperTest extends BasicTest {

//    @Autowired
//    private CountryMapper countryMapper;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test(){
//        CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
//        Example example = new Example(Country.class);
//        example.createCriteria().andGreaterThan("id",100);
//        PageHelper.startPage(2,10);
//        List<Country> countries = countryMapper.selectByExample(example);
//        PageInfo<Country> pageInfo = new PageInfo<Country>(countries);
//        System.out.println(pageInfo.getTotal());
//
//        countries = countryMapper.selectByExample(example);
//        pageInfo = new PageInfo<Country>(countries);
//        System.out.println(pageInfo.getTotal());
    }
}
