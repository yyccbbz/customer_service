package org.blazer.bigclient.action;

import org.blazer.bigclient.excel.ExcelContext;
import org.blazer.bigclient.excel.ExcelHeader;
import org.blazer.bigclient.view.ExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hyy
 */
public class BaseController {

	@Autowired
	protected ExcelContext excelContext;

	public HashMap<String, String> getParamMap(HttpServletRequest request) {
		HashMap<String, String> paramMap = new HashMap<String, String>();
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			paramMap.put(key, request.getParameter(key));
		}
		return paramMap;
	}

	/**
	 * 创建Excel视图
	 * @param id xml配置中的ID
	 * @param beans 对应class的类型集合
	 * @param excelName excel文件名称,不需要任何后缀
	 * @param header 可以为空,自定义Excel头信息
	 * @param fields 指定导出的字段
	 * @return
	 */
	protected ModelAndView createExcelView(String id, List<?> beans, String excelName, ExcelHeader header, List<String> fields){
		ModelAndView view = new ModelAndView("excelView");
		view.addObject(ExcelView.EXCEL_ID, id)
				.addObject(ExcelView.EXCEL_BEANS, beans)
				.addObject(ExcelView.EXCEL_NAME, excelName)
				.addObject(ExcelView.EXCEL_HEADER, header)
				.addObject(ExcelView.EXCEL_FIELDS, fields);
		return view;
	}

}
