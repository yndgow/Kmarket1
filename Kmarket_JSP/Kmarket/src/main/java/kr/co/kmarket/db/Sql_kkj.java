package kr.co.kmarket.db;

public class Sql_kkj {
	
	// member 로그인
	public static final String SELECT_MEMBER = "select * from `km_member` where `uid`=? and `pass`=SHA2(?, 256)";
	
	public static final String UPDATE_USER_FOR_SESSION = "update `km_member` set `sessId`=?, `sessLimitDate` = DATE_ADD(NOW(), INTERVAL 3 DAY) where `uid`=?";
	public static final String UPDATE_USER_FOR_SESSION_OUT = "update `km_member` set `sessId`=NULL, `sessLimitDate`=NULL where `uid`=?";
	
	
	
	// member 약관
	public static final String SELECT_TERMS = "select * from `km_member_terms`";
	
	
	// member 일반회원가입
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
			+ "`level`=1, "
			+ "`rdate`=NOW()";
	
	// member 판매자회원가입
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
			+ "`level`=5, "
			+ "`rdate`=NOW()"; 
	
	// 아이디 중복체크
	public static final String SELECT_COUNT_UID  = "select count(`uid`) from `km_member` where `uid`=?";
	
	
	
	// 공지사항 list
	public static final String SELECT_NOTICE_ARTICLES = "SELECT a.*, b.cate1 FROM `km_cs_notice` AS a "
													+ "JOIN `km_cs_notice_cate1` AS b "
													+ "USING (cate1) "
													+ "ORDER BY `notNo` DESC "
													+ "LIMIT ?, 10";
	
	// 공지사항 카테고리별 list
	public static final String SELECT_NOTICE_ARTICLES_CATE1 = "SELECT * FROM `km_cs_notice` WHERE `cate1`=? ORDER BY `notNo` DESC LIMIT ?,10";
	
	// 공지사항 view
	public static final String SELECT_NOTICE_ARTICLE = "SELECT a.*, b.c1Name FROM `km_cs_notice` AS a JOIN `km_cs_notice_cate1` AS b ON a.cate1 = b.cate1 WHERE `notNo`=?";
	
	// 공지사항 전체 페이징
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`notNo`) FROM `km_cs_notice`";
	
	// 공지사항 카테고리별 페이징 
	public static final String SELECT_COUNT_CATE_TOTAL = "SELECT COUNT(`notNo`) FROM `km_cs_notice` where `cate1`=?";
	
	// 자주묻는질문 list
	public static final String SELECT_FAQ_ARTICLES = "SELECT a.*, b.c1Name, c.c2Name FROM `km_cs_faq` AS a "
													+ "JOIN `km_cs_faq_cate1` AS b ON a.cate1 = b.cate1 "
													+ "JOIN `km_cs_faq_cate2` AS c ON a.cate2 = c.cate2 AND a.cate1 = c.cate1 "
													+ "WHERE a.`cate1` =? "
													+ "ORDER BY `faNo` DESC";
													
	
	// 자주묻는질문 list 카테고리설정
	public static final String SELECT_FAQ_CATES = "SELECT * FROM `km_cs_faq_cate2` WHERE `cate1`=?";

	// 자주묻는질문 view
	public static final String SELECT_FAQ_ARTICLE = "SELECT * FROM `km_cs_faq` where `faNo`=?";
	
	
	// cs index화면에 공지사항 최신글5개 출력
	public static final String SELECT_INDEX_NOTICES = "SELECT * FROM `km_cs_notice` ORDER BY `notNo` DESC LIMIT 5";
}