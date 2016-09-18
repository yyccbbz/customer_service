package org.blazer.bigclient.view;

import org.apache.commons.collections.MapUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.blazer.bigclient.excel.ExcelContext;
import org.blazer.bigclient.excel.ExcelHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;



/**
 * Created by cuican on 2016-9-1.
 */
/**
 * Excel视图解析器
 * @author lisuo
 *
 */
@Component
public class ExcelView extends AbstractView{

    /** Excel 名称 */
    public static final String EXCEL_NAME = "Excel.excelName";
    /** Excel ID */
    public static final String EXCEL_ID = "Excel.id";
    /** Excel 数据名称 */
    public static String EXCEL_BEANS = "Excel.beans";
    /** Excel 头信息名称 */
    public static String EXCEL_HEADER = "Excel.header";
    /** Excel 动态字段信息 */
    public static String EXCEL_FIELDS = "Excel.fields";

    /** 文件后缀 */
    public static final String FILE_SUFFIX = ".xlsx";

    /** 文件编码 */
    public static final String UTF8 = "UTF-8";
    /** 用户浏览器关键字：IE */
    private static final String USER_AGENT_IE = "MSIE";


    /** 注入Excel上下文 */
    @Autowired
    private ExcelContext excelContext;

    @Override
    public void setContentType(String contentType) {
        super.setContentType("application/vnd.ms-excel");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        String excelName = MapUtils.getString(model, EXCEL_NAME);
        String id = MapUtils.getString(model, EXCEL_ID);
        List<?> beans = (List<?>) model.get(EXCEL_BEANS);
        Object header = model.get(EXCEL_HEADER);
        Object fields = model.get(EXCEL_FIELDS);
        Workbook workbook = excelContext.createExcel(id, beans,header==null?null:(ExcelHeader)header,fields ==null?null:(List<String>)fields);
        if(workbook!=null){
            excelName = encodeDownloadFileName(request,excelName+FILE_SUFFIX);
            response.setContentType(getContentType());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + excelName + "\";target=_blank");
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        }else{
            response.setContentType("text/html; charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("<script language='javascript'>"
                    + "alert('没有可以导出的数据');"
                    + "window.location = "+request.getContextPath()+"/"
                    + "</script>");
            writer.flush();
            writer.close();
        }
    }

    /**
     * 根据不同的浏览器设置下载文件名称的编码
     * @param request
     * @param fileName
     * @return 文件名称
     */
    public static String encodeDownloadFileName(HttpServletRequest request,String fileName){
        String userAgent = request.getHeader("User-Agent");
        if(userAgent.indexOf(USER_AGENT_IE)>0){//用户在用IE
            try {
                return URLEncoder.encode(fileName, UTF8);
            } catch (UnsupportedEncodingException ignore) {}
        }else{
            try {
                return new String(fileName.getBytes(UTF8), "ISO-8859-1");
            } catch (UnsupportedEncodingException ignore) {}
        }
        return fileName;
    }

}

