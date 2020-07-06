package edu.bit.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import edu.bit.ex.dto.EmpDTO;



public class EmpDAO {
	
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String uid = "scott";
	private String upw = "tiger";
	private String driver = "oracle.jdbc.driver.OracleDriver";
	
	public EmpDAO() {
		try {
			Class.forName(driver); //����̹� ��ü�� �޸𸮿� �ø��� - ����ϰڴ�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpDTO> memberSelect() { 
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		//dtos��� �迭����Ʈ �����ϴµ� ��ȯ��Ÿ���� empDTO�� �ϰڴ�
		
		Connection con =null; //����
		Statement stmt = null; //���
		ResultSet rs = null; //��select ����� �㤷�� ��ü
		String sql = "select * from emp"; //sql���ִ� emp�ڷ�
		
		try {
			con = DriverManager.getConnection(url, uid, upw); //����̹����������� �����Ѵ�
			stmt = con.createStatement(); //�����ؼ� ����ϰڴ�.
			rs = stmt.executeQuery(sql); //����ؼ� sql�� ���� �� ������ �����ؼ� ��� ���ڴ�
			
			while (rs.next()) { 
				String empno = rs.getString("empno"); //"empno"���� ��ƿ��ڴ�
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				dtos.add(dto); //dtos�� ���� ���� dto�� �ְڴ�
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
