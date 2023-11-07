package kakao.persistence.mapper;

import kakao.model.BlogRequest;
import kakao.model.blog.Documents;
import kakao.persistence.common.BaseMapper;
import kakao.persistence.model.Blog;
import kakao.persistence.model.BlogHistory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author chaeah.kim
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogHistoryMapper extends BaseMapper<BlogRequest, BlogHistory> {
    BlogHistoryMapper INSTANCE = Mappers.getMapper(BlogHistoryMapper.class);
}


