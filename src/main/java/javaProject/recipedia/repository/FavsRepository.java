package javaProject.recipedia.repository;

import javaProject.recipedia.domain.Favs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;

public interface FavsRepository extends JpaRepository<Favs, Long> {
    void deleteFavsByUserPkAndRecipePk(Long userPk, Long recipePk);
    List<Favs> findAllByUserPk(Long userPk);
}
