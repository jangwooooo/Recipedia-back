package javaProject.recipedia.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "favorites")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {

    private String recipeId;
    private String userId;
}