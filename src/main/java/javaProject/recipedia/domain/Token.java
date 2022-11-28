package javaProject.recipedia.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "token")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {

    @Id
    private String token;
    private Long userPk;
}
