<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    MemberInfo member = new MemberInfo()
<jsp:useBean id="member" class="edu.bit.ex.dto.MemberInfo" scope="page"/>    
<jsp:setProperty  name = "member" property="name" value="ȫ�浿"/>
<jsp:setProperty  name = "member" property="id" value="���̵�"/>
<jsp:setProperty  name = "member" property="pw" value="123"/>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
	     �̸�: <jsp:getProperty name = "member" property="name"/><br/>
	     ���̵�: <jsp:getProperty name = "member" property="id"/><br/>
	     ��й�ȣ: <jsp:getProperty name = "member" property="pw"/><br/>
	   <hr/>
	      
	      �̸�:${member.name}<br/> <!-- member�� getname�� ȣ��  -->
	      �̸�:${member.id}<br/>
	      �̸�:${member.pw}<br/>
	      
	
	</body>
</html>