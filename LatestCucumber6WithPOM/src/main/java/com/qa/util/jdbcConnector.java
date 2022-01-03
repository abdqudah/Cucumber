/*package com.qa.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jdbcConnector {

	public static WebDriver driver;
	public static Statement s;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub

		// String host = "mscjo.dynalias.com";
		// String port = "1531";

		//WebDriverManager.chromedriver().setup();
		//driver = new ChromeDriver();

		//driver.get("https://www.google.com/");
		//WebElement web = driver.findElement(By.xpath("//input [@type='text']"));
		
		
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@mscjo.dynalias.com:1531/adlsadev",
				"ADLSA_LABSEC", "adlsa2021");
	     s = con.createStatement();
	     ////
		ResultSet rs = s.executeQuery("SELECT * from utl_general_lookups where LK_ID='3'");

		while (rs.next()) {
			String bee = rs.getString("LK_ID");
			// System.out.println(rs.getString("NAME_AR"));
			// System.out.println(rs.getString("NAME_EN"));
			
			
			
		if (bee=="3") {
				
				web.sendKeys("Abdelhadi AlQudah");
			}
		}
		
		
	}

}*/