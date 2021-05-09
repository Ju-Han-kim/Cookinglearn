<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


    <!-- Footer -->
    <footer>
      <div id="footer">
        <div class="footer">
          <div class="footer__company">
            <h4>
              경기도 성남시 분당구 판교로 256 7 <br />
              TEL: 031-735-6865 <br />
              EMAIL: help@cookinglearn.com <br />
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
          <!-- Commercial-banner -->
          <div class="footer__commerical">
            <img
              src="https://cdn.inflearn.com/public/files/pages/09632f15-5113-4c4c-ac50-043b92434bc8/[%E1%84%8F%E1%85%B2%E1%84%85%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%89%E1%85%A7%E1%86%AB]%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8B%E1%85%A6%E1%86%AB%E1%84%83%E1%85%B3%E1%84%87%E1%85%A6%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%E1%84%80%E1%85%A1%E1%86%BC%E1%84%8B%E1%85%B4_blog_main.gif"
              alt="광고 배너"
              width="350px"
            />
          </div>
          <!-- Comment -->
          <div class="footer__comment">
            <form role="form" method="post">
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
                name="content"
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
    </script>
  </body>
</html>
