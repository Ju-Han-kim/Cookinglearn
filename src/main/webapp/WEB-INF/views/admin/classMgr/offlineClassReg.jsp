<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="../include/header.jsp" />	

	<div class="container">
		<br>
		<form method="post" action="/admin/class/regClass" enctype="multipart/form-data" id="class-form">
			<div class="row">
				<div class="col-md-12">
					<div class="card border-secondary mb-3">
						<div class="card-header"><strong>오프라인 강의등록</strong></div>
						<div class="card-body text-secondary">
							<div class="row">
								<div class="col-md-12">
									<div class="row">
										<label class="col-sm-1 col-form-label">강의이름</label> 
										<div class="col-sm-11">
											 <input class="form-control" name="className" id="className" />
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-12">
									<textarea id="classContent" name="classContent"></textarea>
								</div>
							</div>
							<br>
							<div class="row">
								<label class="col-sm-1 col-form-label">카테고리</label> 
								<div class="col-sm-3">
									<select class="custom-select" id="classCategory" name="classCategory">
										<option value="한식" >한식</option>
										<option value="분식" >분식</option>
										<option value="중식" >중식</option>
										<option value="일식" >일식</option>
										<option value="양식" >양식</option>
									</select>
								</div>
								<label class="col-sm-1 col-form-label">최대인원</label> 
								<div class="col-sm-3">
									<select class="custom-select" id="maxStudent" name="maxStudent">
										<c:forEach var="count" begin="1" end="10">
											<option value="${count}" >${count}</option>
										</c:forEach>
									</select>
								</div>
								<label class="col-sm-1 col-form-label">수강비용</label> 
								<div class="col-sm-3">
									<input class="form-control" name="price" id="price" />
								</div>
							</div>
							<br>
							<div class="row">
								<label class="col-sm-1 col-form-label">수강일자</label> 
								<div class="col-sm-4">
									<input class="form-control" id="startDate" name="startDate" readonly>
								</div>
								<label class="col-sm-1 col-form-label">수강시간</label> 
								<div class="col-sm-4">
									<select class="custom-select" id="runTime" name="runTime">
										<option value="30" >30분</option>
										<option value="60" >60분</option>
										<option value="90" >90분</option>
										<option value="180" >180분</option>
									</select>
								</div>
							</div>
							<br>
							<div class="row">
								<label class="col-sm-1 col-form-label">썸네일</label> 
								<div class="col-sm-11">
									<div class="input-group">
										<div class="custom-file">
											<input type="file" class="custom-file-input" name="file" id="thumbnailImgFile">
											<label class="custom-file-label">파일을 선택해주세요</label>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-sm-1"></div>
								<div id="thumbnailImgArea"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<input type="button" class="btn btn-block btn-outline-primary" id="submit-btn" value="등록">
				</div>
				<div class="col-md-6">
					<input type="button" class="btn btn-block btn-outline-primary" id="list-btn" value="목록">
				</div>
				<input type="hidden" name="classType" value="${classType}" />
				<input type="hidden" name="contentImg" id="contentImg" value="" />
				<input type="hidden" name="thumbnailImg" id="thumbnailImg" value="" />
			</div>
			<br>
		</form>
	</div>

<jsp:include page="../include/footer.jsp" />

<script>

	let thumbnailImg = "";
	let contentImg = "";
	
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
		data.append("classType", "off");
		data.append("part", "/");
		$.ajax({
			contentType : false,
			data : data,
			type : "POST",
			url : "/admin/class/regimg",
			enctype : 'multipart/form-data',
			processData : false,
			success : function(data) {
				$(el).summernote('editor.insertImage', data.url);
				contentImg += "|"+data.url;
			}
		});
	};
	
	$(function() {
		
		$("#startDate").daterangepicker({
			locale: {
				"format": 'YYYY-MM-DD HH:mm:SS', 
				"applyLabel": "확인",    
				"cancelLabel": "취소",   
				"daysOfWeek": ["일", "월", "화", "수", "목", "금", "토"],
				"monthNames": ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"]
				},
			showDropdowns: true,
			singleDatePicker : true,
			timePicker : true
		});
		
		//Thumbnail 업로드
		$("#thumbnailImgFile").change(function(e) {
			if(e.target.files[0] != null){
				if(thumbnailImg != ""){
					$.ajax({
						data : {
							"filePath" : thumbnailImg
						},
						type : "POST",
						url : "/admin/class/delimg",
						success : function() {
						}
					});
				}
				
				data = new FormData();
				data.append("file", e.target.files[0]);
				data.append("classType", "off");
				data.append("part", "/thumbnail/");
				$.ajax({
					contentType : false,
					data : data,
					type : "POST",
					url : "/admin/class/regimg",
					enctype : 'multipart/form-data',
					processData : false,
					success : function(data) {
						$("#thumbnailImgArea").html("<img alt='썸네일' src='"+data.url+"'>");
						thumbnailImg = data.url;
						chk3 = true;
					}
				});
			} else {
				thumbnailImg = "";
				$("#thumbnailImgArea").html("");
				chk3 = false;
			}
		});
		
		//값 검증
		let chk1 = false, chk2 = false, chk3 = false;
		const regNum = RegExp(/^[0-9]*$/); 
		
		//강의이름 입력여부 검증
		$("#className").on("keyup", function() {
			if($(this).val() === ""){
				chk1 = false;
			} else {
				chk1 = true;
			}
		});
		
		//수강비용 숫자입력검증, 입력여부검증
		$("#price").on("keyup", function() {
			if($(this).val() === ""){
				chk2 = false;
			} else if(!regNum.test($(this).val())) {
				alert("수강비용은 숫자만 입력가능합니다!");
				$("#price").val("");
				$("#price").focus();
				chk2 = false;
			} else {
				chk2 = true;
			}
		});
		
		//강의등록
		$("#submit-btn").click(function() {
			
			if(chk1 && chk2 && chk3){
				if(confirm($("#className").val()+"(을)를 등록하시겠습니까?")){
					$("#contentImg").val(contentImg);
					$("#thumbnailImg").val(thumbnailImg);
					$("#class-form").submit();
				}
			} else {
				if(!chk1){
					alert("강의이름을 입력해주세요!");
				}
				if(!chk2) {
					alert("수강비용을 입력해주세요!");
				}
				if(!chk3) {
					alert("썸네일을 등록해주세요!");
				}
			}
			
		});
		
		//강의 리스트로 다시 이동
		$("#list-btn").click(function() {
			location.href="/admin/class/off1";
		});
		
		
	});

</script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="/vendor/summerNote/summernote.min.js"></script>