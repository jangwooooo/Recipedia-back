package javaProject.recipedia.service;

import javaProject.recipedia.domain.Favs;

import java.util.ArrayList;
import java.util.List;

public interface FavsService {
    void addFavs(Long userPk, Long recipePk);
    void delFavs(Long userPk, Long recipePk);
    List<Favs> getFavs(Long userPk);
}
