package kakao.persistence.listener;

import kakao.persistence.common.BaseTimeEntity;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author chaeah.kim
 */

public class BaseEntityListener {

    @PrePersist
    public void onPrePersist(Object o) {    //persist(insert) 메서드 호출 전 실행
        if( o instanceof BaseTimeEntity) {
            ((BaseTimeEntity) o).setCreatedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            ((BaseTimeEntity) o).setModifiedDate(((BaseTimeEntity) o).getCreatedDate());
        }
    }

    @PreUpdate
    public void onPreUpdate(Object o) {     //merge(update) 메서드 호출 전 실행
        if( o instanceof  BaseTimeEntity) {
            ((BaseTimeEntity) o).setModifiedDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        }
    }

}


