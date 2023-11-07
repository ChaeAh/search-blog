package kakao.persistence.mapper;

import kakao.model.blog.Documents;
import kakao.persistence.common.BaseMapper;
import kakao.persistence.model.Blog;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author chaeah.kim
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BlogMapper extends BaseMapper<Documents, Blog> {
    BlogMapper INSTANCE = Mappers.getMapper(BlogMapper.class);
}


