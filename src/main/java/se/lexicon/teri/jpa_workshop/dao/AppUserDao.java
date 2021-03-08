package se.lexicon.teri.jpa_workshop.dao;

import org.springframework.beans.factory.ListableBeanFactory;
import se.lexicon.teri.jpa_workshop.entity.AppUser;

import java.util.List;

public interface AppUserDao {

    AppUser create(AppUser appUser);

    AppUser findById(int id);

    List<AppUser> findAll();

    void remove(int id);

    AppUser merge(AppUser appUser);

    List<AppUser> saveAll(List<AppUser> appUsers);
}
