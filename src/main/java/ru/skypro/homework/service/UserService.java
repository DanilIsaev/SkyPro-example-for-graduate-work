package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPassword;
import ru.skypro.homework.dto.user.UpdateUser;
import ru.skypro.homework.dto.user.User;


public interface UserService {

    
    void setPassword(NewPassword newPassword);

    
    User getCurrentUser();

    
    UpdateUser updateUser(UpdateUser updateUser);

    
    void updateUserAvatar(MultipartFile image);

    
    boolean hasAccessToChangePassword(String username);
}