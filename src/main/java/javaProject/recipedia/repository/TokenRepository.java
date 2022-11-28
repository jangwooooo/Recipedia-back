package javaProject.recipedia.repository;

import javaProject.recipedia.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, String> {
}
