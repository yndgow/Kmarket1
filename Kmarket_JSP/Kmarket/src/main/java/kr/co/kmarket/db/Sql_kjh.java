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
	// 상품 한개 출력시 조회수 업데이트
	public static final String UPDATE_PRODUCT_HIT = "UPDATE `km_product` SET `hit` = `hit` + 1 WHERE `prodNo` = ?";
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
	public static final String DELETE_PRODUCTCART = "DELETE FROM `km_product_cart` WHERE `cartNo` IN (";
	
	public static final String INSERT_PRODUCTORDER = "INSERT INTO `km_product_order` SET "
													+ "`ordUid` = ?, "
													+ "`ordCount` = ?, "
													+ "`ordPrice` = ?, "
													+ "`ordDiscount` = ?, "
													+ "`ordDelivery` = ?, "
													+ "`savePoint` = ?, "
													+ "`ordTotPrice` = ?, "
													+ "`recipName` = ?, "
													+ "`recipHp` = ?, "
													+ "`recipZip` = ?, "
													+ "`recipAddr1` = ?, "
													+ "`recipAddr2` = ?, "
													+ "`ordDate` = NOW()";
	
	// 주문 페이지 장바구니 부분 출력
	public static final String SELECT_PRODUCTCART_FOR_ORDER = "SELECT a.*, b.thumb1, b.descript, b.prodName	"
															+ "FROM `km_product_cart` AS a "
															+ "JOIN `km_product` AS b "
															+ "USING (`prodNo`) "
															+ "WHERE `uid` = ? "
															+ "AND `cartNo` IN(";
	
	// 최신 주문 출력
	public static final String SELECT_ORDER = "SELECT * FROM `km_product_order` WHERE `ordUid` = ? ORDER BY `ordNo` DESC LIMIT 1";
	
	// 주문 상품 입력
	public static final String INSERT_PRODUCTORDERITEM  = "INSERT INTO `km_product_order_item` SET "
														+ "`ordNo` = ?, "
														+ "`prodNo` = ?, "
														+ "`count` = ?, "
														+ "`price` = ?, "
														+ "`discount` = ?, "
														+ "`point` = ?, "
														+ "`delivery` = ?, "
														+ "`total` = ?";
	
	// 주문 정보 업데이트
	public static final String UPDATE_PRODUCTORDER = "UPDATE `km_product_order` SET "
													+ "`usedPoint` = ?, "
													+ "`ordTotPrice` = ?, "
													+ "`recipName` = ?, "
													+ "`recipHp` = ?, "
													+ "`recipZip` = ?, "
													+ "`recipAddr1` = ?, "
													+ "`recipAddr2` = ?, "
													+ "`ordPayment` = ?, "
													+ "`ordComplete` = ?, "
													+ "`ordDate` = NOW() WHERE "
													+ "`ordUid` = ? AND "
													+ " `ordNo` = ?";
	
	// member DB 포인트 업데이트 추후 멤버로 이동
	public static final String UPDATE_MEMBER_POINT = "UPDATE `km_member` SET "
													+ "`point` = ? "
													+ "WHERE `uid` = ?";
	
	// point 적립 입력
	public static final String INSERT_POINT = "INSERT INTO `km_member_point` SET "
			+ "`uid` = ?, "
			+ "`ordNo` = ?, "
			+ "`point` = ?, "
			+ "`pointDate` = NOW()";
	
	// 장바구니 주문물품 삭제
	public static final String DELETE_PRODUCTCART_ORDERED = "DELETE FROM `km_product_cart` WHERE `cartNo` IN (";
	
	// 주문완료 출력
	public static final String SELECT_PRODUCT_COMPLETE = "SELECT a.*, b.*, c.prodName ,c.descript, c.thumb1 "
														+ "FROM `km_product_order` AS a "
														+ "JOIN `km_product_order_item` AS b "
														+ "USING (`ordNo`)"
														+ "JOIN `km_product` AS c "
														+ "USING (`prodNo`) "
														+ "WHERE `ordNo` = ?";
	// 주문완료시 재고 감소
	public static final String UPDATE_PRODUCT_STOCK = "UPDATE `km_product` SET `stock`= `stock` - ? WHERE `prodNo` = ?";
	
	
	
	// admin cs 부분
	// faq list
	public static final String SELECT_ADMIN_CS_FAQ_LIST_CATE = "SELECT a.*, b.c1Name, c.c2Name "
																+ "FROM `km_cs_faq` AS a "
																+ "JOIN `km_cs_faq_cate1` AS b "
																+ "ON a.cate1 = b.cate1 "
																+ "JOIN `km_cs_faq_cate2` AS c "
																+ "ON b.cate1 = c.cate1 and a.cate2 = c.cate2 "
																+ "WHERE a.`cate1` = ? AND a.`cate2` = ?";
	// qna list all
	public static final String SELECT_ADMIN_CS_QNA_LIST_ALL = "SELECT a.*, b.c1Name, c.c2Name "
															+ "FROM `km_cs_qna` AS a "
															+ "JOIN `km_cs_qna_cate1` AS b "
															+ "ON a.cate1 = b.cate1 "
															+ "JOIN `km_cs_qna_cate2` AS c "
															+ "ON b.cate1 = c.cate1 and a.cate2 = c.cate2 "
															+ "ORDER BY (`qnaNo`) DESC "
															+ "LIMIT ?, 10";
	// qna list cate
	public static final String SELECT_ADMIN_CS_QNA_LIST_CATE = "SELECT a.*, b.c1Name, c.c2Name "
																+ "FROM `km_cs_qna` AS a "
																+ "JOIN `km_cs_qna_cate1` AS b "
																+ "ON a.cate1 = b.cate1 "
																+ "JOIN `km_cs_qna_cate2` AS c "
																+ "ON b.cate1 = c.cate1 and a.cate2 = c.cate2 "
																+ "WHERE a.`cate1` = ? AND a.`cate2` = ? "
																+ "ORDER BY (`qnaNo`) DESC "
																+ "LIMIT ?, 10";
	
	// cs view qna
	public static final String SELECT_ADMIN_CS_QNA_VIEW = "SELECT a.*, b.c1Name, c.c2Name "
													+ "FROM `km_cs_qna` AS a "
													+ "JOIN `km_cs_qna_cate1` AS b "
													+ "ON a.cate1 = b.cate1 "
													+ "JOIN `km_cs_qna_cate2` AS c "
													+ "ON b.cate1 = c.cate1 and a.cate2 = c.cate2 "
													+ "WHERE a.`cate1` = ? "
													+ "AND a.`cate2` = ? "
													+ "AND `qnaNo` = ?";
	
	// cs view faq
	public static final String SELECT_ADMIN_CS_FAQ_VIEW = "SELECT a.*, b.c1Name, c.c2Name "
													+ "FROM `km_cs_faq` AS a "
													+ "JOIN `km_cs_faq_cate1` AS b "
													+ "ON a.cate1 = b.cate1 "
													+ "JOIN `km_cs_faq_cate2` AS c "
													+ "ON b.cate1 = c.cate1 and a.cate2 = c.cate2 "
													+ "WHERE a.`cate1` = ? "
													+ "AND a.`cate2` = ? "
													+ "AND `faNo` = ?";
	
	public static final String SELECT_FAQ_VIEW_FANO = "SELECT a.*, b.c1Name, c.c2Name "
														+ "FROM km_cs_faq AS a "
														+ "JOIN km_cs_faq_cate1 AS b "
														+ "ON a.cate1 = b.cate1 "
														+ "JOIN km_cs_faq_cate2 AS c "
														+ "ON a.cate2 = c.cate2 AND b.cate1 = c.cate1 "
														+ "WHERE faNo = ?";
	
	// cs insert
	public static final String INSERT_ADMIN_CS_FAQ = "INSERT INTO `km_cs_faq` SET "
													+ "`cate1` = ?, "
													+ "`cate2` = ?, "
													+ "`faTitle` = ?, "
													+ "`faContent` = ?, "
													+ "`regip` = ?, "
													+ "`rdate` = NOW()";
	// qna count max 10 
	public static final String SELECT_COUNT_FAQ_CATE2 = "SELECT COUNT(`faNo`) FROM km_cs_faq WHERE `cate1`= ? AND `cate2` = ?";
	
	// qna answer
	public static final String UPDATE_QNA_ANSWER = "UPDATE `km_cs_qna` SET "
													+ "`answer`= ?, "
													+ "`qnaCond`='답변완료' "
													+ "WHERE `qnaNo` = ?";
	
	// qna count total all
	public static final String SELECT_COUNT_TOTAL_QNA = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna`";
	
	// qna count total cate
	public static final String SELECT_COUNT_TOTAL_QNA_CATE = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `cate1` = ? AND `cate2` = ?";
	
	// qna update delete
	public static final String DELETE_QNA = "DELETE FROM `km_cs_qna` WHERE `qnaNo` = ?";
	
	// qna delete check
	public static final String DELETE_FAQ = "DELETE FROM `km_cs_faq` WHERE `faNo` = ?";
	
	// faq update
	public static final String UPDATE_ADMIN_FAQ = "UPDATE `km_cs_faq` SET "
												+ "`faTitle` = ?, "
												+ "`faContent` = ?, "
												+ "`regip` = ?, "
												+ "`rdate` = NOW() "
												+ "WHERE `faNo` = ?";
}











	
	





















