<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="hidden" name="id" value="${hx.id }">
<br>
<table>
      <tr>
         <th>个人简介：</th>
         <td><font color="red">${hx.userinfo }</font></td>
      </tr>
</tbody>
</table>
</body>
</html>