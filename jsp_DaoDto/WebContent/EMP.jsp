<%@page import="edu.bit.ex.dto.EmpDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.bit.ex.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
	    <%
	        EmpDAO empDAO = new EmpDAO();
	        ArrayList<EmpDTO> dtos = empDAO.memberSelect();
	        
	        for(int i = 0; i<dtos.size(); i++){
	        	EmpDTO dto = dtos.get(i);
	        	String empno = dto.getEmpno();
	        	String ename = dto.getEname();
	        	String job = dto.getJob();
	        	String mgr = dto.getMgr();
	        	String hiredate = dto.getHiredate();
	        	String sal = dto.getSal();
	        	String comm = dto.getComm();
	        	String deptno = dto.getDeptno();
	        	
	        	out.println("사원번호 : " + empno + ", 사원명 : " + ename + ", 직급 : " + job + 
	        			", 해당관리자 : " + mgr + ",  입사일자 : " + hiredate + ",  급여 : " + sal 
	        			+",  커미션 : " + comm + ", 부서번호 : " + deptno + "<br />" );
	        	
	        }
   
	    %>
	
	</body>
</html>