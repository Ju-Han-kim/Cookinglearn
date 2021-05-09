package kr.co.cookinglearn.admin.common.page;

import org.springframework.web.util.UriComponentsBuilder;

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
	
	public String mkUserUri(int currentPage) {
		String uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
				.queryParam("messagePerPage", paging.getMessagePerPage())
				.queryParam("condition", ((SearchVO)paging).getCondition())
				.queryParam("keyword", ((SearchVO)paging).getKeyword())
				.build().toString();
		return uri;
	}
	
	public String mkClassUri(int currentPage) {
		String uri;
		uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
				.queryParam("seDate", ((ClassSearchVO)paging).getSeDate())
				.queryParam("messagePerPage", paging.getMessagePerPage())
				.queryParam("classCategory", ((ClassSearchVO)paging).getClassCategory())
				.queryParam("condition", ((ClassSearchVO)paging).getCondition())
				.queryParam("keyword", ((ClassSearchVO)paging).getKeyword())
				.build().toString();
		return uri;
	}
	
	public String mkOrderUri(int currentPage) {
		
		UriComponentsBuilder uriComponent = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
				.queryParam("seDate", ((OrderSearchVO)paging).getSeDate())
				.queryParam("messagePerPage", paging.getMessagePerPage())
				.queryParam("condition", ((OrderSearchVO)paging).getCondition())
				.queryParam("keyword", ((OrderSearchVO)paging).getKeyword());
		
		for(int i=0; i<((OrderSearchVO)paging).getOrderProcess().length; i++) {
			uriComponent.queryParam("orderProcess", ((OrderSearchVO)paging).getOrderProcess()[i]);
		}
		
		return uriComponent.build().toString();
	}
	
	public String mkQnaUri(int currentPage) {
		String uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
				.queryParam("messagePerPage", paging.getMessagePerPage())
				.queryParam("complete", ((QnaSearchVO)paging).isComplete())
				.queryParam("condition", ((QnaSearchVO)paging).getCondition())
				.queryParam("keyword", ((QnaSearchVO)paging).getKeyword())
				.build().toString();
		return uri;
	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getTotalContents() {
		return totalContents;
	}

	public void setTotalContents(int totalContents) {
		this.totalContents = totalContents;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageBtn() {
		return displayPageBtn;
	}
	
}















