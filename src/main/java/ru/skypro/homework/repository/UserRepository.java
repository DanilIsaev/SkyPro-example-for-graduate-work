package ru.skypro.homework.repository;

import ru.skypro.homework.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * Находит пользователя по email (логину)
     * @param email email пользователя
     * @return Optional с пользователем, если найден
     */
    Optional<User> findByEmail(String email);

    /**
     * Проверяет существование пользователя с указанным email
     * @param email email для проверки
     * @return true если пользователь существует, false если нет
     */
    boolean existsByEmail(String email);

    /**
     * Находит пользователя по ID и роли (для проверки прав доступа)
     * @param id ID пользователя
     * @param role роль пользователя (USER/ADMIN)
     * @return Optional с пользователем, если найден
     */
    Optional<User> findByIdAndRole(Integer id, String role);
}