<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>***${sungJukDTO.name } 성적 ***</h3><!-- ${sungJukDTO.getName() } -->
<h4>
	총점 : ${sungJukDTO.tot } <br>
	평균 : ${sungJukDTO.avg }
</h4>
</body>
</html>