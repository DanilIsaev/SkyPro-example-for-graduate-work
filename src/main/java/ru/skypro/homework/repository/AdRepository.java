package ru.skypro.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skypro.homework.entity.Ads;

import java.util.ArrayList;


public interface AdRepository extends JpaRepository<Ads, Integer> {

    
    ArrayList<Ads> findAllByAuthor(Long author);
}