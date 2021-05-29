<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <!-- Footer -->
    <footer>
      <div id="footer">
        <div class="footer">
          <div class="footer__company">
            <h4>
              경기도 성남시 분당구 판교로 256 7 <br />
              TEL: 031-735-6865 <br />
              EMAIL: cookinglearn@hotmail.com <br />
              FAX: 323 5049 <br /><br />
              Copyright ©CookingLearn Inc. All Rights Reserved <br />
            </h4>
            <div class="footer__company-sns">
              <span>
                <a href="/"><i class="fab fa-facebook"></i></a>
              </span>
              <span>
                <a href="/"><i class="fab fa-instagram"></i></a>
              </span>
              <span>
                <a href="/"><i class="fab fa-youtube"></i></a>
              </span>
            </div>
          </div>
          <!-- Comment -->
          <div class="footer__comment">
            <form role="form" action="/" method="post">
              <input
                type="text"
                name="title"
                class="form-title"
                rows="1"
                placeholder="제목"
                spellcheck="false"
              />
              <textarea
                id="customerSend"
                name="qnaContent"
                class="form-comment"
                placeholder="불편사항이나 제안사항&ZeroWidthSpace;&ZeroWidthSpace;이 있으신가요?&#13;&#10;쿠킹런에 전하고 싶은 문의를 남겨주세요."
                spellcheck="false"
              ></textarea>
              <input type="submit" value="문의 제출" class="btn btn-comment" />
            </form>
          </div>
        </div>
      </div>
    </footer>
    <button class="arrow-up">
      <i class="far fa-arrow-alt-circle-up"></i>
    </button>
    <script>
      const message = "${msg}";
      if(message === "modSuccess") {
         alert("의견이 성공적으로 접수되었습니다.");
      }
      if(message === "modFail") {
    	 alert("해당 서비스 이용을 위해선 로그인이 필요합니다.")
      }
      
      $(function(){
    	    // this will get the full URL at the address bar
    	    var url = window.location.href; 

    	    // passes on every "a" tag 
    	    $("ul.navbar__menu a").each(function() {
    	            // checks if its the same on the address bar
    	        if(url == (this.href)) { 
    	            $(this).closest("li").addClass("active");
    	        }
    	    });
    	});
      
    </script>
  </body>
</html>
