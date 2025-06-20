package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.user.NewPasswordDTO;
import ru.skypro.homework.dto.user.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Пользователи", description = "API для работы с пользователями")

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/set_password")
    public ResponseEntity<NewPasswordDTO> setPassword(@RequestBody NewPasswordDTO newPasswordDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Your implementation here
        return ResponseEntity.ok(new NewPasswordDTO());
    }

    @GetMapping("/me")
    @Operation(summary = "Получение информации об авторизованном пользователе", operationId = "getUser",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            })
    public ResponseEntity<UserDTO> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Your implementation here
        return ResponseEntity.ok(new UserDTO());
    }

    @PatchMapping("/me")
    @Operation(summary = "Обновление информации об авторизованном пользователе", operationId = "updateUser",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized")
            })
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO updatedUserDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Your implementation here
        return ResponseEntity.ok(updatedUserDTO);
    }

    @PatchMapping("/me/image")
    @Operation(summary = "Обновление аватара авторизованного пользователя", operationId = "updateUserImage",
            responses = {@ApiResponse(responseCode = "200", description = "OK"), @ApiResponse(responseCode = "401", description = "Unauthorized")})
    public ResponseEntity<Void> updateUserImage(@RequestParam("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}