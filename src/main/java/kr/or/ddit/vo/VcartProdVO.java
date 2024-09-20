package kr.or.ddit.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 구매상품 하나의 정보를 담을 VO
 *
 */
@Data
@EqualsAndHashCode(of = "cartNo")
public class VcartProdVO {
	private String cartNo;
	private String cartProd;
	private int cartQty;
	
	private ProdVO prod; //has A
}
