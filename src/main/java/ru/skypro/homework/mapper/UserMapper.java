package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.auth.RegisterDto;
import ru.skypro.homework.dto.user.UserDto;
import ru.skypro.homework.dto.user.UpdateUserDto;
import ru.skypro.homework.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    /**
     * Преобразование User -> UserDto
     */
    @Mapping(source = "imagePath", target = "image", qualifiedByName = "pathToImageLink")
    UserDto userToUserDto(User user);

    /**
     * Преобразование RegisterDto -> User
     */
    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "role", defaultValue = "USER")
    User registerDtoToUser(RegisterDto registerDto);

    /**
     * Обновление User из UpdateUserDto
     */
    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateUserFromDto(UpdateUserDto dto, @MappingTarget User user);

    @Named("pathToImageLink")
    default String pathToImageLink(String path) {
        return path != null ? "/users/image/" + path : null;
    }
}