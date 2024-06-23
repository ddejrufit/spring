package com.kang.dec042;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kang.dec042.error.ErrorDAO;


@Controller
public class HomeController {
	@Autowired
	private ErrorDAO eDAO;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		eDAO.getAllError(req);
		return "index";
	}
	
}
