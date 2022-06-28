<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.idcheck{
	padding : 300px 0 0 0;
}
</style>
<body>

<script type="text/javascript">
function idcheck(){
   alert("${idcheck.uId}")
      }
</script>


<script type="text/javascript">
      let alertT = '<%=request.getAttribute("idtxt")%>';
      
      if (alertT !== "null"){
         alert(alertT);   
         }
      </script>
      <div class="idcheck" align="center">
      <br><br>* 회원가입을 하실 아이디를 입력해주시고 중복체크하기를 클릭해주세요 *<br><br>
<form action="idcheckuser.do">
ID : <input type="text" name="idcheck" id="aaa">
<br><br>
<input type="submit" value="중복체크하기">
</form>

      </div>
 <script src="js/main.js"></script> 
</body>
</html>