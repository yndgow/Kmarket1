package kr.co.kmarket.db;

public class Sql {
	////////////////////////////////////////// default
	
	// test.insert admin product 김지홍
	public static final String INSERT_PRODUCT_BY_ADMIN = "INSERT INTO `km_product` SET "
			+ "`prodCate1` = ?, "
			+ "`prodCate2` = ?, "
			+ "`prodName` = ?, "
			+ "`descript` = ?, "
			+ "`company` = ?, "
			+ "`price` = ?, "
			+ "`discount` = ?, "
			+ "`point` = ?, "
			+ "`stock` = ?, "
			+ "`delivery` = ?, "
			+ "`thumb1` = ?, "
			+ "`thumb2` = ?, "
			+ "`thumb3` = ?, "
			+ "`detail` = ?, "
			+ "`seller` = ?, "
			+ "`status` = ?, "
			+ "`duty` = ?, "
			+ "`receipt` = ?, "
			+ "`bizType` = ?, "
			+ "`origin` = ?, "
			+ "`ip` = ?, "
			+ "`etc3` = ?, "
			+ "`rdate`=NOW()";

	// admin 상품출력 김지홍
	public static final String SELECT_PRODUCT_BY_ADMIN = "SELECT * FROM `km_product` ORDER BY `prodNo` DESC ";
	
	// admin category1 출력 김지홍
	public static final String SELECT_CATEGORY1_BY_ADMIN = "SELECT * FROM `km_product_cate1`";
	
	// admin category2 출력 김지홍

	public static final String SELECT_CATEGORY2_BY_ADMIN = "SELECT * FROM `km_product_cate2` WHERE `cate1` = ?";

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
	public static final String SELECT_COUNT_TOTAL_NOTICE = "SELECT COUNT(`notNo`) FROM `km_cs_notice`";
	
	// 공지사항 카테고리별 페이징 
	public static final String SELECT_COUNT_TOTAL_NOTICE_CATE1 = "SELECT COUNT(`notNo`) FROM `km_cs_notice` where `cate1`=?";
	
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
	
	
	////////////////////////////////////////// hmj
	
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
	
	public static final String SELECT_COUNT_TOTAL_QNA_CATE1 = "SELECT COUNT(`qnaNo`) FROM `km_cs_qna` WHERE `cate1`=?";
	
	// cs qna view 출력
	public static final String SELECT_QNA_ARTICLE = "SELECT a.* , b.c2Name FROM `km_cs_qna` AS a "
													+ "JOIN `km_cs_qna_cate2` AS b ON a.cate1 = b.cate1 "
													+ "and a.cate2 = b.cate2 "
													+ "where `qnaNo`=? ";
	
	// admin cs notice 전체 list 출력
	
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
	
	
	
	////////////////////////////////////////// kbs
	
	public static final String SELECT_COUNT_TOTAL_ADMIN_ALL = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `seller`=? ";
	
	//관리자
	public static final String SELECT_COUNT_TOTAL_ADMIN = "SELECT COUNT(`prodNo`) FROM `km_product`";
	
	//public static final String SELECT_PRODUCT_BY_KYEWORD = "SELECT * FROM `km_product` WHERE `seller`=? AND (`prodName` LIKE ? OR `prodNo` LIKE ? OR  `company` LIKE ? OR `seller` LIKE ?) ORDER BY `prodNo` DESC LIMIT ?,10";
	
	public static final String SELECT_COUNT_TOTAL_FOR_SEARCH = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE ";
	
	public static final String SELECT_PRODUCTS = "SELECT * FROM `km_product` WHERE `seller`=? ORDER BY `prodNo` DESC LIMIT ?, 10  ";
	
	// admin
	public static final String SELECT_PRODUCTS_ADMIN = "SELECT * FROM `km_product` ORDER BY `prodNo` DESC LIMIT ?, 10 ";
	
	//public static final String SELECT_ADMIN_SEARCH_KEYWORDS = "SELECT * FROM `km_product` WHERE (`prodName` LIKE ? OR `prodNo` LIKE ? OR  `company` LIKE ? OR `seller` LIKE ?) ORDER BY `prodNo` DESC LIMIT 10";
	
	public static final String DELETE_ADMIN = "DELETE FROM `km_product` WHERE `prodNo`=?";
	
	//admin Cs notice
	public static final String DELETE_ADMIN_CS_NOTICE ="DELETE FROM `km_cs_notice` WHERE `notNo`=?";
	
	public static final String INSERT_ADMIN_CS_NOT = "INSERT INTO `km_cs_notice` SET "
													+ "`cate1` = ?, "
													+ "`notTitle`= ?, "
													+ "`notContent`= ?,"
													+ "`regip` = ?,"
													+ "`rdate` = NOW() ";
	public static final String SELECT_MAX_NOTNO = "SELECT MAX(`notNo`) FROM `km_cs_notice`";
	public static final String UPDATE_ADMIN_CS_NOTICE = "UPDATE `km_cs_notice` SET "
														+ "`cate1` = ?, "
														+ "`notTitle`= ?, "
														+ "`notContent` = ? "
														+ "WHERE `notNo` = ?";
	
	//////////////////////////////// kjh
	
	// test.insert admin product 김지홍
	
	// 사진수정(임시) 김지홍
	public static final String SELECT_IMG_FILENAME = "SELECT `thumb1`, `thumb2`, `thumb3`, `detail`, `etc3` FROM `km_product` WHERE `prodNo` = ?";
	
	// prodct_list 
	public static final String SELECT_PRODUCT_LIST = "SELECT *, CEIL(price*(100-discount)/100) AS discountprice FROM `km_product` "
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
	public static final String SELECT_REVIEWS = "SELECT a.*, b.prodName "
												+ "FROM `km_product_review` AS a "
												+ "JOIN `km_product` AS b "
												+ "USING(`prodNo`) "
												+ "WHERE `prodNo` = ? "
												+ "ORDER BY b.`rdate` DESC "
												+ "LIMIT ?, 5;";
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
	public static final String SELECT_PRODUCTCARTS = "SELECT a.*, b.thumb1, b.descript, b.prodName, b.etc3 "
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
	public static final String SELECT_PRODUCTCART_FOR_ORDER = "SELECT a.*, b.thumb1, b.descript, b.prodName, b.etc3	"
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
	public static final String SELECT_PRODUCT_COMPLETE = "SELECT a.*, b.*, c.prodName ,c.descript, c.thumb1, c.etc3 "
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
												+ "`cate1` = ?, "
												+ "`cate2`= ?, "
												+ "`rdate` = NOW() "
												+ "WHERE `faNo` = ?";
	
	// faq cate list
	public static final String SELECT_FAQ_CATE_LIST = "SELECT a.*, b.cate2, b.c2Name "
													+ "FROM km_cs_faq_cate1 AS a "
													+ "JOIN km_cs_faq_cate2 AS b "
													+ "ON a.cate1 = b.cate1";

}









	
	





















