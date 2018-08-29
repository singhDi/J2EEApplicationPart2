package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import jdbc.PersonConnection;
import model.PersonInfo;

public class MyDAO {

	public PersonInfo getPerson(String email, String password) {
		ResultSet rSet = null;
		Connection con = null;
		PreparedStatement p = null;
		
		try {
			con = PersonConnection.getConnection();
			p = con.prepareStatement("select * from personinfo where email = ? and password = ?");
			p.setString(1, email);
			p.setString(2, password);

			rSet = p.executeQuery();
			
			PersonInfo pInfo = new PersonInfo(email, password);
			if(rSet.next()) {
						pInfo.setEmail(email);
						pInfo.setName(rSet.getString(1));
						pInfo.setPassword(rSet.getString(3));
						pInfo.setPhone(rSet.getString(4));
						pInfo.setGender(rSet.getString(5));
			}
			return pInfo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
