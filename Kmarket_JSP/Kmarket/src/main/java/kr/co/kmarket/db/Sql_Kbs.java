package kr.co.kmarket.db;

public class Sql_Kbs {
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `seller`=? ";
	
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
			+ "`c1Name` = ?, "
			+ "`notTitle`= ?, "
			+ "`notContent`=? ";
}
