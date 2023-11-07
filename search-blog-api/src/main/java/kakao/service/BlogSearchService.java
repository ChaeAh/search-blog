package kakao.service;

import kakao.model.BlogResponse;
import kakao.model.blog.Documents;
import kakao.persistence.mapper.BlogMapper;
import kakao.persistence.model.Blog;
import kakao.persistence.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chaeah.kim
 */
@Service
@RequiredArgsConstructor
public class BlogSearchService {

    private final BlogRepository repository;

//    public BlogSearchService(BlogRepository repository) {
//        super(repository);
//        this.repository = repository;
//    }

    public void saveBlogSearchHistory(BlogResponse blogResponse) {
        LocalDateTime now = LocalDateTime.now();
        List<Documents> documents = Arrays.stream(blogResponse.getDocuments()).collect(Collectors.toList())
                .stream()
                .collect(Collectors.toList());

        List<Blog> documentList = BlogMapper.INSTANCE.convertDTOtoEntity(documents);

        repository.saveAll(documentList);


    }
}


