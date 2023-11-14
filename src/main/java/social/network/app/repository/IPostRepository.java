package social.network.app.repository;

import social.network.app.model.PostModel;
import social.network.app.repository.IPostRepository;
import social.network.app.utils.NullProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IPostRepository extends JpaRepository< PostModel, Integer> {
    PostModel findByuser_id(String user_id);
    Optional<PostModel> findById(Integer id);
    List<PostModel> findAll();

}