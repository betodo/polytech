<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>




</head>
<body>
<% 
	String path = request.getRealPath("upload");
	out.print(path);
%>
<!-- <textarea name="irl" id="ir1" width="450px" height="350px" maxlength="6000">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다. -->
<textarea name="irl" id="ir1" rows="10" cols="100" maxlength="6000">에디터에 기본으로 삽입할 글(수정 모드)이 없다면 이 value 값을 지정하지 않으시면 됩니다.
</textarea>

<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
	 oAppRef: oEditors,
	 elPlaceHolder: "ir1",
	 sSkinURI: "se2/SmartEditor2Skin.html",
	 fCreator: "createSEditor2"
	});
	
// 	‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 
// 	submitContents가 호출된다고 가정한다.
// 	function submitContents(elClickedObj) {
// 		 에디터의 내용이 textarea에 적용된다.
// 		 oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
	
// 		 에디터의 내용에 대한 값 검증은 이곳에서
// 		 document.getElementById("ir1").value를 이용해서 처리한다.
	
// 		 try {
// 		     elClickedObj.form.submit();
// 		 } catch(e) {
			 
// 		 	out.print("에러");
// 		 }
// 	}
</script>


</body>
</html>