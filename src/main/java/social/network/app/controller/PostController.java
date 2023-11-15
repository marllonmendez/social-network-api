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
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostRepository postRepository;

    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/")
    public ResponseEntity create(@RequestBody PostModel postModel) {
        // Verificações e validações necessárias

        // Obtém o usuário pelo ID do JSON
        UserModel user = userRepository.findById(postModel.getUser().getId()).orElse(null);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        // Cria a instância de PostModel apenas com texto e usuário
        postModel.setUser(user);


        // Salva a postagem no repositório
        var postCreated = this.postRepository.save(postModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(postCreated);
    }




    @GetMapping("/{id}")
    public ResponseEntity getPostById(@PathVariable Integer id) {
        var post = this.postRepository.findById(id);

        if (post.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(post.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Postagem não encontrada");
        }
    }

    @GetMapping("/all")
    public List<PostModel> listAll() {
        return postRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody PostModel postModel) {
        var post = this.postRepository.findById(id).orElse(null);

        if (post != null) {
            try {
                postModel.setId(post.getId());
                NullProperties.copyNotNullProperties(postModel, post);
                var postUpdated = this.postRepository.save(post);
                return ResponseEntity.ok().body(postUpdated);
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar postagem: " + e.getMessage());
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Postagem não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        var post = this.postRepository.findById(id);

        if (post.isPresent()) {
            this.postRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Postagem deletada com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Postagem não encontrada");
        }
    }
}
