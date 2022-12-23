package kr.co.kmarket.db;

public class Sql_kkj {
	
	// member 로그인
	public static final String SELECT_MEMBER = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String UPDATE_USER_FOR_SESSION = "update `km_member` set `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) where `uid`=?";
	public static final String UPDATE_USER_FOR_SESSION_OUT = "update `km_member` set `sessId`=NULL, `sessLimitDate`=NULL where `uid`=?";
	
	
	
	// member 약관
	public static final String SELECT_TERMS = "select * from `km_member_terms`";
	
	
	// member 회원가입
	public static final String INSERT_MEMBER      = "insert into `km_member` set "
			+ "`uid`=?, "
			+ "`pass`=SHA2(?, 256), "
			+ "`name`=?, "
			+ "`gender`=?, "
			+ "`email`=?, "
			+ "`type`=1, "
			+ "`hp`=?, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`regip`=?, "
			+ "`rdate`=NOW()";
	
	public static final String INSERT_SELLER      = "insert into `km_member` set "
			+ "`uid`=?, "
			+ "`pass`=SHA2(?, 256), "
			+ "`company`=?, "
			+ "`ceo`=?, "
			+ "`bizRegNum`=?, "
			+ "`comRegNum`=?, "
			+ "`tel`=?, "
			+ "`fax`=?, "
			+ "`zip`=?, "
			+ "`addr1`=?, "
			+ "`addr2`=?, "
			+ "`regip`=?, "
			+ "`type`=2, "
			+ "`rdate`=NOW()"; 
	
	public static final String SELECT_COUNT_UID  = "select count(`uid`) from `km_member` where `uid`=?";
	
	
	
	public static final String SELECT_NOTICE_ARTICLES = "SELECT a.*, b.cate1 FROM `km_cs_notice` AS a "
													+ "JOIN `km_cs_notice_cate1` AS b "
													+ "USING (cate1) "
													+ "ORDER BY `notNo` DESC "
													+ "LIMIT ?, 10";
	
	public static final String SELECT_NOTICE_ARTICLES_CATE1 = "SELECT * FROM `km_cs_notice` WHERE `cate1`=? ORDER BY `notNo` DESC LIMIT ?,10";
	
	public static final String SELECT_NOTICE_ARTICLE = "SELECT * FROM `km_cs_notice` where `notNo`=?";
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`notNo`) FROM `km_cs_notice`";
	
	public static final String SELECT_COUNT_CATE_TOTAL = "SELECT COUNT(`notNo`) FROM `km_cs_notice` where `cate1`=?";
	
	public static final String SELECT_FAQ_ARTICLES = "SELECT a.*, b.c1Name, c.c2Name FROM `km_cs_faq` AS a "
													+ "JOIN `km_cs_faq_cate1` AS b ON a.cate1 = b.cate1 "
													+ "JOIN `km_cs_faq_cate2` AS c ON a.cate2 = c.cate2 AND a.cate1 = c.cate1 "
													+ "WHERE a.`cate1` =? "
													+ "ORDER BY `faNo` DESC";
													
													
	
	
	public static final String SELECT_FAQ_CATES = "SELECT * FROM `km_cs_faq_cate2` WHERE `cate1`=?";


	public static final String SELECT_FAQ_ARTICLE = "SELECT * FROM `km_cs_faq` where `faNo`=?";
	
	
	public static final String SELECT_INDEX_NOTICES = "SELECT * FROM `km_cs_notice` ORDER BY `notNo` DESC LIMIT 5";
}