package org.blazer.bigclient.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class Test {

	@ResponseBody
	@RequestMapping("/say")
	public String say() {
		return "say~~~~~~~~~~";
	}

}
