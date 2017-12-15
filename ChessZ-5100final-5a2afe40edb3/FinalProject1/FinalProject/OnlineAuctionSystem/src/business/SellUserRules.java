package business;

import java.sql.ResultSet;
import entities.SellUser;

public interface SellUserRules {
	//�����û��ӿ�
	public boolean  addUser(SellUser sellUser);
	public boolean  modifyUser(SellUser sellUser);
	public boolean  removeUser(SellUser sellUser);
	public ResultSet loginUser(SellUser sellUser);
	public boolean isContaintUser(String name);

}
