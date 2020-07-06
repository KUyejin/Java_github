
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
			<th>사원번호</th> <!-- empno -->
			<th>사원이름</th> <!-- ename -->
			<th>직급(업무)</th> <!-- job -->
			<th>해당관리자</th> <!-- mgr -->
			<th>입사일자</th> <!-- hiredate -->
			<th>급여</th> <!-- sal -->
			<th>커미션</th> <!-- comm -->
			<th>부서번호</th> <!-- deptno -->

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
	        	
	        	out.println("사원번호 : " + empno + ", 사원명 : " + ename + ", 직급 : " + job + 
	        			", 해당관리자 : " + mgr + ",  입사일자 : " + hiredate + ",  급여 : " + sal 
	        			+",  커미션 : " + comm + ", 부서번호 : " + deptno + "<br />" );   -->
	       <% 	
	        }
	       %>
	    
	    
	    
	    </table>
	</body>
</html>