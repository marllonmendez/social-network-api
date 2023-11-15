package social.network.app.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;

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
