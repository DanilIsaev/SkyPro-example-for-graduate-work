package ru.skypro.homework.mapper;

import ru.skypro.homework.dto.ad.AdDto;
import ru.skypro.homework.dto.ad.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ad.ExtendedAdDto;
import ru.skypro.homework.model.Ad;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface AdMapper {

    /**
     * Преобразование Ad -> AdDto (для списка объявлений)
     */
    @Mapping(source = "author.id", target = "author")
    @Mapping(source = "imagePath", target = "image", qualifiedByName = "pathToImageLink")
    @Mapping(source = "pk", target = "pk")
    AdDto adToAdDto(Ad ad);

    /**
     * Преобразование Ad -> ExtendedAdDto (для полного просмотра)
     */
    @Mapping(source = "author.firstName", target = "authorFirstName")
    @Mapping(source = "author.lastName", target = "authorLastName")
    @Mapping(source = "author.email", target = "email")
    @Mapping(source = "author.phone", target = "phone")
    @Mapping(source = "imagePath", target = "image", qualifiedByName = "pathToImageLink")
    @Mapping(source = "pk", target = "pk")
    ExtendedAdDto adToExtendedAdDto(Ad ad);

    /**
     * Создание Ad из CreateOrUpdateAdDto
     */
    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "comments", ignore = true)
    Ad createOrUpdateAdDtoToAd(CreateOrUpdateAdDto dto);

    /**
     * Обновление Ad из CreateOrUpdateAdDto
     */
    @Mapping(target = "pk", ignore = true)
    @Mapping(target = "author", ignore = true)
    @Mapping(target = "imagePath", ignore = true)
    @Mapping(target = "comments", ignore = true)
    void updateAdFromDto(CreateOrUpdateAdDto dto, @MappingTarget Ad ad);

    @Named("pathToImageLink")
    default String pathToImageLink(String path) {
        return path != null ? "/ads/image/" + path : null;
    }
}