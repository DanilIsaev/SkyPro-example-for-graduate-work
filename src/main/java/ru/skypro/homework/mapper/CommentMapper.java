package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.comment.CommentDto;
import ru.skypro.homework.dto.comment.CreateOrUpdateCommentDto;
import ru.skypro.homework.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface CommentMapper {

    /**
     * Преобразование Comment -> CommentDto
     */
    @Mapping(source = "author.id", target = "author")
    @Mapping(source = "author.imagePath", target = "authorImage", qualifiedByName = "pathToImageLink")
    @Mapping(source = "author.firstName", target = "authorFirstName")
    @Mapping(source = "createdAt", target = "createdAt")
    @Mapping(source = "pk", target = "pk")
    CommentDto commentToCommentDto(Comment comment);

    /**
     * Создание Comment из CreateOrUpdateCommentDto
     */
    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "ad", ignore = true)
    Comment createOrUpdateCommentDtoToComment(CreateOrUpdateCommentDto dto);

    /**
     * Обновление Comment из CreateOrUpdateCommentDto
     */
    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "ad", ignore = true)
    void updateCommentFromDto(CreateOrUpdateCommentDto dto, @MappingTarget Comment comment);
}