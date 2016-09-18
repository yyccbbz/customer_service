package org.blazer.bigclient.action;

import com.github.pagehelper.PageInfo;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.blazer.bigclient.body.AjaxResult;
import org.blazer.bigclient.excel.ExcelException;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.excel.vo.ExcelImportResult;
import org.blazer.bigclient.model.BcExcel;
import org.blazer.bigclient.model.BcExternalUser;
import org.blazer.bigclient.model.BcExternalUserBackup;
import org.blazer.bigclient.service.BcExternalUserBackupService;
import org.blazer.bigclient.service.BcExternalUserService;
import org.blazer.bigclient.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


/**
 * Created by cuican on 2016-8-26.
 */
@RequestMapping("/ext")
@Controller
public class BcExternalUserController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BcExternalUserController.class);

    @Autowired
    private BcExternalUserService bcExternalUserService;

    @Autowired
    private BcExternalUserBackupService bcExternalUserBackupService;

    //设置文件允许上传的类型
    private static final HashMap<String, String> TypeMap = new HashMap<String, String>();

    static {
        TypeMap.put("image", "gif,jpg,jpeg,png,bmp");
        TypeMap.put("flash", "swf,flv");
        TypeMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
        TypeMap.put("file", "doc,docx,xls,xlsx,ppt,pptx,htm,html,txt,dwg,pdf");
    }

    // 设置文件上传大小
    public static long fileSize = 30 * 1024 * 1024;

    /**
     * 根据搜索条件分页查询列表
     *
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("findByPage")
    public PageInfo<BcExternalUser> listAllUserByPage(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> params = getParamMap(request);
        LOGGER.debug("currentPage:" + IntegerUtil.getIntZero(params.get("currentPage")) +
                ", pageSize:" + IntegerUtil.getIntZero(params.get("pageSize")) +
                ", search:" + StringUtil.getStrEmpty(params.get("search")));
        return bcExternalUserService.findByPage(params);
    }


    /**
     * 手动新增单个用户
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addOneUser", method = RequestMethod.POST)
    public AjaxResult addOneUser(HttpServletRequest request){
        LOGGER.debug("新添加的用户的手机号是 :" + request.getParameter("phoneNumber"));
        AjaxResult result = AjaxResult.success("新添加用户成功...");



        System.out.println("result = " + result);
        return result;

    }

    /**
     * 根据id查询单个用户信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "selectOneById")
    public AjaxResult selectOneById(HttpServletRequest request){

        LOGGER.debug("当前查询的用户的ID编号是 :" + LongUtil.getLongZero(request.getParameter("id")));
        AjaxResult result = AjaxResult.success("查询单个用户信息成功。。。");
        try {
            //获取用户id
            long id = LongUtil.getLongZero(request.getParameter("id"));
            System.out.println("id = " + id);
            //查询数据库
            BcExternalUser bcExternalUser = this.bcExternalUserService.selectByKey(id);
            result.setObj(bcExternalUser);
            if(bcExternalUser == null){
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该用户信息不存在。。。");
                return result;
            }
        } catch (Exception e) {
            result.setCode(AjaxResult.CODE_FAILURE);
            result.setMsg("查询用户信息失败。。。"+e.getMessage());
            e.printStackTrace();
        }

        System.out.println("result = " + result);
        return result;
    }


    /**
     * 根据id修改单个用户信息
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "editById", method = RequestMethod.POST)
    public AjaxResult editUserById(HttpServletRequest request){
        LOGGER.debug("当前该修改的用户手机号是 :" + request.getParameter("phoneNumber"));

        AjaxResult result = AjaxResult.success("修改该用户信息成功...");






        return result;

    }


    /**
     * 根据id删除单个用户
     *
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteById", method = RequestMethod.POST)
    public AjaxResult deleteUserById(HttpServletRequest request){
        LOGGER.debug("当前被删除用户的手机号是 :" + request.getParameter("phoneNumber"));

        AjaxResult result = AjaxResult.success("删除该用户成功...");


        return result;

    }



    /**
     * Excel导入
     *
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public AjaxResult importExcel(@RequestParam("fileExcel") CommonsMultipartFile file, HttpServletRequest request) {

        LOGGER.debug("该上传的excel文件的原文件名是 :" + file.getOriginalFilename());

        AjaxResult result = AjaxResult.success("导入数据成功...");

	/*	User loginUser = (User) request.getSession().getAttribute("loginUser");
        // 判断SESSION是否失效
		if (loginUser == null || "".equals(loginUser)) {
			return "250";
		}
		int loginUserId = loginUser.getUserId();*/

        if (!file.isEmpty()) {

            //判断请求类型是否为文件上传类型
            if (!ServletFileUpload.isMultipartContent(request)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该请求上传文件失败，请联系技术支持。。。");
                return result;
            }

            //当文件超过设置的大小时，则不运行上传
            if (file.getSize() > fileSize) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("该文件大小超限制，请更换较小的文件重新上传。。。");
                return result;
            }

            //获取文件名后缀
            String OriginalFilename = file.getOriginalFilename();
            String fileSuffix = OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1).toLowerCase();
            System.out.println("fileSuffix = " + fileSuffix);

            //判断该类型的文件是否在允许上传的文件类型内
            Arrays.asList();
            if (!Arrays.asList(TypeMap.get("file").split(",")).contains(fileSuffix)) {
                result.setCode(AjaxResult.CODE_FAILURE);
                result.setMsg("请检查上传的Excle文件的格式是否正确。。。");
                return result;
            }

            try {
                // 获取BcExcel对象
                BcExcel bcExcel = ExcelHandlerUtil.getExcelFile(file, request);
                bcExcel.setServiceId(1);
                bcExcel.setUserId(1L);
                bcExcel.setMtime(new Date());
                bcExcel.setCtime(bcExcel.getMtime());
                System.out.println("bcExcel = " + bcExcel);

                result.setObj(bcExcel);

                // 读取excel文件
                String excelType = "bcExternalUserBackup";
                ExcelImportResult readExcel = excelContext.readExcel(excelType, file.getInputStream());
                List<BcExternalUserBackup> listBean = readExcel.getListBean();
                bcExternalUserBackupService.importExcelData(listBean, bcExcel);

                // 上传文件
                UploadUtil.copy(file, bcExcel.getExcelRealPath(), bcExcel.getExcelRealName());
            } catch (Exception e) {
                result.setCode(AjaxResult.CODE_FAILURE);
                if (e instanceof ExcelException) {
                    result.setMsg(e.getMessage());
                } else {
                    if (e instanceof InvalidFormatException) {
                        result.setMsg("错误的文件格式。。。");
                    }
                    result.setMsg(e.getMessage());
                    e.printStackTrace();
                    LOGGER.error(e.getMessage());
                }
            }
        }

        System.out.println("result = " + result);
        return result;
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
        List<BcExternalUser> list = bcExternalUserService.findBySearch(search);
        //xml配置中的ID
        String id = "bcExternalUser";
        //excel文件名称,不需要任何后缀
        String excelName = "ExternalUser_Export_"+ DateUtil.thisDateTime();
        //可以为空,自定义Excel头信息
        ExcelHeader header = null;
        //指定导出字段
        List<String> specifyFields = new ArrayList<String>();
        specifyFields.add("phoneNumber");
        specifyFields.add("sysName");
        specifyFields.add("sysIfRegister");
        specifyFields.add("sysRegisterDate");
        specifyFields.add("sysIfRealName");
        specifyFields.add("sysIfBindCard");
        specifyFields.add("sysIfTransaction");
        specifyFields.add("sysReferrer");
        specifyFields.add("sysRebateExpirationDate");

        //构建excel试图
        ModelAndView mv = super.createExcelView(id, list, excelName, header, specifyFields);
        return mv;
    }


}
