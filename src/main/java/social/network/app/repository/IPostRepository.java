package social.network.app.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import social.network.app.model.PostModel;

import java.util.List;

public interface IPostRepository extends JpaRepository<PostModel, Integer> {
    @Transactional
    void deleteByUserId(Integer userId);
}
