<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    MemberInfo member = new MemberInfo()
<jsp:useBean id="member" class="edu.bit.ex.dto.MemberInfo" scope="page"/>    
<jsp:setProperty  name = "member" property="name" value="홍길동"/>
<jsp:setProperty  name = "member" property="id" value="아이디"/>
<jsp:setProperty  name = "member" property="pw" value="123"/>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="EUC-KR">
		<title>Insert title here</title>
	</head>
	<body>
	     이름: <jsp:getProperty name = "member" property="name"/><br/>
	     아이디: <jsp:getProperty name = "member" property="id"/><br/>
	     비밀번호: <jsp:getProperty name = "member" property="pw"/><br/>
	   <hr/>
	      
	      이름:${member.name}<br/> <!-- member의 getname을 호출  -->
	      이름:${member.id}<br/>
	      이름:${member.pw}<br/>
	      
	
	</body>
</html>