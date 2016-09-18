package org.blazer.bigclient.util;

import org.blazer.bigclient.model.BcExcel;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cc on 16-8-31.
 *
 * Excel上传导入处理
 */
public class ExcelHandlerUtil {

    public static BcExcel getExcelFile(CommonsMultipartFile file, HttpServletRequest request) {

        // 获取文件名
        String originalFileName = file.getOriginalFilename();
        // 取得后缀
        String suffixString = UploadUtil.getExtensionName(originalFileName);
        // 取得IP地址
        String ip = IPUtil.getIpAddr(request);
        // 设定目标文件名
        String targetFileName = UploadUtil.getNewFileName(ip, suffixString);
        System.out.println("目标文件名fileName = " + targetFileName);

        //设置目标文件夹地址
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println("项目所在绝对路径地址realPath = " + realPath);
        String[] strs = realPath.split("target");
        System.out.println(strs[0]);
        String targetDirectory = strs[0] + "src\\upload\\";
        System.out.println("标文件夹地址targetDirectory = " + targetDirectory);

        // 将Excle文件名称和路径存到数据库中
        BcExcel bcExcel = new BcExcel();
        bcExcel.setExcelName(originalFileName);
        bcExcel.setExcelRealName(targetFileName);
        bcExcel.setExcelRealPath(targetDirectory);

        System.out.println("bcExcel = " + bcExcel);

        return bcExcel;
    }


}
