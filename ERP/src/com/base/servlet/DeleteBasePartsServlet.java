package com.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.service.BasePartsService;
import com.base.service.impl.BasePartsServiceImpl;

public class DeleteBasePartsServlet extends HttpServlet {

	public DeleteBasePartsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	BasePartsService basePartsService=new BasePartsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		response.setContentType("text/json;charset=utf-8");
		String partsCode=request.getParameter("partsCode");
		int ret=basePartsService.deleteBaseParts(partsCode);		
		response.getWriter().println(ret);
	}

}
