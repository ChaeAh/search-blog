package com.blog.kakao.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author chaeah.kim
 */

@Getter
@Setter
public class BlogRequest {

    private String query;
    private String sort;
    private int page;
    private int size;

}


