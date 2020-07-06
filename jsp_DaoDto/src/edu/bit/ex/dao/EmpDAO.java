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
			Class.forName(driver); //드라이버 객체를 메모리에 올린다 - 사용하겠다
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<EmpDTO> memberSelect() { 
		ArrayList<EmpDTO> dtos = new ArrayList<EmpDTO>();
		//dtos라는 배열리스트 생성하는데 반환형타입을 empDTO로 하겠다
		
		Connection con =null; //연결
		Statement stmt = null; //통신
		ResultSet rs = null; //ㄴselect 결과값 담ㅇ는 객체
		String sql = "select * from emp"; //sql에있는 emp자료
		
		try {
			con = DriverManager.getConnection(url, uid, upw); //드라이버ㅐㅁ니저에 연결한다
			stmt = con.createStatement(); //연결해서 통신하겠다.
			rs = stmt.executeQuery(sql); //통신해서 sql에 담은 값 쿼리를 실행해서 담아 오겠다
			
			while (rs.next()) { 
				String empno = rs.getString("empno"); //"empno"값을 담아오겠다
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				String mgr = rs.getString("mgr");
				String hiredate = rs.getString("hiredate");
				String sal = rs.getString("sal");
				String comm = rs.getString("comm");
				String deptno = rs.getString("deptno");
				
				EmpDTO dto = new EmpDTO(empno, ename, job, mgr, hiredate, sal, comm, deptno);
				dtos.add(dto); //dtos에 값을 담은 dto를 넣겠다
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
