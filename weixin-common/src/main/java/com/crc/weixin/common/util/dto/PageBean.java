package com.crc.weixin.common.util.dto;

public class PageBean {

	/**
	 * 默认10条
	 */
	private int pageSize = 10;

	/**
	 * 默认从第1页开始
	 */
	private int pageNum = 1;

	/**
	 * 总记录
	 */
	private long total;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
		return;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		return;
	}

	public int getPageTotal() {
		if (this.total == 0)
			return 0;
		return (int) Math.ceil(this.total / this.pageSize);
	}

}
