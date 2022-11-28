package javaProject.recipedia.service;

import javaProject.recipedia.domain.Token;
import javaProject.recipedia.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService{

    private final TokenRepository tokenRepository;

    @Override
    public Long findUserPkByToken(String token) {
        return tokenRepository.findById(token).get().getUserPk();
    }

    @Override
    public String createToken() {
        Random random = new Random();
        return random.ints(48, 123)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(10)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    @Override
    public void insertToken(Token token) {
        Token token1 = Token.builder()
                .token(token.getToken())
                .userPk(token.getUserPk())
                .build();
        tokenRepository.save(token1);
    }
}
