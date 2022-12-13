package kr.co.kmarket.db;

public class Sql_hong {
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
	public static final String INSERT_ARTICLE_QNA_OF_CS = "INSERT INTO `km_cs_qna` values(?,?,?,?,?,?,now(),'검토 중')";
	
	// cs qna cate 출력
	public static final String SELECT_CATEGORY1_BY_CS = "SELECT * FROM `km_cs_cate1`";	
	public static final String SELECT_CATEGORY2_BY_CS = "SELECT * FROM `km_cs_cate2` where `qnaCate1`=?";	
	
	// cs qna list 출력
	public static final String SELECT_QNA_ARTICLES = "SELECT * FROM `km_cs_qna`";
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}









	
	





















