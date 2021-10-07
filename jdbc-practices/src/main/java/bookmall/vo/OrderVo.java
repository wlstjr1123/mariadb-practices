package bookmall.vo;

public class OrderVo {
	private Long no;
	private Long memberNo;
	private String orderNo;
	private int payment;
	private String orderName;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", memberNo=" + memberNo + ", orderNo=" + orderNo + ", payment=" + payment
				+ ", orderName=" + orderName + "]";
	}

	
}
