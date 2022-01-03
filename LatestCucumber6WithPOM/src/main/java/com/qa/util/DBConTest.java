package com.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConTest {
	
	public Connection DBConnect () throws SQLException {
	
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mscjo.dynalias.com:1531/adlsadev",
			"ADLSA_LABSEC", "adlsa2021");
	
//	Statement s = con.createStatement();
//	ResultSet rs = s.executeQuery("SELECT * from utl_general_lookups where LK_ID='3'");
//	
//	while (rs.next()) {
//		String bee = rs.getString("LK_ID");
//		// System.out.println(rs.getString("NAME_AR"));
	return con ;

}
}