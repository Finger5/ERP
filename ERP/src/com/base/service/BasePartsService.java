package com.base.service;

import com.base.entity.BaseParts;
import com.base.entity.PageBean;

public interface BasePartsService {
	
	public PageBean findAll(BaseParts bp, int pageNo,int pageSize);
	
    public int insertBaseParts(BaseParts baseParts); //���������Ϣ
	
	public int deleteBaseParts(String partsCode);  //ɾ�������Ϣ
	
	public int update(BaseParts baseParts);
	
}
