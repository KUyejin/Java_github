<%-- <%@page import="java.sql.*"%> sql���� ����Ʈ ��Ű�� ��--%>

<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="EUC-KR">
		<title>EMP ���̺� ���� ���</title>
	</head>
	
	<body>
	<center>
	   	    
	    <table border="1">
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
  
	    <%!
	        /**Class.forName("oracle.jdbc.driver.OracleDriver"); */
	        Connection connection;
	        Statement statement;
	        ResultSet resultSet; 
	        	        
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:xe";
	        String uid = "scott";
	        String upw = "tiger";
	        String query = "select * from emp";
	        
	    %>
	    
	    <%
	        
	        try{
	        	Class.forName(driver); 	                     
	            connection = DriverManager.getConnection(url, uid, upw);               
	        	statement = connection.createStatement(); 
	        	resultSet = statement.executeQuery(query); 
	        	
	        	while(resultSet.next()){ 
	            %>  
	           
	            <tr>
	                <td><%=resultSet.getString(1) %></td>
					<td><%=resultSet.getString(2) %></td>
					<td><%=resultSet.getString(3) %></td>
					<td><%=resultSet.getString(4) %></td>		
					<td><%=resultSet.getString(5) %></td>
					<td><%=resultSet.getString(6) %></td>
					<td><%=resultSet.getString(7) %></td>
					<td><%=resultSet.getString(8) %></td>								
			    </tr>
	        		        	
	        	<!-- <tr>	
	        		<td>String empno = resultSet.getString("EMPNO");</td>
	        		<td>String ename = resultSet.getString("ENAME");</td>
	        		<td>String job = resultSet.getString("JOB");</td>	        		
	        		<td>String hiredate = resultSet.getString("HIREDATE");</td>
	        		<td>String sal = resultSet.getString("SAL");</td>
	        		<td>String comm = resultSet.getString("COMM");</td>
	        		<td>String deptno = resultSet.getString("DEPTNO");</td>
	        	</tr>	 -->
	        		<!-- out.println("�����ȣ:" + empno +  " �̸�: " + ename + " ����: " + job + "�Ի糯¥: " + hiredate + 
	        				     "����:" + sal +  "Ŀ�̼�:"+ comm + "�μ���ȣ:" +deptno +"<br/>"); -->
	        	

	        <% 	
	            }	
	        }catch(Exception e){
	        
	        }finally{
	        	try{
	        		if(resultSet != null) resultSet.close();
	        		if(statement != null) statement.close();
	        		if(connection != null) connection.close();
	        	}catch(Exception e){}	        				        	        		       	
	        }
	        
	        %>
	     
	    </center>   
	    </table>
	    
	</body>
</html>