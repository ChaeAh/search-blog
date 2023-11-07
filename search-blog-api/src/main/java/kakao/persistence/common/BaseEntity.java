package kakao.persistence.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chaeah.kim
 */
@MappedSuperclass
@Getter
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    @Column(name="IS_DEL", length = 1, columnDefinition = "boolean default false")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Boolean deleteFg = false;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isNew() {
        return getId() == null || getId() < 1;
    }
}


