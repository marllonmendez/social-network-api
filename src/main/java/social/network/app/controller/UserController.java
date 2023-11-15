package social.network.app.controller;

import social.network.app.model.PostModel;
import social.network.app.model.UserModel;
import social.network.app.repository.IPostRepository;
import social.network.app.repository.IUserRepository;
import social.network.app.utils.NullProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IPostRepository postRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByName(userModel.getName());

        if (user != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário existente");
        }

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity list(@PathVariable Integer id) {
        var user = this.userRepository.findById(id);

        if (user.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }
    }

    @GetMapping("/all")
    public List<UserModel> listAll() {
        return userRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody UserModel userModel) {
        var user = this.userRepository.findById(id).orElse(null);

        if (user != null) {
            try {
                userModel.setId(user.getId());
                NullProperties.copyNotNullProperties(userModel, user);
                var userUpdated = this.userRepository.save(user);
                return ResponseEntity.ok().body(userUpdated);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar usuário: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        var user = this.userRepository.findById(id);

        if (user.isPresent()) {
            this.postRepository.deleteByUserId(id);
            this.userRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário não encontrado");
        }
    }
}
