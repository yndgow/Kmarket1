package kr.co.kmarket.vo;

public class CsQnaVO {
	private int qnaNo;
	private String uid;
	private int cate1;
	private int cate2;
	private String qnaTitle;
	private String qnaContent;
	private String regip;
	private String rdate;
	private String qnaCond;
	private String answer;
	
	//추가 필드
	private String c1Name;
	private String c2Name;
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public void setQnaNo(String qnaNo) {
		this.qnaNo = Integer.parseInt(qnaNo);
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getQnaTitle() {
		return qnaTitle;
	}
	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}
	public String getQnaContent() {
		return qnaContent;
	}
	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
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
	public String getQnaCond() {
		return qnaCond;
	}
	public void setQnaCond(String qnaCond) {
		this.qnaCond = qnaCond;
	}
	public int getQnaNo() {
		return qnaNo;
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
