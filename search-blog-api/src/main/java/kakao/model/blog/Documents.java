package kakao.model.blog;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Documents {
    private String title;
    private String contents;
    private String url;

    @JsonProperty("blogname")
    private String blogName;
    private String thumbnail;
    private String datetime;
}
