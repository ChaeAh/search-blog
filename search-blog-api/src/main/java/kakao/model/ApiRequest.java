package kakao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest<T> {

    private String query;
    private String sort;
    private int page;
    private int size;
    private T data;
}
