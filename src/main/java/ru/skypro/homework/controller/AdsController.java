package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.*;

@RestController
@Tag(name = "Объявления")
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    @GetMapping
    public ResponseEntity<Ads> getAds() {
        return ResponseEntity.ok(new Ads());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Ad> addAd(@RequestPart("properties") CreateOrUpdateAd properties, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new Ad());
    }

    @Operation(operationId = "getAds", summary = "Получить все объявления")
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAd> getAd(@PathVariable Integer id) {
        return ResponseEntity.ok(new ExtendedAd());
    }

    @Operation(operationId = "removeAd", summary = "Удалить объявление")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @Operation(operationId = "updateAds", summary = "Обновить информацию об объявлении")
    @PatchMapping("/{id}")
    public ResponseEntity<Ad> updateAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAd createOrUpdateAd) {
        return ResponseEntity.ok(new Ad());
    }

    @Operation(operationId = "getComments", summary = "Получить комментарии объявления")
    @GetMapping("/{id}/comments")
    public ResponseEntity<Comments> getComments(@PathVariable Integer id) {
        return ResponseEntity.ok(new Comments());
    }

    @Operation(operationId = "addComments", summary = "Добавить комментарий к объявлению")
    @PostMapping("/{id}/comments")
    public ResponseEntity<Comment> addComment(@PathVariable Integer id, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
        return ResponseEntity.status(HttpStatus.OK).body(new Comment());
    }

    @Operation(operationId = "deleteComments", summary = "Удалить комментарий объявления")
    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        return ResponseEntity.noContent().build();
    }

    @Operation(operationId = "updateComments", summary = "Обновить комментарий объявления")
    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Integer adId, @PathVariable Integer commentId, @RequestBody CreateOrUpdateComment createOrUpdateComment) {
        return ResponseEntity.ok(new Comment());
    }

    @GetMapping("/me")
    public ResponseEntity<Ads> getAdsMe() {
        return ResponseEntity.ok(new Ads());
    }

    @Operation(operationId = "updateImage", summary = "Обновить картинку объявления")
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateAdImage(@PathVariable Integer id, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}