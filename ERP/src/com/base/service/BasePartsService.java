package com.base.service;

import com.base.entity.BaseParts;
import com.base.entity.PageBean;

public interface BasePartsService {
	
	public PageBean findAll(BaseParts bp, int pageNo,int pageSize);
	
    public int insertBaseParts(BaseParts baseParts); //插入配件信息
	
	public int deleteBaseParts(String partsCode);  //删除配件信息
	
	public int update(BaseParts baseParts);
	
}
