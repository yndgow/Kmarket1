package kr.co.kmarket.db;

public class Sql_hong {
	
	// main best list 출력
	public static final String SELECT_MAIN_BEST_ARTICLES = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice "
														+ "FROM `km_product` ORDER BY `sold` DESC LIMIT 0,5";
	
	// main hit list 출력
	public static final String SELECT_MAIN_HIT_ARTICLES = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice "
														+ "FROM `km_product` ORDER BY `hit` DESC LIMIT 0,8";
	
	// main score list 출력
	public static final String SELECT_MAIN_SCORE_ARTICLES = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice "
			+ "FROM `km_product` ORDER BY `score` DESC LIMIT 0,8";
	
	// main new list 출력
	public static final String SELECT_MAIN_NEW_ARTICLES = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice "
			+ "FROM `km_product` ORDER BY `prodNo` DESC LIMIT 0,8";
	
	// main dis list 출력
	public static final String SELECT_MAIN_DIS_ARTICLES = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice "
			+ "FROM `km_product` ORDER BY `discount` DESC LIMIT 0,8";
	
	// test.insert admin product 김지홍
	public static final String INSERT_PRODUCT_BY_ADMIN = "INSERT INTO `km_product` SET "
			+ "`prodCate1` = ?, "
			+ "`prodCate2` = ?, "
			+ "`prodName` = ?, "
			+ "`descript` = ?, "
			+ "`company` = ?, "
			+ "`seller` = 'admin', "
			+ "`price` = ?, "
			+ "`thumb1` = ?, "
			+ "`thumb2` = ?, "
			+ "`thumb3` = ?, "
			+ "`detail` = ?, "
			+ "`ip` = ?, "
			+ "`rdate` = NOW()";

	// admin 상품출력 김지홍
	public static final String SELECT_PRODUCT_BY_ADMIN = "SELECT * FROM `km_product`";
	
	// admin category1 출력 김지홍
	public static final String SELECT_CATEGORY1_BY_ADMIN = "SELECT * FROM `km_product_cate1`";
	
	// admin category2 출력 김지홍
	public static final String SELECT_CATEGORY2_BY_ADMIN = "SELECT * FROM `km_product_cate2`";

	// member 약관
	public static final String SELECT_TERMS = "select * from `km_member_terms`";
	
	public static final String SELECT_IMG_FILENAME = "SELECT `thumb1`, `thumb2`, `thumb3`, `detail` FROM `km_product` WHERE `prodNo` = ?";

	//cs qna 문의하기 등록
	public static final String INSERT_ARTICLE_QNA_OF_CS = "INSERT INTO `km_cs_qna`(`uid`,`cate1`,`cate2`,`qnaTitle`,`qnaContent`,`regip`,`rdate`,`qnaCond`) "
													+ "VALUES(?,?,?,?,?,?,now(),'검토 중') ";
	
	// cs qna cate 출력
	public static final String SELECT_CATEGORY1_BY_CS = "SELECT * FROM `km_cs_qna_cate1`";	
	public static final String SELECT_CATEGORY2_BY_CS = "SELECT * FROM `km_cs_qna_cate2` where `cate1`=?";	
	
	// admin cs notice cate 출력
	public static final String SELECT_CATEGORY1_BY_CS_ADMIN_NOTICE = "SELECT * FROM `km_cs_notice_cate1`";	
	
	// cs index qna list 출력
	public static final String SELECT_INDEX_QNA_ARTICELS = "SELECT a.* , b.c2Name FROM (SELECT * FROM `km_cs_qna` ORDER BY `qnaNo` DESC LIMIT 0,5) AS a "
													+ "JOIN `km_cs_qna_cate2` AS b ON a.cate1 = b.cate1 "
													+ "and a.cate2 = b.cate2 "
													+ "ORDER BY `qnaNo` DESC LIMIT 0,5";
	
	// cs qna list 출력
	public static final String SELECT_QNA_ARTICLES = "SELECT a.*, b.c1Name, c.c2Name FROM km_cs_qna AS a "
													+ "JOIN km_cs_qna_cate1 AS b ON a.cate1 = b.cate1 "
													+ "JOIN km_cs_qna_cate2 AS c ON b.cate1 = c.cate1 "
													+ "and a.cate2 = c.cate2 WHERE a.cate1 = ? "
													+ "ORDER BY `qnaNo` DESC LIMIT ?, 10";
	
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `cate1`=?";
	
	// cs qna view 출력
	public static final String SELECT_QNA_ARTICLE = "SELECT a.* , b.c2Name FROM `km_cs_qna` AS a "
													+ "JOIN `km_cs_qna_cate2` AS b ON a.cate1 = b.cate1 "
													+ "and a.cate2 = b.cate2 "
													+ "where `qnaNo`=? ";
	
	// admin cs notice 전체 list 출력
	public static final String SELECT_COUNT_TOTAL_NOTICE = "SELECT COUNT(`notNo`) FROM `km_cs_notice`";
	
	public static final String SELECT_ADMIN_ALL_NOTICE_ARTICLES ="SELECT a.* , b.`c1Name` FROM `km_cs_notice` as a "
													+ "JOIN `km_cs_notice_cate1` as b "
													+ "ON a.cate1 = b.cate1 "
													+ "ORDER BY `notNo` DESC "
													+ "LIMIT ?, 10";
	
	
	// admin cs notice 유형별 list 출력
	public static final String SELECT_ADMIN_NOTICE_ARTICLES ="SELECT a.* , b.`c1Name` FROM `km_cs_notice` AS a "
													+ "JOIN `km_cs_notice_cate1` AS b "
													+ "ON a.cate1 = b.cate1 "
													+ "WHERE a.cate1 = ? "
													+ "ORDER BY `notNo` DESC "
													+ "LIMIT ?, 10";
	
	
	
	
	
	
	
	
	
	
	
}









	
	





















