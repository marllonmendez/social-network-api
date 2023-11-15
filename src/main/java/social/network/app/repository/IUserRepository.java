package social.network.app.repository;

import social.network.app.model.UserModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {
    UserModel findByName(String name);
    Optional<UserModel> findById(Integer id);
    List<UserModel> findAll();
}
