package business;

import java.sql.ResultSet;

public interface BuyGoodsInfoRules {

	//得到个人购物车中的东西
	public ResultSet getBuyGoodsInfo(long id);
}
