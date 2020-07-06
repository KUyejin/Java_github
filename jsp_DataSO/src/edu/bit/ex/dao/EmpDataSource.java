package edu.bit.ex.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.bit.ex.dto.EmpDTO;


public class EmpDataSource {
		
		//private String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//private String uid = "scott";
		//private String upw = "tiger";
		//private String driver = "oracle.jdbc.driver.OracleDriver";
	
	    private DataSource dataSource; //Ŀ�ؼ�Ǯ�� �������� ���� ,��ü �����ͼҽ��� Ŀ�ؼ�Ǯ
		
		public EmpDataSource() {
			try {
				//Class.forName(driver);
				Context context = new InitialContext();
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle"); //java:comp/env/ - �ڹٹ��� ,jdbc/oracle -context.xml���� name ����(��Ȯ���ؼ��ٲ��ֱ�)
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
    	public ArrayList<EmpDTO> memberSelect() {
			ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
			
			Connection con =null;
			Statement stmt = null;
			ResultSet rs = null;
			String sql = "select * from emp";
			
			try {
				//con = DriverManager.getConnection(url, uid, upw); //DriverManager �������� Ŀ�ؼ�Ǯ�� �̸���������ִ�
				con = dataSource.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					String empno = rs.getString("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					String mgr = rs.getString("mgr");
					String hiredate = rs.getString("hiredate");
					String sal = rs.getString("sal");
					String comm = rs.getString("comm");
					String deptno = rs.getString("deptno");
					
					//����Ѹ��Ѹ� ������ �����ͼ� dtos(arraylist)�� ��Ƴ��� ��,�ڹٰ�ü����
					EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
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
