package dataaccess.impl;

import java.sql.ResultSet;

import dataaccess.BuyGoodsInfoAccess;
import dataaccess.SqlConnection;

public class BuyGoodsInfoAccessImpl implements BuyGoodsInfoAccess {

	SqlConnection consql=new SqlConnection();
	public ResultSet getBuyGoodsInfo(String sql) {
		ResultSet rs=this.consql.lookfor(sql);
		return rs;
	}

}
