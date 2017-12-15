package business;

import java.sql.ResultSet;

import entities.GoodsInfo;

public interface GoodsInfoRules {

	public boolean saveGoods(GoodsInfo goods);//���������Ʒ��Ϣ
	public boolean removeGoods(GoodsInfo goods);//ɾ����Ʒ��Ϣ
	public boolean modifyGoods(GoodsInfo goods);//�޸�������Ʒ��Ϣ
	public ResultSet getGoodsInfo(GoodsInfo goods);//��ȷ��ѯ��Ʒ��Ϣ
	public ResultSet getAllGoodsinfo(GoodsInfo goods);//ģ����ѯ��Ʒ��Ϣ
}
