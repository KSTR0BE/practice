package kr.or.ddit.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 한번의 구매정보를 담을 VO
 *
 */
@Data
@EqualsAndHashCode(of = "cartNo")
public class VcartVO {
	private String cartNo;
	private LocalDate cartDate;
	private int cartSeq;
	private String cartMember;
	private List<VcartProdVO> cartProdList; // 한번의 구매로 N 개의 상품을 구매함.

}
