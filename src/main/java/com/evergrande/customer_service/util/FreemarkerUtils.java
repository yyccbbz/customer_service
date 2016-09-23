package com.evergrande.customer_service.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

/**
 * Created by cuican on 2016-9-19.
 *
 * 用Freemarker来生成html字符串
 * freemarker是一种非常轻量易用的模板引擎，除了用于在web mvc框架中渲染html页面以外，
 * 还可以用在其他需要生成其他有复杂格式的文档，并且需要用数据进行格式化的场景下；
 * 将生成的字符串写入指定的Java流中。
 */
public class FreemarkerUtils {

    /**
     *
     *
     * @param baseDir   ftl文件的根目录
     * @param fileName  ftl文件的文件名
     * @param globalMap 用来格式化文档的数据
     * @return
     */
    public static String loadFtlHtml(File baseDir, String fileName, Map globalMap){
        if(baseDir == null || !baseDir.isDirectory() || globalMap ==null || fileName == null || "".equals(fileName)){
            throw new IllegalArgumentException("Directory file");
        }

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        try {
            cfg.setDirectoryForTemplateLoading(baseDir);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);//.RETHROW
            cfg.setClassicCompatible(true);
            Template temp = cfg.getTemplate(fileName);

            StringWriter stringWriter = new StringWriter();
            temp.process(globalMap, stringWriter);

            return stringWriter.toString();
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
            throw new RuntimeException("load fail file");
        }
    }


    /**
     * itext将html转换成PDF文档
     * itext生成PDF的代码比较简单，创建一个Document对象，
     * 然后XmlWorkerHelper会在指定的OutputStream中输入生成的pdf文件。
     *
     * @param out   输出流
     * @param html  Freemarker生成的html
     */
    public static void savePdf(OutputStream out, String html) {
        Document document = new Document(PageSize.A4, 50, 50, 60, 60);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, new StringReader(html));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }

}
