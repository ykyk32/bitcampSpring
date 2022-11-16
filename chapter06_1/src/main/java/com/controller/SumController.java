package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {

	//@RequestMapping(value="/input.do",method = RequestMethod.GET)
	@GetMapping(value="input.do")
	public String input(){//사용자가 만든 콜백 메소드
		return "sum/input";//input.jsp알아서 찾는다		
	}
//	@GetMapping(value="/result.do")
//	public String result() {
//		return "sum/result";
//	}
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam int x,@RequestParam int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("sum/result");
//		return mav;
//		//400에러 -인자 2개주기로 해놓고 2개 안 줬을때
//	}
//	@GetMapping(value="/result.do")
//	public ModelAndView result(@RequestParam(required = false, defaultValue ="0") String x,
//							   @RequestParam(required = false, defaultValue ="0") String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("sum/result");
//		return mav;
//	}
	
//	@GetMapping(value="/result.do")
//	public String result(@RequestParam Map<String,String> map, ModelMap modelMap){
//		modelMap.put("x", map.get("x"));
//		modelMap.put("y", map.get("y"));
//		
//		return "sum/result";
//	}
	
	@GetMapping(value="/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model){
		model.addAttribute("x",sumDTO.getX());
		model.addAttribute("y",sumDTO.getY());
		
		return "sum/result";
	}
}
