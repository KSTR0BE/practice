package kr.or.ddit.vo;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "prodId")
public class ProdVO {
   
   @NotBlank(groups = UpdateGroup.class)
   private String prodId;
   @NotBlank (message = "상품명 누락")
   private String prodName;
   @NotBlank (message = "분류정보 누락")
   private String prodLgu;
   @NotBlank (message = "거래처 누락")
   private String prodBuyer;
   @NotNull (message = "구매가 누락")
   private Integer prodCost;
   @NotNull (message = "판매가 누락")
   private Integer prodPrice;
   @NotNull (message = "세일가 누락")
   private Integer prodSale;
   @NotBlank (message = "요약정보 누락")
   private String prodOutline;
   @ToString.Exclude
   private String prodDetail;
   @NotBlank (message = "상품이미지 누락")
   private String prodImg;
   @NotNull (message = "총재고 누락")
   private Integer prodTotalstock;
   private LocalDate prodInsdate;
   @NotNull (message = "적정재고 누락")
   private Integer prodProperstock;
   private String prodSize;
   private String prodColor;
   private String prodDelivery;
   private String prodUnit;
   private Integer prodQtyin;
   private Integer prodQtysale;
   private Integer prodMileage;
   
   private LprodVO lprod; // 1 : 1  Prod has A lProd
   private BuyerVO buyer; // 1 : 1  Prod has A Buyer
   
   private int cartCount;
}
