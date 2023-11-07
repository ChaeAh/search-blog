package kakao.persistence.repository;

import kakao.persistence.model.BlogHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author chaeah.kim
 */
@Repository
public interface BlogHistoryRepository extends JpaRepository<BlogHistory, Long>, BlogHistoryCustomRepository {

    Optional<BlogHistory> findByQuery(String query);
}


