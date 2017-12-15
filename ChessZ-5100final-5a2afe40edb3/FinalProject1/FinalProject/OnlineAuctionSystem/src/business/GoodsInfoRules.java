package business;

import java.sql.ResultSet;

import entities.GoodsInfo;

public interface GoodsInfoRules {

	public boolean saveGoods(GoodsInfo goods);//添加拍卖商品信息
	public boolean removeGoods(GoodsInfo goods);//删除商品信息
	public boolean modifyGoods(GoodsInfo goods);//修改拍卖商品信息
	public ResultSet getGoodsInfo(GoodsInfo goods);//精确查询商品信息
	public ResultSet getAllGoodsinfo(GoodsInfo goods);//模糊查询商品信息
}
