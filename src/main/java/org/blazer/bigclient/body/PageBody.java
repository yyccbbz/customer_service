package org.blazer.bigclient.body;

import java.util.List;

public class PageBody<T> {

	Integer currentPage;

	Integer pageSize;

	Long total;

	List<T> rst;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRst() {
		return rst;
	}

	public void setRst(List<T> rst) {
		this.rst = rst;
	}

}
