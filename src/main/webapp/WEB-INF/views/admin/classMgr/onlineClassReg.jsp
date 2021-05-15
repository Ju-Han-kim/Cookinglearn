<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

	<!-- content -->
	<div class="content">
		<h3>온라인 강의등록</h3>
	
		<form method="post" action="/admin/class/regClass">
			강의이름 : <input name="className" id="className" />
			<textarea id="classContent" name="classContent"></textarea>
			카테고리 : <select name="classCategory" id="classCategory">
						<option value="한식" >한식</option>
						<option value="분식" >분식</option>
						<option value="중식" >중식</option>
						<option value="일식" >일식</option>
						<option value="양식" >양식</option>
					</select>
			수강기간 : <select name="runTime" id="runTime">
						<option value="30" >30일</option>
						<option value="60" >60일</option>
						<option value="180" >180일</option>
						<option value="365" >365일</option>
					</select>
			수강비용 : <input name="price" id="price" />
			썸네일 : 
			강의링크 : 
			<input type="submit" value="등록">
			<input type="hidden" name="classType" value="${classType}" />
		</form>
	
	</div>

<jsp:include page="../include/footer.jsp" />

<script>
	
	const toolbar = [
		['style', ['style']],
		['font', ['bold', 'underline', 'clear']],
		['color', ['color']],
		['para', ['ul', 'ol', 'paragraph']],
		['table', ['table']],
		['insert', ['link', 'picture', 'video']],
	];
	
	const setting = {
		lang: 'ko-KR',
		toolbar: toolbar,
		placeholder: '강의 정보를 입력해주세요',
		tabsize: 2,
		height: 600,
		focus : true,
		minHeight : null,
		maxHeight : null,
		callbacks : { 
			onImageUpload : function(files, editor, welEditable) {
				for (let i = files.length - 1; i >= 0; i--) {
					uploadImageFile(files[i], this);
        		}
			}
		}
	};
	
	$(document).ready(function() {
		$('#classContent').summernote(setting);
	});
	
	function uploadImageFile(file, el) {
		data = new FormData();
		data.append("file", file);
		$.ajax({
			contentType : false,
			data : data,
			type : "POST",
			url : "/admin/class/regon",
			enctype : 'multipart/form-data',
			processData : false,
			success : function(data) {
				$(el).summernote('editor.insertImage', data.url);
				console.log(data.responseCode);
			}
		});
	};
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="/vendor/summerNote/summernote.min.js"></script>