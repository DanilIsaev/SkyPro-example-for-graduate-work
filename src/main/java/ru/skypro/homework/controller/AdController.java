package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.*;

@RestController
@RequestMapping("/ads")
@Tag(name = "Объявления", description = "API для работы с объявлениями")
public class AdController {

    @GetMapping
    @Operation(summary = "Получение всех объявлений")
    public ResponseEntity<AdsDto> getAllAds() {
        return ResponseEntity.ok(new AdsDto());
    }

    @PostMapping
    @Operation(summary = "Добавление объявления")
    public ResponseEntity<AdDto> addAd(
            @RequestPart("properties") CreateOrUpdateAdDto properties,
            @RequestPart("image") MultipartFile image) {
        return ResponseEntity.status(201).body(new AdDto());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение информации об объявлении")
    public ResponseEntity<ExtendedAdDto> getAd(
            @Parameter(description = "ID объявления") @PathVariable Integer id) {
        return ResponseEntity.ok(new ExtendedAdDto());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление объявления")
    public ResponseEntity<?> removeAd(
            @Parameter(description = "ID объявления") @PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление информации об объявлении")
    public ResponseEntity<AdDto> updateAd(
            @Parameter(description = "ID объявления") @PathVariable Integer id,
            @RequestBody CreateOrUpdateAdDto updateAdDto) {
        return ResponseEntity.ok(new AdDto());
    }

    @GetMapping("/me")
    @Operation(summary = "Получение объявлений авторизованного пользователя")
    public ResponseEntity<AdsDto> getAdsMe() {
        return ResponseEntity.ok(new AdsDto());
    }

    @PatchMapping("/{id}/image")
    @Operation(summary = "Обновление картинки объявления")
    public ResponseEntity<?> updateAdImage(
            @Parameter(description = "ID объявления") @PathVariable Integer id,
            @RequestParam("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}