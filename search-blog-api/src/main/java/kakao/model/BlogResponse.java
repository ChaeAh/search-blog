package kakao.model;

import kakao.model.blog.Documents;
import kakao.model.blog.Meta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author chaeah.kim
 */

@Getter
@Setter
@NoArgsConstructor
public class BlogResponse {

    private Meta meta;
    private Documents[] documents;

}


