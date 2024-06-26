package com.kang.nov301;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kang.nov301.student.StudentDAO;
import com.kang.nov301.test.TestDAO;


@Controller
public class HomeController {

	@Autowired
	private StudentDAO sDAO; // StudentDAO.getSDAO.getAllStudent();
	
	@Autowired
	private TestDAO tDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		sDAO.getAllStudent(req);
		tDAO.getAllTest(req);
		
		return "index";
	}
	
}
