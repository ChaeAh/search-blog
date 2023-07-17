package kakao.model.blog;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Meta {

    @JsonProperty("total_count")
    private int totalCount;
    
    @JsonProperty("pageable_count")
    private int pageCount;

    @JsonProperty("_end")
    private boolean isEnd;
}
