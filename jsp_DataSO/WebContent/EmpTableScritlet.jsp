
<%@page import="edu.bit.ex.dto.EmpDTO"%>
<%@page import="edu.bit.ex.dao.EmpDataSource"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	
	<body>
	    <table border = "1">
	        <tr bgcolor = "skyblue">
	            <tr bgcolor="skybule">
			<th>�����ȣ</th> <!-- empno -->
			<th>����̸�</th> <!-- ename -->
			<th>����(����)</th> <!-- job -->
			<th>�ش������</th> <!-- mgr -->
			<th>�Ի�����</th> <!-- hiredate -->
			<th>�޿�</th> <!-- sal -->
			<th>Ŀ�̼�</th> <!-- comm -->
			<th>�μ���ȣ</th> <!-- deptno -->

		</tr>
	
	    <%
	        EmpDataSource empDataSource = new EmpDataSource();
	        ArrayList<EmpDTO> dtos = empDataSource.memberSelect();
	        
	        for(int i = 0; i<dtos.size(); i++){
	        	EmpDTO dto = dtos.get(i);
	     %>   	
	        <tr>
	                <td><%=dto.getEmpno() %></td>
					<td><%=dto.getEname() %></td>
					<td><%=dto.getJob() %></td>
					<td><%=dto.getMgr() %></td>		
					<td><%=dto.getHiredate() %></td>
					<td><%=dto.getSal()%></td>
					<td><%=dto.getComm() %></td>
					<td><%=dto.getDeptno() %></td>								
			    </tr>
	        	
	        	
	        	
	        	<!--EmpDTO dto = dtos.get(i);
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
	        			+",  Ŀ�̼� : " + comm + ", �μ���ȣ : " + deptno + "<br />" );   -->
	       <% 	
	        }
	       %>
	    
	    
	    
	    </table>
	</body>
</html>