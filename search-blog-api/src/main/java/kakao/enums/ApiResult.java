package kakao.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiResult {

    SUCCESS("0000", "API 호출이 정상적으로 완료되었습니다."),
    FAIL("9999", "API 호출이 실패했습니다.");

    private String code;
    private String message;


}
