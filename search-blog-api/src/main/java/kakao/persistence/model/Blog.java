package kakao.persistence.model;

import kakao.persistence.common.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author chaeah.kim
 */

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_blog")
public class Blog extends BaseEntity {
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "CONTENTS")
    private String contents;
    @Column(name = "URL")
    private String url;
    @Column(name = "BLOG_NM")
    private String blogName;
    @Column(name = "THUMBNAIL")
    private String thumbnail;
    @Column(name = "DATETIME")
    private String datetime;

}


