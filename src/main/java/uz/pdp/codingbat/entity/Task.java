package uz.pdp.codingbat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private Category category;
    @Column(nullable = false)
    private String question;
    @Column(nullable = false)
    private String template;
    @Column(nullable = false)
    private String answerText;
    @Column(nullable = false)
    private String solution;

    @ManyToOne
    private User user;
}
