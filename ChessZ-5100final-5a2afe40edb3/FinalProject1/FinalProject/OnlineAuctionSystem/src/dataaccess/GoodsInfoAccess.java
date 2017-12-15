package dataaccess;

import java.sql.ResultSet;

public interface GoodsInfoAccess {
	public boolean addGoods(String sql);
	public boolean deleteGoods(String sql);
	public boolean updateGoods(String sql);
	public ResultSet getGoodsInfo(String sql);
	

}
