package kr.co.kmarket.db;

public class Sql_kjh {
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
	
	// 사진수정(임시) 김지홍
	public static final String SELECT_IMG_FILENAME = "SELECT `thumb1`, `thumb2`, `thumb3`, `detail` FROM `km_product` WHERE `prodNo` = ?";
	
	// prodct_list 
	public static final String SELECT_PRODUCT_LIST = "SELECT * FROM `km_product` "
														+ "WHERE `prodCate1` = ? AND `prodCate2` = ? "
														+ "ORDER BY ? "
														+ "LIMIT ?, 10;";
	
	// 1차 카테고리 
	public static final String SELECT_CATEGORY_1 = "SELECT * FROM `km_product_cate1`";
	// 2차 카테고리
	public static final String SELECT_CATEGORY_2 = "SELECT * FROM `km_product_cate2`";
	// 상품 전체갯수 출력
	public static final String SELECT_PRODUCT_COUNT_PRODNO = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `prodCate1` = ? AND `prodCate2` = ?";

	
	
	
	// 판매 많은순
	public static final String SELECT_PRODUCT_LIST_SOLD_DESC = "SELECT * FROM `km_product` ORDER BY `sold` DESC";
	// 높은가격순
	public static final String SELECT_PRODUCT_LIST_PRICE_DESC = "SELECT * FROM `km_product` ORDER BY `price` DESC";
	// 낮은 가격순
	public static final String SELECT_PRODUCT_LIST_PRICE_ASC = "SELECT * FROM `km_product` ORDER BY `price` ASC";
	// 평점 높은순
	public static final String SELECT_PRODUCT_LIST_SCORE_DESC = "SELECT * FROM `km_product` ORDER BY `score` DESC";
	// 후기 많은순
	public static final String SELECT_PRODUCT_LIST_REVIEW_DESC = "SELECT * FROM `km_product` ORDER BY `review` DESC";
	// 최근 등록순
	public static final String SELECT_PRODUCT_LIST_RDATE_DESC = "SELECT * FROM `km_product` ORDER BY `rdate` DESC";
	
}









	
	





















