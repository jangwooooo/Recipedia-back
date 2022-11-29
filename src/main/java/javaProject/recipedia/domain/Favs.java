package javaProject.recipedia.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "favs")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userPk;
    private Long recipePk;

}
