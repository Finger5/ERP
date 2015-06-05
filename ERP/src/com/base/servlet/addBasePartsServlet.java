package com.base.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.base.entity.BaseParts;
import com.base.service.BasePartsService;
import com.base.service.impl.BasePartsServiceImpl;

public class addBasePartsServlet extends HttpServlet {

	public addBasePartsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	BasePartsService basePartsService=new BasePartsServiceImpl();
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opt=request.getParameter("opt");  //获取前页选择添加/修改的opt
		
		String partsCode=request.getParameter("code");
		String partsName=request.getParameter("name");
		String partsCategory=request.getParameter("type");
		String partsBrand=request.getParameter("brand");
		String partsModel=request.getParameter("model");
		String partsNo=request.getParameter("no");
		String partsModelOld=request.getParameter("modelOld");
		String partsSize=request.getParameter("size");
		String partsWeight=request.getParameter("weight");
	//	String[] partsImg=request.getParameter("img");
		String partsUnit=request.getParameter("unit");
		String isShow=request.getParameter("isShow");
		String remarks=request.getParameter("remarks");
		String salePrice=request.getParameter("price");
		
		BaseParts baseParts=new BaseParts();
		baseParts.setPartsCode(partsCode);
		baseParts.setPartsName(partsName);
		baseParts.setPartsCategory(partsCategory);
		baseParts.setPartsBrand(partsBrand);
		baseParts.setPartsModel(partsModel);
		baseParts.setPartsModelOld(partsModelOld);
		baseParts.setPartsSize(partsSize);
		baseParts.setPartsWeight(partsWeight);
		baseParts.setPartsUnit(partsUnit);
		baseParts.setIsShow(isShow);
		baseParts.setRemarks(remarks);
		baseParts.setPartsNo(partsNo);
		baseParts.setSalePrice(Integer.parseInt(salePrice));
		
		if(opt!=null&&opt.equals("1")){           //执行添加
	
			basePartsService.insertBaseParts(baseParts);  //调用添加方法
			
		}else{    //执行修改
			
			basePartsService.update(baseParts);
			
		}
		response.sendRedirect("/ERP/base/baseParts.jsp");
	}
		
		
		
	}


