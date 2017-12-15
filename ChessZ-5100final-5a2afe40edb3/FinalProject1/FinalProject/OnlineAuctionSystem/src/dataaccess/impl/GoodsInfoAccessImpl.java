package dataaccess.impl;

import java.sql.ResultSet;

import dataaccess.GoodsInfoAccess;
import dataaccess.SqlConnection;

public class GoodsInfoAccessImpl implements GoodsInfoAccess{

	SqlConnection consql=new SqlConnection();
	public boolean addGoods(String sql) {
		// TODO Auto-generated method stub
		//添加商品信息
		return this.consql.conupdate(sql);
	}

	public boolean deleteGoods(String sql) {
		// TODO Auto-generated method stub
		//删除商品信息
		return this.consql.conupdate(sql);
	}

	public boolean updateGoods(String sql) {
		// TODO Auto-generated method stub
		//修改商品信息
		return this.consql.conupdate(sql);
	}

	public ResultSet getGoodsInfo(String sql) {
		// TODO Auto-generated method stub
		//查询商品信息
		ResultSet rs=this.consql.lookfor(sql);
		return rs;
	}

}
