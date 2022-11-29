package javaProject.recipedia.service;

import javaProject.recipedia.domain.Favs;
import javaProject.recipedia.repository.FavsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FavsServiceImpl implements FavsService{

    private final FavsRepository favsRepository;

    @Override
    public void addFavs(Long userPk, Long recipePk) {
        Favs favs = Favs.builder()
                .userPk(userPk)
                .recipePk(recipePk)
                .build();
        favsRepository.save(favs);
    }

    @Transactional
    @Override
    public void delFavs(Long userPk, Long recipePk) {
        favsRepository.deleteFavsByUserPkAndRecipePk(userPk, recipePk);
    }

    @Override
    public List<Favs> getFavs(Long userPk) {

        return favsRepository.findAllByUserPk(userPk);
    }
}
