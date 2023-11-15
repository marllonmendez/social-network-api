package social.network.app.model;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDate;

@Data
@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;
    private LocalDate birthday;
    private Boolean photo;
}
