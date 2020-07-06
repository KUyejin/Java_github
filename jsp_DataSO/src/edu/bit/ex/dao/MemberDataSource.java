package edu.bit.ex.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.ex.dto.MemberDTO;

public class MemberDataSource {
		
		//private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//private String uid = "scott";
		//private String upw = "tiger";
		//private String driver = "oracle.jdbc.driver.OracleDriver";
	
	    private DataSource dataSource; //Ŀ�ؼ�Ǯ�� �������� ���� ,��ü �����ͼҽ��� Ŀ�ؼ�Ǯ
		
		public MemberDataSource() {
			try {
				//Class.forName(driver);
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //java:comp/env/ - �ڹٹ��� ,jdbc/oracle -context.xml���� name ����(��Ȯ���ؼ��ٲ��ֱ�)
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		public ArrayList<MemberDTO> memberSelect() {
			ArrayList<MemberDTO> dtos = new ArrayList<MemberDTO>();
			
			Connection con =null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from member";
			
			try {
				//con = DriverManager.getConnection(url, uid, upw); //DriverManager �������� Ŀ�ؼ�Ǯ�� �̸���������ִ�
				con = dataSource.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					String name = rs.getString("name");
					String id = rs.getString("id");
					String pw = rs.getString("pw");
					String phone1 = rs.getString("phone1");
					String phone2 = rs.getString("phone2");
					String phone3 = rs.getString("phone3");
					String gender = rs.getString("gender");
					
					//����Ѹ��Ѹ� ������ �����ͼ� dtos(arraylist)�� ��Ƴ��� ��,�ڹٰ�ü����
					MemberDTO dto = new MemberDTO(name, id, pw, phone1, phone2, phone3, gender);
					dtos.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			
			return dtos;
		
		
	}

}
