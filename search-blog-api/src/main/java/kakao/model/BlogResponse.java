package kakao.model;

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

    @Getter @Setter
    public static class Meta {
        private int total_count;
        private int pageable_count;
        private boolean is_end;
    }

    @Getter @Setter
    public static class Documents {
        private String title;
        private String contents;
        private String url;
        private String blogname;
        private String thumbnail;
        private String datetime;
    }
}


