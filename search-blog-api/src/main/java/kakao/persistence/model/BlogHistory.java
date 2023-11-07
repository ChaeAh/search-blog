package kakao.persistence.model;

import kakao.persistence.common.BaseTimeEntity;
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
@Table(name = "tbl_blog_history")
public class BlogHistory extends BaseTimeEntity {

    @Column(name = "QUERY")
    private String query;
    @Column(name = "SEARCH_COUNT", columnDefinition = "int default 0")
    private Integer searchCount;

    @Column(name = "TRANSACTION_ID")
    private String transactionId;

}


