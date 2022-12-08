package kr.co.kmarket.db;

public class Sql {
	// test.insert admin product
	public static final String INSERT_PRODUCT_BY_ADMIN = "INSERT INTO `km_product` SET "
			+ "`prodCate1` = ?, `prodCate2` = ?, `prodName` = ?, `descript` = ?, `company` = ?, `seller` = 'admin', `price` = ?, `rdate`=NOW(), thumb1 ='1', thumb2 ='2', thumb3 ='3'";
	
}





















