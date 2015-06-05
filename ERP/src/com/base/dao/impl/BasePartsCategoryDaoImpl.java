package com.base.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.base.dao.BaseDao;
import com.base.dao.BasePartsCategoryDao;
import com.base.entity.BasePartsCategory;
import com.base.entity.PageBean;

public class BasePartsCategoryDaoImpl extends BaseDao implements
		BasePartsCategoryDao {

	public PageBean findAll(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from BASEPARTSCATEGORY order by CODE ";

		// if(code!=null&&!code.equals("")){
		// sql+="and code="+code;
		//
		// }
		// if(code!=null&&!code.equals("")){
		// sql+="and code="+code;
		//
		// }

		ResultSet rs = super.excuteQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean = new PageBean();
		List<BasePartsCategory> basePartScategories = new ArrayList<BasePartsCategory>();
		BasePartsCategory basePartScategory = null;
		try {
			while (rs.next()) {
				basePartScategory = new BasePartsCategory();
				basePartScategory.setCode(rs.getString("CODE"));
				basePartScategory.setCateGoryName(rs.getString("CATEGORYNAME"));
				basePartScategory.setAddDate(rs.getDate("ADDDATE"));
				basePartScategory.setRemarks(rs.getString("REMARKS"));
				basePartScategory.setAddUserName(rs.getString("ADDUSERNAME"));
				basePartScategory.setIsShow(rs.getString("ISSHOW"));
				basePartScategories.add(basePartScategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setData(basePartScategories);
		sql = "select count(*) from BASEPARTSCATEGORY";
		int total = super.executeTotalCount(sql);
		pageBean.setRecordCount(total);
/*		pageBean.setPageCount(total % pageSize == 0 ? total / pageSize : total
				/ pageSize + 1);*/
		return pageBean;
	}

	public PageBean findAll(String code, String pCode, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		String sql = "select * from BASEPARTSCATEGORY where 1=1 ";

		if (code != null && !code.equals("")) {
			sql += "and CODE like "+"'%" +code+"%'";

		}
		if (pCode != null && !pCode.equals("")) {
			sql += "and PCODE like "+"'%"+ pCode+"%'";

		}
		sql += "order by CODE"; 
		ResultSet rs = super.excuteQueryForPage(sql, pageNo, pageSize);
		PageBean pageBean = new PageBean();
		List<BasePartsCategory> basePartScategories = new ArrayList<BasePartsCategory>();
		BasePartsCategory basePartScategory = null;
		try {
			while (rs.next()) {
				basePartScategory = new BasePartsCategory();
				basePartScategory.setCode(rs.getString("CODE"));
				basePartScategory.setCateGoryName(rs.getString("CATEGORYNAME"));
				basePartScategory.setAddDate(rs.getDate("ADDDATE"));
				basePartScategory.setRemarks(rs.getString("REMARKS"));
				basePartScategory.setAddUserName(rs.getString("ADDUSERNAME"));
				basePartScategory.setIsShow(rs.getString("ISSHOW"));
				basePartScategory.setpCode(rs.getString("PCODE"));
				basePartScategories.add(basePartScategory);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pageBean.setData(basePartScategories);
		sql = "select count(*) from BASEPARTSCATEGORY";
		int total = super.executeTotalCount(sql);
		pageBean.setRecordCount(total);
		/*pageBean.setPageCount(total % pageSize == 0 ? total / pageSize : total
				/ pageSize + 1);*/
		return pageBean;
	}

	public int insert(BasePartsCategory basePartScategory) {
		// TODO Auto-generated method stub
		String sql = "insert into BASEPARTSCATEGORY(CODE,PCODE,CATEGORYNAME,ISSHOW,REMARKS,COMPCODE,"
				+ "ADDDATE,ADDUSER,ADDUSERNAME,ADDIP) "
				+ "values(?,?,?,?,?,?,sysdate,?,?,?) ";
		int ret = super.executeUpdate(
				sql,
				new Object[] { basePartScategory.getCode(),
						basePartScategory.getpCode(),
						basePartScategory.getCateGoryName(),
						basePartScategory.getIsShow(),
						basePartScategory.getRemarks(),
						basePartScategory.getCompCode(),
						basePartScategory.getAddUser(),
						basePartScategory.getAddUserName(),
						basePartScategory.getAddIp() });
		if (ret == 1) {
			ret = this.findMaxCode();
			// sql = "select max(CODE) from BASEPARTSCATEGORY";
			// ret = super.executeQueryForNewId(sql);
		}
		return ret;
	}

	@Override
	public int update(BasePartsCategory basePartScategory, String code) {
		// TODO Auto-generated method stub
		// String sql =
		// "update BASEPARTSCATEGORY set PCODE=?,CATEGORYNAME=?,ISSHOW=?,REMARKS=?,COMPCODE=?,"
		// + "ADDDATE=?,ADDUSER=?,ADDUSERNAME=?,ADDIP=? where CODE=?";
		String sql = "update BASEPARTSCATEGORY set PCODE=?,CATEGORYNAME=?,ISSHOW=?,REMARKS=?,ADDDATE=sysdate where CODE=?";
		return super.executeUpdate(
				sql,
				new Object[] { basePartScategory.getpCode(),
						basePartScategory.getCateGoryName(),
						basePartScategory.getIsShow(),
						basePartScategory.getRemarks(),
						// basePartScategory.getCompCode(),
						// basePartScategory.getAddDate(),
						// basePartScategory.getAddUser(),
						// basePartScategory.getAddUserName(),
						// basePartScategory.getAddIp(),
						code });
	}

	@Override
	public int delete(String code) {
		// TODO Auto-generated method stub
		String sql = "delete BASEPARTSCATEGORY where CODE=?";
		return super.executeUpdate(sql, new Object[] { code });
	}

	// public int delete(String code) {
	// String sql = "delete BASEPARTSCATEGORY where CODE="+"'"+code+"'";
	// return super.executeUpdate(sql);
	// }

	@Override
	public BasePartsCategory findByCode(String code) {
		// TODO Auto-generated method stub
		String sql = "select * from BASEPARTSCATEGORY where code=?";
		ResultSet rs = super.executeQuery(sql, code);
		// PageBean pageBean = new PageBean();
		// List<BasePartScategory> basePartScategories = new
		// ArrayList<BasePartScategory>();
		BasePartsCategory basePartScategory = null;
		try {
			while (rs.next()) {
				basePartScategory = new BasePartsCategory();
				basePartScategory.setCode(rs.getString("CODE"));
				basePartScategory.setpCode(rs.getString("pCode"));
				basePartScategory.setCateGoryName(rs.getString("CATEGORYNAME"));
				basePartScategory.setIsShow(rs.getString("ISSHOW"));
				basePartScategory.setRemarks(rs.getString("REMARKS"));
				basePartScategory.setCompCode(rs.getString("compCode"));
				basePartScategory.setAddDate(rs.getDate("ADDDATE"));
				basePartScategory.setAddUser(rs.getString("addUser"));
				basePartScategory.setAddUserName(rs.getString("ADDUSERNAME"));
				basePartScategory.setAddIp(rs.getString("addIp"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return basePartScategory;
	}

	@Override
	public int findMaxCode() {
		// TODO Auto-generated method stub
		String sql = "select max(CODE) from BASEPARTSCATEGORY";
		int ret = super.executeQueryForNewId(sql);
		return ret;
	}

	@Override
	public List findAllCode() {
		// TODO Auto-generated method stub
		String sql = "select CODE from BASEPARTSCATEGORY";
		ResultSet rs = super.executeQuery(sql);
		List<String> codeList = new ArrayList<String>();
		try {
			while (rs.next()) {
				codeList.add(rs.getString("code"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codeList;
	}

}
