package com.evergrande.customer_service.action;

import com.evergrande.customer_service.excel.ExcelHeader;
import com.evergrande.customer_service.model.CsUser;
import com.evergrande.customer_service.service.CsUserService;
import com.evergrande.customer_service.util.DateUtil;
import com.evergrande.customer_service.util.IntegerUtil;
import com.evergrande.customer_service.util.StringUtil;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by cuican on 2016-9-18.
 */
@RequestMapping("/cs")
@Controller
public class CsUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CsUserController.class);

    @Autowired
    private CsUserService csUserService;

    /**
     * 根据搜索条件分页查询列表
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<CsUser> listAllUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return csUserService.findByPage(params);
    }

    /**
     * 根据查询条件导出excel文件
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "export/excel",method = RequestMethod.POST)
    public ModelAndView exportExcel(HttpServletRequest request) {

        //根据条件获取要导出的数据集合
        String search = StringUtil.getStrEmpty(request.getParameter("search"));
        LOGGER.debug("search:" + search);
        List<CsUser> list = csUserService.findBySearch(search);
        //xml配置中的ID
        String id = "csUser";
        //excel文件名称,不需要任何后缀
        String excelName = "CsUser_Export_"+ DateUtil.thisDateTime();
        //可以为空,自定义Excel头信息
        ExcelHeader header = null;
        //指定导出字段
        List<String> specifyFields = new ArrayList<String>();
        /*<field name="id" title="id"/>
		<field name="phoneNumber" title="手机号码"/>
		<field name="productName" title="产品名称"/>
		<field name="settlementCapital" title="投资金额"/>
		<field name="inceptionDate" title="投资起始时间"/>
		<field name="dueDate" title="投资到期时间"/>
		<field name="idNo" title="证件号码"/>
		<field name="userName" title="客户姓名"/>
		<field name="mtime" title="更新时间" pattern="yyyy-MM-dd HH:mm:ss"/>
		<field name="ctime" title="创建时间" pattern="yyyy-MM-dd HH:mm:ss"/>*/
        specifyFields.add("phoneNumber");
        specifyFields.add("productName");
        specifyFields.add("settlementCapital");
        specifyFields.add("inceptionDate");
        specifyFields.add("dueDate");
        specifyFields.add("idNo");
        specifyFields.add("userName");

        //构建excel试图
        ModelAndView mv = super.createExcelView(id, list, excelName, header, specifyFields);
        return mv;
    }

}
