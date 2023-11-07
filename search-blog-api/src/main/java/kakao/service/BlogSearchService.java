package kakao.service;

import kakao.model.BlogRequest;
import kakao.model.BlogResponse;
import kakao.model.blog.Documents;
import kakao.persistence.mapper.BlogHistoryMapper;
import kakao.persistence.mapper.BlogMapper;
import kakao.persistence.model.Blog;
import kakao.persistence.model.BlogHistory;
import kakao.persistence.repository.BlogHistoryRepository;
import kakao.persistence.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaeah.kim
 */
@Service
@RequiredArgsConstructor
public class BlogSearchService {

    private final BlogRepository blogRepository;
    private final BlogHistoryRepository blogHistoryRepository;

    public void saveBlogSearchHistory(BlogRequest request) {
        // 인기 검색어를 알기 위해 저장
        BlogHistory blogHistory = blogHistoryRepository.findByQuery(request.getQuery()).orElse(null);

        if (!ObjectUtils.isEmpty(blogHistory)) {
            blogHistory.setSearchCount(blogHistory.getSearchCount() + 1);
        } else {
            blogHistory = BlogHistoryMapper.INSTANCE.convertDTOtoEntity(request);
            blogHistory.setSearchCount(0);
        }

        blogHistoryRepository.save(blogHistory);
    }

    public void saveBlogSearch(BlogResponse blogResponse) {
        // 일단 저장한다.
        List<Documents> documents = Arrays.stream(blogResponse.getDocuments()).collect(Collectors.toList());

        List<Blog> documentList = BlogMapper.INSTANCE.convertDTOtoEntity(documents);

        documentList.stream().map(blog -> {
            blog.setTransactionId(blogResponse.getTransactionId());
            return blog;
        }).collect(Collectors.toList());

        blogRepository.saveAll(documentList);
    }

}


