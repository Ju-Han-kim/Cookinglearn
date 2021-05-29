<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="../include/header.jsp" />

	<div class="container">
		<br>
		<form method="post" action="/admin/class/modClass" enctype="multipart/form-data" id="class-form">
			<div class="row">
				<div class="col-md-12">
					<div class="card border-secondary mb-3">
						<div class="card-header"><strong>온라인 강의수정</strong></div>
						<div class="card-body text-secondary">
							<div class="row">
								<div class="col-md-12">
									<div class="row">
										<label class="col-sm-1 col-form-label">강의이름</label> 
										<div class="col-sm-11">
											 <input class="form-control" name="className" id="className" value="${classInfo.className}"/>
										</div>
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-12">
									<textarea id="classContent" name="classContent">${classInfo.classContent}</textarea>
								</div>
							</div>
							<br>
							<div class="row">
								<label class="col-sm-1 col-form-label">카테고리</label> 
								<div class="col-sm-3">
									<select class="custom-select" id="classCategory" name="classCategory">
										<option value="한식" ${classInfo.classCategory=="한식"?"selected":""}>한식</option>
										<option value="분식" ${classInfo.classCategory=="분식"?"selected":""}>분식</option>
										<option value="중식" ${classInfo.classCategory=="중식"?"selected":""}>중식</option>
										<option value="일식" ${classInfo.classCategory=="일식"?"selected":""}>일식</option>
										<option value="양식" ${classInfo.classCategory=="양식"?"selected":""}>양식</option>
									</select>
								</div>
								<label class="col-sm-1 col-form-label">수강기간</label> 
								<div class="col-sm-3">
									<select class="custom-select" id="runTime" name="runTime">
										<option value="30" ${classInfo.runTime==(30*60*24)?"selected":""}>30일</option>
										<option value="60" ${classInfo.runTime==(60*60*24)?"selected":""}>60일</option>
										<option value="180" ${classInfo.runTime==(180*60*24)?"selected":""}>180일</option>
										<option value="365" ${classInfo.runTime==(365*60*24)?"selected":""}>365일</option>
									</select>
								</div>
								<label class="col-sm-1 col-form-label">수강비용</label> 
								<div class="col-sm-3">
									<input class="form-control" name="price" id="price" value="${classInfo.price}"/>
								</div>
							</div>
							<br>
							
							<div class="row">
								<label class="col-sm-1 col-form-label">강의링크</label> 
								<div class="col-sm-11 input-group mb-3">
									<input class="form-control" placeholder="URL" name="classUrl" id="classUrl" value="${classInfo.classUrl}" readonly>
									<div class="input-group-append">
										<span id="ckeck-btn-area">
											<button class="btn btn-outline-secondary" type="button" id="modifyUrl">영상수정</button>
										</span>
									</div>
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
								<div id="thumbnailImgArea">
									<img alt="썸네일" src="${classInfo.thumbnailImg}">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<input type="button" class="btn btn-block btn-outline-primary" id="submit-btn" value="수정">
				</div>
				<div class="col-md-6">
					<input type="button" class="btn btn-block btn-outline-primary" id="list-btn" value="목록">
				</div>
				<input type="hidden" name="classCode" value="${classInfo.classCode}" />
				<input type="hidden" name="classType" value="${classInfo.classType}" />
				<input type="hidden" name="contentImg" id="contentImg" value="" />
				<input type="hidden" name="thumbnailImg" id="thumbnailImg" value="" />
			</div>
			<br>
		</form>
	</div>	

<jsp:include page="../include/footer.jsp" />

<script>

	let contentImg = "${classInfo.contentImg}";
	let thumbnailImg = "${classInfo.thumbnailImg}";
	
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
		data.append("classType", "on");
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
		
		//영상확인
		$("#modifyUrl").click(function() {
			modUrlFunc();
		});
		
		function checkUrlFunc() {
			const src = $("#classUrl").val();
			openDialog(src,"영상확인","top=100px, left=50px, height=800px, width=1200px, menubar=no, toolbar=no, location=no", function(win) {
				if(confirm('영상을 확정하시겠습니까?')){
					$("#classUrl").attr("readonly", "");
					$("#ckeck-btn-area").html("<button class='btn btn-outline-secondary' type='button' id='modifyUrl'>영상수정</button>");
					chk3 = true;
					$("#modifyUrl").click(function() {
						modUrlFunc();
					});
				}
			});
		}
		
		function modUrlFunc() {
			if(confirm("영상을 수정하시겠습니까?")){
				$("#classUrl").removeAttr("readonly");
				$("#classUrl").val("");
				$("#classUrl").focus();
				chk3 = false;
				$("#ckeck-btn-area").html("<button class='btn btn-outline-secondary' type='button' id='checkUrl'>영상확인</button>");
				$("#checkUrl").click(function() {
					checkUrlFunc();
				});
			}
		}
		
		const openDialog = function(uri, popupName, options, closeCallback) {
			const win = window.open(uri, popupName, options);
			let interval = window.setInterval(function() {
				try {
					if (win == null || win.closed) {
					    window.clearInterval(interval);
					    closeCallback(win);
					}
				}
				catch (e) {
				}
			}, 1000);
			return win;
		};
		
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
				data.append("classType", "on");
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
						chk4 = true;
					}
				});
			} else {
				thumbnailImg = "";
				$("#thumbnailImgArea").html("");
				chk4 = false;
			}
		});
		
		//값 검증
		let chk1 = true, chk2 = true, chk3 = true, chk4 = true;
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
		
		//강의수정
		$("#submit-btn").click(function() {
			
			if(chk1 && chk2 && chk3 && chk4){
				$("#contentImg").val(contentImg);
				$("#thumbnailImg").val(thumbnailImg);
				$("#class-form").submit();
			} else {
				if(!chk1){
					alert("강의이름을 입력해주세요!");
				}
				if(!chk2) {
					alert("수강비용을 입력해주세요!");
				}
				if(!chk3) {
					alert("강의 URL을 확인해주세요!");
				}
				if(!chk4) {
					alert("썸네일을 등록해주세요!");
				}
			}
			
		});
		
		//강의 리스트로 다시 이동
		$("#list-btn").click(function() {
			location.href="/admin/class/on";
		});
		
	});
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</script>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="/vendor/summerNote/summernote.min.js"></script>