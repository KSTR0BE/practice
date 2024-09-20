package kr.or.ddit.vo;

import java.io.Serializable;

public class JdbcBoardVO implements Serializable{
	private Integer boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private String boardContent;
	
	public Integer getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Integer boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardNo == null) ? 0 : boardNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JdbcBoardVO other = (JdbcBoardVO) obj;
		if (boardNo == null) {
			if (other.boardNo != null)
				return false;
		} else if (!boardNo.equals(other.boardNo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "JdbcBoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardDate=" + boardDate + "]";
	}

	
	
}
