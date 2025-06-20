package ru.skypro.homework.repository;

import ru.skypro.homework.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository<Ad, Integer> {

    /**
     * Находит все объявления конкретного автора
     * @param authorId ID автора объявлений
     * @return список объявлений пользователя
     */
    List<Ad> findAllByAuthorId(Integer authorId);

    /**
     * Находит объявление с загруженными комментариями (жадная загрузка)
     * @param id ID объявления
     * @return Optional с объявлением и комментариями, если найдено
     */
    @Query("SELECT a FROM Ad a LEFT JOIN FETCH a.comments WHERE a.pk = :id")
    Optional<Ad> findByIdWithComments(@Param("id") Integer id);

    /**
     * Ищет объявления по части названия (без учета регистра)
     * @param title часть названия для поиска
     * @return список подходящих объявлений
     */
    @Query("SELECT a FROM Ad a WHERE LOWER(a.title) LIKE LOWER(concat('%', :title, '%'))")
    List<Ad> findByTitleContainingIgnoreCase(@Param("title") String title);
}