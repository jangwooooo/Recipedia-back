package javaProject.recipedia.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userId;
    private String userPassword;

}
