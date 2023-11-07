package kakao.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author chaeah.kim
 */

@Getter
@Setter
public class BlogRequest extends ApiRequest {
    private String transactionId;

    public String getTransactionId() {
        return UUID.randomUUID().toString();
    }
}


