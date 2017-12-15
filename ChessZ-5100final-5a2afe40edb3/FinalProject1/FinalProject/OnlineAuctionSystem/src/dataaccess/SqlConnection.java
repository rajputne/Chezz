package dataaccess;
import java.sql.*;
public class SqlConnection {
	
	 Connection con = null;
	    Statement stm = null;
	    ResultSet rs = null;
	    //获取连接
	    public Connection sqlCon() {
	        try {
	            //Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
	        	Class.forName("net.sourceforge.jtds.jdbc.Driver");
	            con = DriverManager.getConnection(
	                    "jdbc:jtds:sqlserver://127.0.0.1:1433;databasename=OnLineSaleSystem",
	                    "sa", "");
	        } catch (Exception ce) {
	            ce.printStackTrace();
	        }
	        return con;
	    }
	    //负责查询功能
	    public ResultSet lookfor(String txtsql) {
	        try {
	            con = this.sqlCon();
	            stm = con.createStatement();
	            rs = stm.executeQuery(txtsql);
	        } catch (Exception ce) {
	            //ce.printStackTrace();
	            System.out.println(ce);
	        }
	        return rs;
	    }
	    //负责修改和删除功能
	    public boolean conupdate(String s1) {
	        boolean ta = false;
	        try {
	            con = this.sqlCon();
	            stm = con.createStatement();
	            stm.executeUpdate(s1);
	            ta = true;
	        } catch (Exception st) {
	            st.printStackTrace();
	        }
	        finally{	        	
	        	try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return ta;
	       
	    }


}
