package com.blog.kakao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chaeah.kim
 */

@Getter
@Setter
public class BlogResponse {

    private Meta meta;
    private Documents[] documents;

    class Meta {
        private int total_count;
        private int pageable_count;
        private boolean is_end;
    }

    class Documents {
        private String title;
        private String contents;
        private String url;
        private String blogname;
        private String thumbnail;
        private String datetime;
    }
}


