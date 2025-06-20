package ru.skypro.homework.repository;

import ru.skypro.homework.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    /**
     * Находит все комментарии для указанного объявления
     * @param adId ID объявления
     * @return список комментариев к объявлению
     */
    List<Comment> findAllByAdPk(Integer adId);

    /**
     * Находит все комментарии указанного пользователя
     * @param authorId ID автора комментариев
     * @return список комментариев пользователя
     */
    List<Comment> findAllByAuthorId(Integer authorId);

    /**
     * Находит комментарий по ID комментария и ID автора
     * (для проверки прав на редактирование/удаление)
     * @param commentId ID комментария
     * @param authorId ID автора
     * @return Optional с комментарием, если найден
     */
    Optional<Comment> findByPkAndAuthorId(Integer commentId, Integer authorId);

    /**
     * Удаляет все комментарии указанного объявления
     * (используется при удалении объявления)
     * @param adId ID объявления
     */
    void deleteAllByAdPk(Integer adId);
}