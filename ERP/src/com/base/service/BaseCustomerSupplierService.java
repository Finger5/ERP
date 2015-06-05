package com.base.service;

import com.base.entity.BaseCustomerSupplier;
import com.base.entity.PageBean;
import com.sun.org.apache.bcel.internal.classfile.Code;

public interface BaseCustomerSupplierService {
	public PageBean showAll(int pageNo,int pageSize);
	public PageBean findList(BaseCustomerSupplier bcs,int pageNo, int pageSize);
	public int addCustomer(BaseCustomerSupplier baseCustomerSupplier);
	public int update(BaseCustomerSupplier baseCustomerSupplier);
	public int deleteCustomer(String code);
	public BaseCustomerSupplier findBaseCustomerSupplier(String  Code);
}
