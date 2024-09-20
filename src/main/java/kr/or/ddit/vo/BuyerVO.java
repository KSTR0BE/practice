package kr.or.ddit.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Mybatis 데이터 매퍼로 2개 이상의 조인하는 단계
 * 1. 사용할 테이블 간의 관계 파악
 * 		- 중심 데이터를 가진 메인 테이블을 1로 관계 설정
 * 		1 : 1 - 자식이 메인 테이블인 경우.
 * 		ex) 하나의 상품은 하나의 제조사를 가짐.
 * 		1 : N - 부모가 메인 테이블인 경우.
 * 		ex) 하나의 제조사는 여러개의 상품을 가짐.
 * 2. Domain Layer 설계시 1번의 관계를 VO에 반영.
 * 		1 : 1 - 자식은 has 부모
 * 		ex) ProdVO has A BuyerVO, ProdVO has A LprodVO
 * 		1 : N - 부모는 has Many 자식
 *		ex) BuyerVO has Many ProdVO, LprodVO has Many ProdVO, LprodVO has Many BuyerVO
 * 3. 조인 쿼리 작성
 * 		1 : 1 자식 INNER JOIN 부모
 * 		1 : N 부모 LEFT OUTER JOIN 자식 (방향은 부모쪽이다)
 * 4. resultType 대신 resulyMap 사용
 * 		1 : 1 -> has A -> association
 * 		1 : N -> has Many -> collection (중복 제거를 위한 id 설정 필수)
 */
@Data
@EqualsAndHashCode(of = {"buyerId"})
public class BuyerVO {
	@NotBlank(groups = UpdateGroup.class)
	private String buyerId;
	@NotBlank
	private String buyerName;
	@NotBlank
	private String buyerLgu;
	private String buyerBank;
	private String buyerBankno;
	private String buyerBankname;
	private String buyerZip;
	private String buyerAdd1;
	private String buyerAdd2;
	@NotBlank
	private String buyerComtel;
	@NotBlank
	private String buyerFax;
	@NotBlank
	private String buyerMail;
	private String buyerCharger;
	private String buyerTelext;
	
	
	private List<LprodVO> lprodList;
	private LprodVO lprod; //has A 관계(1:1) 중심이 자식이었기 때문에 1ㄷ1 관계 됨
	private List<ProdVO> prodList;//1: N BuyerVO has Many ProdVO
	
	private int cartCount; // Integer가 아닌 int인 이유 오라클에서 NVL로 null을 0으로 바꿨기 때문
}
