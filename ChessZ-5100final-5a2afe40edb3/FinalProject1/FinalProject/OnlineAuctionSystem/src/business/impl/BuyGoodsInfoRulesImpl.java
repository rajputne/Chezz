package business.impl;

import java.sql.ResultSet;

import dataaccess.BuyGoodsInfoAccess;
import dataaccess.impl.BuyGoodsInfoAccessImpl;

import business.BuyGoodsInfoRules;

public class BuyGoodsInfoRulesImpl implements BuyGoodsInfoRules {
	BuyGoodsInfoAccess buyGoodsinfo=new BuyGoodsInfoAccessImpl();
	public ResultSet getBuyGoodsInfo(long id) {
		// TODO Auto-generated method stub
		String sql="select * from BuyGoodsInfo where Fk_BuUserId="+id+"";
		ResultSet rs=this.buyGoodsinfo.getBuyGoodsInfo(sql);
		return rs;
	}

}
