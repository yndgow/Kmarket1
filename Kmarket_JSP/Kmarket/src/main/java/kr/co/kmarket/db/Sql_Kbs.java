package kr.co.kmarket.db;

public class Sql_Kbs {
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(`prodNo`) FROM `km_product` WHERE `seller`=?";
	
	//관리자
	public static final String SELECT_COUNT_TOTAL_ADMIN = "SELECT COUNT(`prodNo`) FROM `km_product`";
	
	
}
