package javaProject.recipedia.service;

import javaProject.recipedia.domain.Token;

import java.util.Optional;

public interface TokenService {
     Long findUserPkByToken(String token);
     String createToken();
     void insertToken(Token token);
     void deleteToken(String token);
}
