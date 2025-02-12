package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "lprodGu")
public class LprodVO {
	private Integer lprodId;
	private String lprodGu;
	private String lprodNm;
	
	private List<BuyerVO> buyerList;//1 : N - has Many 관계 부모가 중심이라서
}
