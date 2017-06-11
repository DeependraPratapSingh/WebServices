/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.DtoUser;
import java.sql.*;
/**
 *
 * @author Rishabh
 */
public class DaoUser {
    
	public boolean validate(DtoUser obj)
	{
		try
		{
			PreparedStatement pstmt = dbconn.DBUtil.createConnection().prepareStatement("select 1 from user where login_name=? and login_pwd=?");
			pstmt.setString(1, obj.getUsername());
			pstmt.setString(2, obj.getPassword());
			System.out.println("==>"+pstmt);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
				return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public int register(DtoUser obj)
	{
		try
		{
			PreparedStatement pstmt = dbconn.DBUtil.createConnection().prepareStatement("insert into user(login_name,login_pwd,user_name) values(?,?,?)");
			pstmt.setString(1, obj.getName());
			pstmt.setString(2, obj.getPassword());
			pstmt.setString(3,obj.getUsername());
			System.out.println("==>"+pstmt);
			int i = pstmt.executeUpdate();
			return i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
		
	}
    
    
}
