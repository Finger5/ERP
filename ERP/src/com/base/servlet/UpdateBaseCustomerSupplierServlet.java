package com.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entity.BaseCustomerSupplier;
import com.base.service.BaseCustomerSupplierService;
import com.base.service.impl.BaseCustomerSupplierServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class UpdateBaseCustomerSupplierServlet extends HttpServlet {

	public UpdateBaseCustomerSupplierServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	BaseCustomerSupplierService customerService=new BaseCustomerSupplierServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp; charset=utf-8");

		String opt=request.getParameter("opt");
		BaseCustomerSupplier baseCustomerSupplier=new BaseCustomerSupplier();
		baseCustomerSupplier.setCode(request.getParameter("code"));
        baseCustomerSupplier.setCsName(request.getParameter("csName"));
        baseCustomerSupplier.setContacter(request.getParameter("contacter"));
        baseCustomerSupplier.setTelephone(request.getParameter("telephone"));
        baseCustomerSupplier.setFax(request.getParameter("fax"));
//        baseCustomerSupplier.setAddDate(new Date());
        baseCustomerSupplier.setPostCode(request.getParameter("postCode"));
        baseCustomerSupplier.setEmail(request.getParameter("email"));
        baseCustomerSupplier.setProvince(request.getParameter("province"));
        baseCustomerSupplier.setCity(request.getParameter("city"));
        baseCustomerSupplier.setAddress(request.getParameter("address"));
        baseCustomerSupplier.setLegaler(request.getParameter("legaler"));
        baseCustomerSupplier.setUrl(request.getParameter("url"));
        baseCustomerSupplier.setQQ(request.getParameter("QQ"));
        baseCustomerSupplier.setMSN(request.getParameter("MSN"));
        baseCustomerSupplier.setAliwang(request.getParameter("aliwang"));
        baseCustomerSupplier.setAgent(request.getParameter("agent"));
        baseCustomerSupplier.setBank(request.getParameter("bank"));
        baseCustomerSupplier.setAccount(request.getParameter("account"));
        baseCustomerSupplier.setTax(request.getParameter("tax"));
        baseCustomerSupplier.setCategorycode(request.getParameter("categorycode"));
        baseCustomerSupplier.setIsShow(request.getParameter("isShow"));
        baseCustomerSupplier.setRemarks(request.getParameter("remarks"));
        
		if(opt!=null&&opt.equals("1")){	
			customerService.addCustomer(baseCustomerSupplier);
			response.sendRedirect("/ERP/base/BaseCustomerSupplier.jsp");
		}
		else{
		//	String code = baseCustomerSupplier.getCode();
		//	customerService.findBaseCustomerSupplier(code);
			customerService.update(baseCustomerSupplier);
			response.sendRedirect("/ERP/base/BaseCustomerSupplier.jsp");
		}
	}

}
