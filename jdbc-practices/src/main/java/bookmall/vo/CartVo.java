package bookmall.vo;

public class CartVo {
	private Long bookNo;
	private Long memberNo;
	private Long bookCount;
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getBookCount() {
		return bookCount;
	}
	public void setBookCount(Long bookCount) {
		this.bookCount = bookCount;
	}
	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", memberNo=" + memberNo + ", bookCount=" + bookCount + "]";
	}
	
	
}
