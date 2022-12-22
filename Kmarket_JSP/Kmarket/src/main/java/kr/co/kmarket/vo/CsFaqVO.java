package kr.co.kmarket.vo;

public class CsFaqVO {
	private int faNo;
	private String uid;
	private int cate1;
	private int cate2;
	private String faTitle;
	private String faContent;
	private int hit;
	private String regip;
	private String rdate;
	
	//추가필드
	
	private String c1Name;
	private String c2Name;
	
	

	
	public int getFaNo() {
		return faNo;
	}
	public void setFaNo(int faNo) {
		this.faNo = faNo;
	}
	public void setFaNo(String faNo) {
		this.faNo = Integer.parseInt(faNo);
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
	public void setCate1(String cate1) {
		this.cate1 = Integer.parseInt(cate1);
	}
	public int getCate2() {
		return cate2;
	}
	public void setCate2(int cate2) {
		this.cate2 = cate2;
	}
	public void setCate2(String cate2) {
		this.cate2 = Integer.parseInt(cate2);
	}
	public String getFaTitle() {
		return faTitle;
	}
	public void setFaTitle(String faTitle) {
		this.faTitle = faTitle;
	}
	public String getFaContent() {
		return faContent;
	}
	public void setFaContent(String faContent) {
		this.faContent = faContent;
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
	public String getC2Name() {
		return c2Name;
	}
	public void setC2Name(String c2Name) {
		this.c2Name = c2Name;
	}
	
	
	
}