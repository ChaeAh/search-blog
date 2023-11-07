package kakao.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Objects;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest<T> {

    private String query;
    private SortType sortType;
    private int page = 1;
    private int size = 10;
    private T data;

    @Getter
    public enum SortType {
        ACCURACY("정확도순"),
        RECENCY("최신순");

        private String sortName;

        SortType(String sortName) {
            this.sortName = sortName;
        }
    }

    public String getSortType() {
        return Arrays.stream(SortType.values())
                .filter(x-> this.sortType != null && Objects.equals(x.name(), sortType.name()))
                .map(x-> x.name().toLowerCase())
                .findFirst()
                .orElse(SortType.ACCURACY.name());
        }
}
