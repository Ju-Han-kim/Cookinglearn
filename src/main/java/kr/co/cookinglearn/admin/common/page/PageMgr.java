package kr.co.cookinglearn.admin.common.page;

import java.sql.Timestamp;

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
		
		if(((ClassSearchVO)paging).getStartDate() == null || ((ClassSearchVO)paging).getStartDate().equals(Timestamp.valueOf("")) ) {
			uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
					.queryParam("messagePerPage", paging.getMessagePerPage())
					.queryParam("classCategory", ((ClassSearchVO)paging).getClassCategory())
					.queryParam("condition", ((ClassSearchVO)paging).getCondition())
					.queryParam("keyword", ((ClassSearchVO)paging).getKeyword())
					.build().toString();
		} else {
			uri = UriComponentsBuilder.newInstance().queryParam("currentPage", currentPage)
					.queryParam("messagePerPage", paging.getMessagePerPage())
					.queryParam("startDate", ((ClassSearchVO)paging).getStartDate())
					.queryParam("endDate", ((ClassSearchVO)paging).getEndDate())
					.queryParam("classCategory", ((ClassSearchVO)paging).getClassCategory())
					.queryParam("condition", ((ClassSearchVO)paging).getCondition())
					.queryParam("keyword", ((ClassSearchVO)paging).getKeyword())
					.build().toString();
		}
		return uri;
	}
	
}















