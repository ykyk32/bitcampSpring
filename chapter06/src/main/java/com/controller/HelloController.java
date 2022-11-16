package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do",method = RequestMethod.GET)
	public ModelAndView hello(){//사용자가 만든 콜백 메소드
		ModelAndView mav = new ModelAndView();
		//mav.addObject("변수명","값");
		mav.addObject("result","Have a nice day!!");
		//mav.setViewName("/view/hello.jsp");//web에 띄울 jsp이름
		//mav.setViewName("hello");//resolver가 결정하니까 .jsp뺀다//=>/view./hello.jsp
		//resolver는 dispatcherServlet-servlet.xml에 있음
		mav.setViewName("/WEB-INF/view/hello");
		return mav;
	}
	@RequestMapping(value="/hello2.do",method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody
	public String hello2() {
		//return "Welcome";
		return "환영합니다.";
	}
	//스프링에서는 리턴타입이 String이면 단순문자열이 아니라, 파일명으로 인식한다.
	//스프링은 Welcome.jsp 파일을 찾는다.
	//만약 단순문자열로 웹에 나차내려면 @ResponseBody를 써야한다.
}
