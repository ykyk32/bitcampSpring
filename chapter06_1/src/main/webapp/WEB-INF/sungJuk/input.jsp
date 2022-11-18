<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/chapter06_1/sungJuk/result.do"><!--적대주소  -->
   <table border="1" cellpadding="5" cellspacing="0">
      <tr>
         <td width="50" align="center">이름</td>
         <td>
            <input type="text" name="name">
         </td>
      </tr>
      
      <tr>
         <td align="center">국어</td>
         <td>
            <input type="text" name="kor">
         </td>
      </tr>
      
      <tr>
         <td align="center">영어</td>
         <td>
            <input type="text" name="eng">
         </td>
      </tr>
      <tr>
         <td align="center">수학</td>
         <td>
            <input type="text" name="math">
         </td>
      </tr>
      <tr>
         <td colspan="2" align="center">
            <input type="submit" value="계산">
         </td>
      </tr>
   </table>
   
</form>
</body>
</html>