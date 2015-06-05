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

public class ModifyBaseCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ModifyBaseCompanyServlet() {
		super();
	}
	private BaseCompanyService baseCompanyService = new BaseCompanyServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BaseCompany baseCompany = new BaseCompany();
		baseCompany.setCode(request.getParameter("code"));
		baseCompany.setCompName(request.getParameter("compName"));
		baseCompany.setCompAddress(request.getParameter("compAddress"));
		baseCompany.setCompPostCode(request.getParameter("compPostCode"));
		baseCompany.setCompPhone(request.getParameter("compPhone"));
		baseCompany.setCompFax(request.getParameter("compFax"));
		baseCompany.setCompUrl(request.getParameter("compUrl"));
		baseCompany.setCompEmail(request.getParameter("compEmail"));
		baseCompany.setCompLegaler(request.getParameter("compLegaler"));
		baseCompany.setCompAgent(request.getParameter("compAgent"));
		baseCompany.setAddUser(request.getParameter("addUser"));
		baseCompany.setCompBank(request.getParameter("compBank"));
		baseCompany.setCompTax(request.getParameter("compTax"));
		baseCompany.setRemarks(request.getParameter("remarks"));
		baseCompanyService.modifyBaseCompany(baseCompany);
		response.sendRedirect("BaseCompanySearchServlet");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
