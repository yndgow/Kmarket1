package kr.co.kmarket.vo;

public class CsNoticeVO {
	private int notNo;
	private String uid;
	private int cate1;
	private String notTitle;
	private String notContent;
	private int hit;
	private String regip;
	private String rdate;
	
	// 추가필드
	private String c1Name;
	
	public int getNotNo() {
		return notNo;
	}
	public void setNotNo(int notNo) {
		this.notNo = notNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getCate1() {
		return cate1;
	}
	public void setCate1(int cate1) {
		this.cate1 = cate1;
	}
	public String getNotTitle() {
		return notTitle;
	}
	public void setNotTitle(String notTitle) {
		this.notTitle = notTitle;
	}
	public String getNotContent() {
		return notContent;
	}
	public void setNotContent(String notContent) {
		this.notContent = notContent;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getRegip() {
		return regip;
	}
	public void setRegip(String regip) {
		this.regip = regip;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getC1Name() {
		return c1Name;
	}
	public void setC1Name(String c1Name) {
		this.c1Name = c1Name;
	}
	
	
	
	
}