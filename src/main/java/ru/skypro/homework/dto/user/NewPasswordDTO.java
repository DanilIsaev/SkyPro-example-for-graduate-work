
package ru.skypro.homework.dto.user;

import lombok.Data;

@Data
public class NewPasswordDTO {
    private String currentPassword;
    private String newPassword;
}