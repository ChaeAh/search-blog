package kakao.persistence.repository;

import kakao.persistence.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chaeah.kim
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
}


