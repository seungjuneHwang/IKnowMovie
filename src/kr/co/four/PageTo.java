package kr.co.four;

import java.io.Serializable;
import java.util.ArrayList;

public class PageTo implements Serializable {

	private ArrayList<TableDTO> boardlist;
	private int curPage;
	private int perPage;
	private int totalCount;

	public PageTo() {

		this.perPage = 13;
	}

	public ArrayList<TableDTO> getBoardlist() {
		return boardlist;
	}

	public void setBoardlist(ArrayList<TableDTO> boardlist) {
		this.boardlist = boardlist;
		
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageTo [boardlist=" + boardlist + ", curPage=" + curPage + ", perPage=" + perPage + ", totalCount="
				+ totalCount + "]";
	}

}