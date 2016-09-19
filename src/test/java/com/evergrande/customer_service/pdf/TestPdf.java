package com.evergrande.customer_service.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cuican on 2016-9-19.
 */
public class TestPdf {
    @Test
    public void test() throws IOException, DocumentException {
        String fileName = "D:/template.pdf"; // pdf模板
        PdfReader reader = new PdfReader(fileName);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        PdfStamper ps = new PdfStamper(reader, bos);
        AcroFields fields = ps.getAcroFields();
        fillData(fields, data());
        ps.setFormFlattening(true);
        ps.close();
        OutputStream fos = new FileOutputStream("D:/contract.pdf");
        fos.write(bos.toByteArray());
    }

    public void fillData(AcroFields fields, Map<String, String> data) throws IOException, DocumentException {
        for (String key : data.keySet()) {
            String value = data.get(key);
            fields.setField(key, value);
        }
    }

    public Map<String, String> data() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("borrower", "胡桃同学");
        return data;
    }
}
