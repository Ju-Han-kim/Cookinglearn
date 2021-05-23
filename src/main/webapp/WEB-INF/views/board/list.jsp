<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title here</title>
</head>
<body>
<!-- Header -->
<jsp:include page="../include/header.jsp" />

<style type="text/css">
	.container {
	  width: 1240px;
	  max-width: none !important;
	  margin-left: auto;
	  margin-right: auto;
	}
	
	#contents_area_full {
	  padding: 20px 0 20px 0;
	}
	
	.contents_title {
	  font-size: 28px;
	  padding-top: 14px;
	  border-bottom: 1px solid #e6e7e8;
	  padding: 6px 4px 12px;
	  margin: 14px 30px 0;
	}
	
	.class_list {
	  margin-top: 30px;
	  padding: 0 22px;
	}
	
	.class_list_ul {
	  margin: 0;
	  vertical-align: top;
	}
	
	.class_list_li {
	  width: 282px;
	  list-style: none;
	  margin: 0 12px 40px 0;
	  display: inline-block;
	  vertical-align: top;
	  position: relative;
	}
	
	.cli_thumb {
	  position: relative;
	  border-radius: 4px;
	  overflow: hidden;
	}
	
	.cli_thumb a {
	  color: rgb(42, 42, 42);
	  text-decoration: none;
	}
	
	.cli_thumb img {
	  width: 100%;
	}
	
	.cli_caption {
	  padding: 10px 2px;
	}
	
	.cli_caption_title {
	  overflow: hidden;
	  text-overflow: ellipsis;
	  display: -webkit-box;
	  -webkit-box-orient: vertical;
	  word-wrap: break-word;
	  white-space: normal;
	  line-height: 1.5;
	  margin: 0 0 6px 0;
	  color: rgb(42, 42, 42);
	  text-align: left;
	  font-size: 15px;
	}
	
	.cli_caption_price_box {
	  padding: 0;
	  margin: 0 0 4px 0;
	  line-height: 1;
	}
	
	.cli_caption_price {
	  font-size: 20px;
	  color: rgb(247, 183, 6);
	  font-weight: 700;
	  letter-spacing: -0.02em;
	}
	
	.cli_caption_price small {
	  font-weight: 700;
	  color: rgb(247, 183, 6);
	  font-size: 14px;
	  margin-left: 1px;
	}
	
	.cli_caption_rv {
	  vertical-align: super;
	  line-height: 1;
	  margin: 0 0 9px 0;
	}
</style>
<!-- Content Area -->
    <div class="container">
      <div id="contents_area_full" style="clear: both">
        <div class="contents_title">전체 클래스</div>
        <div class="class_list">
          <ul class="class_list_ul" style="padding: 0 0 0 8px">
            <li class="class_list_li">
              <div class="cli_thumb">
              <div class="cli_caption">
              <c:forEach items="${list}" var = "list">
				<img src="<spring:url value='/resources/board/img/${list.thumbnailImg}'/>"> <br/>
				<a href="/board/viewDetail?viewDetail=${list.classCode}">
                <div class="cli_caption_title">
                  ${list.className}
                </div>
                <div class="cli_caption_price_box">
                  <strong class="cli_caption_price">
                  ${list.price}<small>원</small>
                  </strong>
			  </c:forEach>
              </div>
                <div class="cli_caption_rv" style="display: inline-block; font-size: 0"></div>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
	<!-- footer -->
	<jsp:include page="../include/footer.jsp" />	
</body>
</html>