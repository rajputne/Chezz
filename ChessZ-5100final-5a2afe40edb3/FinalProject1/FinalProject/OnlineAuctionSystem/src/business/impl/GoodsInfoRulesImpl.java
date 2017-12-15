package business.impl;

import java.sql.ResultSet;

import dataaccess.GoodsInfoAccess;
import dataaccess.impl.GoodsInfoAccessImpl;

import entities.GoodsInfo;
import business.GoodsInfoRules;

public class GoodsInfoRulesImpl implements GoodsInfoRules {

	GoodsInfoAccess goodsinfo = new GoodsInfoAccessImpl();

	public boolean saveGoods(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sql = "insert into GoodsInfo values('" + goods.getGoodsName()
				+ "','" + goods.getGoodsDescription() + "'" + ","
				+ goods.getBeginPrice() + ",'" + goods.getImagePath() + "',"
				+ goods.getGoodsCount() + "" + ",'" + goods.getEnroTime()
				+ "'," + goods.getSellUserId() + ")";
		
		return this.goodsinfo.addGoods(sql);
	}

	public boolean removeGoods(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sql = "delete GoodsInfo where pkid=" + goods.getId() + "";
		return this.goodsinfo.deleteGoods(sql);
	}

	public boolean modifyGoods(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sql = "update GoodsInfo set GoodsName='" + goods.getGoodsName()
				+ "',GoodsDescription='" + goods.getGoodsDescription() + "',"
				+ "BeginPrice=" + goods.getBeginPrice() + ",ImagePath='"
				+ goods.getImagePath() + "'," + "Amount="
				+ goods.getGoodsCount() + " where pkid=" + goods.getId() + " ";
		return this.goodsinfo.updateGoods(sql);
	}

	// ¾«È·ËÑË÷
	public ResultSet getGoodsInfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sql;
		if (goods.getGoodsName() == null || "".equals(goods.getGoodsName()))
			sql = "select * from GoodsInfo";
		else
			sql = "select * from GoodsInfo where GoodsName='"
					+ goods.getGoodsName() + "'";
		ResultSet rs = this.goodsinfo.getGoodsInfo(sql);
		return rs;
	}

	// Ä£ºýËÑË÷
	public ResultSet getAllGoodsinfo(GoodsInfo goods) {
		// TODO Auto-generated method stub
		String sql;
		if (goods.getGoodsName() == null || "".equals(goods.getGoodsName()))
			sql = "select * from GoodsInfo";
		else
			sql = "select * from GoodsInfo where GoodsName like '%"
					+ goods.getGoodsName() + "%'";
		ResultSet rs = this.goodsinfo.getGoodsInfo(sql);
		return rs;
	}

}
