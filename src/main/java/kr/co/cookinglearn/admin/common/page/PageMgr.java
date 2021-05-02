package kr.co.cookinglearn.admin.common.page;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageMgr {
	
	private PageVO paging;
	private int totalContents;
	private int totalPage;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private final int displayPageBtn = 10;

	public PageMgr(PageVO paging, int totalContents) {
		this.prev = true;
		this.next = true;
		this.paging = paging;
		this.totalContents = totalContents;
		
		calcPage();
	}
	
	private void calcPage() {
		this.totalPage = (int)Math.ceil(this.totalContents/(double)this.paging.getMessagePerPage());
		
		if(this.paging.getCurrentPage() < 1) 
			this.paging.setCurrentPage(1);
		if(this.paging.getCurrentPage() > this.totalPage) 
			this.paging.setCurrentPage(totalPage);
		
		this.endPage = (int)Math.ceil(this.paging.getCurrentPage()/(double)displayPageBtn)*displayPageBtn;
		this.startPage = this.endPage - displayPageBtn + 1;
		
		if(this.endPage >= this.totalPage) {
			this.endPage = this.totalPage;
			this.next = false;
		}
		if(this.startPage <= 1) { 
			this.startPage = 1;
			this.prev = false;
		}
	}
	
	public String mkUri(int currentPage) {
		String uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
				.queryParam("messagePerPage", paging.getMessagePerPage())
				.queryParam("condition", ((UserSearchVO)paging).getCondition())
				.queryParam("keyword", ((UserSearchVO)paging).getKeyword())
				.build().toString();
		return uri;
	}
	
}















