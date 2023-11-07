package kakao.persistence.common;

import kakao.persistence.listener.BaseEntityListener;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author chaeah.kim
 */

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class, BaseEntityListener.class})
@Getter @Setter
public class BaseTimeEntity extends BaseEntity {

    @CreatedDate
    @Column(name = "CREATED_DATE", nullable = false, updatable = false)
    private String createdDate;

    @LastModifiedDate
    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;

}


