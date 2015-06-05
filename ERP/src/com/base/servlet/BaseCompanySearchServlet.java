package com.base.servlet;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entity.BaseCompany;
import com.base.service.BaseCompanyService;
import com.base.service.impl.BaseCompanyServiceImpl;

public class BaseCompanySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BaseCompanySearchServlet() {
		super();
	}
	private BaseCompanyService baseCompanyService = new BaseCompanyServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BaseCompany baseCompany = baseCompanyService.searchBaseCompany();
		request.getSession().setAttribute("baseCompany", baseCompany);
		response.sendRedirect("/ERP/base/baseCompany.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
