package org.csc480.projectsite.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

	@RequestMapping("viewTest")
	public ModelAndView viewTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("test");
		return mav;
	}

	@RequestMapping("viewReports")
	public ModelAndView viewReports(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String reportsArray[] = { "BGCA Annual Report",
				"Weekly Attendance Report" };
		ModelAndView mav = new ModelAndView("reports");
		mav.addObject("reports", reportsArray);
		return mav;
	}
	
	@RequestMapping("configure")
	public ModelAndView configure(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("configure");
		return mav;
	}

	@RequestMapping("viewDefault")
	public ModelAndView viewDefault(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return new ModelAndView("index");
	}

}