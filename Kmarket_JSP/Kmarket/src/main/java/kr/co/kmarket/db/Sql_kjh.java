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
	public static final String SELECT_PRODUCT_LIST = "SELECT *, CEIL(price*(100-discount)/100) AS discountPrice FROM `km_product` "
														+ "WHERE `prodCate1` = ? AND `prodCate2` = ? "
														+ "ORDER BY ";
	// 1차 카테고리 
	public static final String SELECT_CATEGORY_1 = "SELECT * FROM `km_product_cate1`";
	// 2차 카테고리
	public static final String SELECT_CATEGORY_2 = "SELECT * FROM `km_product_cate2`";
	// 상품 전체갯수 출력
	public static final String SELECT_PRODUCT_COUNT_PRODNO = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `prodCate1` = ? AND `prodCate2` = ?";
	// 상품 한개 출력
	public static final String SELECT_PRODUCT = "SELECT * FROM `km_product` WHERE `prodNo` = ?";
	// 리뷰 출력
	public static final String SELECT_REVIEWS = "SELECT * FROM `km_product_review` WHERE `prodNo` = ? ORDER BY `rdate` DESC LIMIT ?, 5;";
	// 리뷰 전체갯수 출력
	public static final String SELECT_REVIEW_COUNT_PRODNO ="SELECT COUNT(`revNo`) FROM `km_product_review` WHERE `prodNo` = ?";
	// 장바구니 입력
	public static final String INSERT_PRODUCTCART = "INSERT INTO `km_product_cart` SET "
			+ "`uid` = ?, "
			+ "`prodNo` = ?, "
			+ "`count` = ?, "
			+ "`price` = ?, "
			+ "`discount` = ?, "
			+ "`point` = (`price` * `count`) * 0.01, "
			+ "`delivery` = ?, "
			+ "`total` = ((`price` * (100-`discount`)/100)  * `count`) + `delivery`, "
			+ "`rdate` = NOW()";
	// 장바구니 출력
	public static final String SELECT_PRODUCTCARTS = "SELECT a.*, b.thumb1, b.descript, b.prodName "
													+ "FROM `km_product_cart` AS a "
													+ "JOIN `km_product` AS b "
													+ "USING (`prodNo`) "
													+ "WHERE `uid` = ? ";
	
	// 장바구니 이미 있는지 여부
	public static final String SELECT_PRODUCTCART = "SELECT COUNT(`prodNo`) FROM `km_product_cart` "
													+ "WHERE `uid` = ? AND `prodNo` = ?";
	// 장바구니 이미 있으면 수량 증가 
	public static final String UPDATE_PRODUCTCART_COUNT = "UPDATE `km_product_cart` SET "
														+ "`count` = `count`+1, "
														+ "`point`= `price`* `count` * 0.01, "
														+ "`total` = `price` * `count` + `delivery` "
														+ "WHERE `uid` = ? AND `prodNo` = ?";
	// 장바구니 선택 삭제
	public static final String DELTE_PRODUCTCART = "DELETE FROM `km_product_cart` WHERE `uid` = ? AND `prodNo` IN (";
												
}









	
	





















