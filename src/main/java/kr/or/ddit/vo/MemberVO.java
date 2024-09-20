package kr.or.ddit.vo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.groups.DeleteGroup;
import kr.or.ddit.validate.groups.InsertGroup;
import kr.or.ddit.validate.groups.UpdateGroup;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 인증 및 회원관리를 위한 Domain layer
 *
 */
@Getter //겟터
@Setter //셋터
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"}) //투스트링
@EqualsAndHashCode(of = {"memId"}) //비교 이퀄 해쉬코드
@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 프로퍼티를 받을 수 있는 생성자
public class MemberVO implements Serializable{
	
	public MemberVO(String memId, String memPass) {
		super();
		this.memId = memId;
		this.memPass = memPass;
	}
	
	@NotBlank(groups = {DeleteGroup.class, Default.class}, message = "회원아이디 누락")
	private String memId;
	@NotBlank
//	@Size(min = 4 , max = 8, groups = {DeleteGroup.class, Default.class})
	@NotBlank(groups = {DeleteGroup.class, Default.class}, message = "비밀번호 누락")
	@Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\\$%^&]).{4,8}", groups = {DeleteGroup.class, Default.class}, message = "비밀번호 형식 확인")
	@JsonIgnore
	private transient String memPass;
	@NotBlank(message = "이름 누락")
	@Size(max = 20, message = "이름의 길이는 20글자 제한")
	private String memName;
//	@NotBlank(groups = InsertGroup.class)
	@JsonIgnore
	private transient String memRegno1;
//	@NotBlank(groups = InsertGroup.class)
	@JsonIgnore
	private transient String memRegno2;
//	@NotNull(groups = UpdateGroup.class)
	private LocalDate memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	@Pattern(regexp = "\\d{3}-\\d{3,4}-\\d{4}")
	private String memHometel;
	private String memComtel;
	private String memHp;
	@Email
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private LocalDate memMemorialday;
	private Integer memMileage;
	private boolean memDelete;
	private String memRole;
	
	private List<VcartVO>cartList; // 1 : N 구매내역 has Many
	
}

