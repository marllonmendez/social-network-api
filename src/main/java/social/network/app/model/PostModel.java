package social.network.app.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
