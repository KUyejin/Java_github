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
	        	
	        	out.println("�����ȣ : " + empno + ", ����� : " + ename + ", ���� : " + job + 
	        			", �ش������ : " + mgr + ",  �Ի����� : " + hiredate + ",  �޿� : " + sal 
	        			+",  Ŀ�̼� : " + comm + ", �μ���ȣ : " + deptno + "<br />" );
	        	
	        }
   
	    %>
	
	</body>
</html>