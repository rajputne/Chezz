package dataaccess.impl;

import java.sql.ResultSet;

import dataaccess.GoodsInfoAccess;
import dataaccess.SqlConnection;

public class GoodsInfoAccessImpl implements GoodsInfoAccess{

	SqlConnection consql=new SqlConnection();
	public boolean addGoods(String sql) {
		// TODO Auto-generated method stub
		//�����Ʒ��Ϣ
		return this.consql.conupdate(sql);
	}

	public boolean deleteGoods(String sql) {
		// TODO Auto-generated method stub
		//ɾ����Ʒ��Ϣ
		return this.consql.conupdate(sql);
	}

	public boolean updateGoods(String sql) {
		// TODO Auto-generated method stub
		//�޸���Ʒ��Ϣ
		return this.consql.conupdate(sql);
	}

	public ResultSet getGoodsInfo(String sql) {
		// TODO Auto-generated method stub
		//��ѯ��Ʒ��Ϣ
		ResultSet rs=this.consql.lookfor(sql);
		return rs;
	}

}
