package member.model.dto;
/**
 * enum
 *  - 상수에 대해 namespace를 제공.
 *  - 기존 public static final로 선언한 상수 대비 안정적으로 사용 가능.
 *  - U : 기본 user
 *  - A : 관리자 admin
 */
public enum MemberRole {
	U, A;
}
