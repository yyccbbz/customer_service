package com.evergrande.customer_service.service;

import com.evergrande.customer_service.model.CsUser;
import com.evergrande.customer_service.util.IntegerUtil;
import com.evergrande.customer_service.util.StringUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-9-18.
 */
@Service
public class CsUserService extends BaseService<CsUser> {

    /**
     * 分页条件查询用户列表
     *
     * @param params
     * @return
     */
    public PageInfo<CsUser> findByPage(HashMap<String, String> params) {
        Example example = new Example(CsUser.class);
        Example.Criteria criteria = example.createCriteria();
        String search = StringUtil.getStrEmpty(params.get("search"));
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        PageHelper.startPage(IntegerUtil.getIntZero(params.get("currentPage")), IntegerUtil.getIntZero(params.get("pageSize")));
        List<CsUser> list = selectByExample(example);
        return new PageInfo<CsUser>(list);
    }

    /**
     * 根据条件查询外部拓展用户集合，
     * 用于前台页面的Excel导出
     *
     * @param search
     * @return
     */
    public List<CsUser> findBySearch(String search) {
        Example example = new Example(CsUser.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(search)) {
            criteria.andCondition("phone_number like '%" + search + "%'" + " or user_name like '%" + search + "%'");
        }
        List<CsUser> list = selectByExample(example);
        return list;

    }
}
