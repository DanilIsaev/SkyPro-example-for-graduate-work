package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.ad.AdDTO;
import ru.skypro.homework.dto.ad.AdsDTO;
import ru.skypro.homework.dto.ad.CreateOrUpdateAdDTO;
import ru.skypro.homework.dto.ad.ExtendedAdDTO;
import ru.skypro.homework.dto.comment.CommentDTO;
import ru.skypro.homework.dto.comment.CommentsDTO;
import ru.skypro.homework.dto.comment.CreateOrUpdateCommentDTO;

@RestController
@Tag(name = "Объявления")
@RequestMapping("/ads")
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {

    @GetMapping
    public ResponseEntity<AdsDTO> getAds() {
        return ResponseEntity.ok(new AdsDTO());
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdDTO> addAd(@RequestPart("properties") CreateOrUpdateAdDTO properties, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdDTO());
    }

    @Operation(operationId = "getAds", summary = "Получить все объявления")
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDTO> getAd(@PathVariable Integer id) {
        return ResponseEntity.ok(new ExtendedAdDTO());
    }

    @Operation(operationId = "removeAd", summary = "Удалить объявление")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeAd(@PathVariable Integer id) {
        return ResponseEntity.noContent().build();
    }

    @Operation(operationId = "updateAds", summary = "Обновить информацию об объявлении")
    @PatchMapping("/{id}")
    public ResponseEntity<AdDTO> updateAd(@PathVariable Integer id, @RequestBody CreateOrUpdateAdDTO createOrUpdateAdDTO) {
        return ResponseEntity.ok(new AdDTO());
    }

    @Operation(operationId = "getComments", summary = "Получить комментарии объявления")
    @GetMapping("/{id}/comments")
    public ResponseEntity<CommentsDTO> getComments(@PathVariable Integer id) {
        return ResponseEntity.ok(new CommentsDTO());
    }

    @Operation(operationId = "addComments", summary = "Добавить комментарий к объявлению")
    @PostMapping("/{id}/comments")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Integer id, @RequestBody CreateOrUpdateCommentDTO createOrUpdateCommentDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(new CommentDTO());
    }

    @Operation(operationId = "deleteComments", summary = "Удалить комментарий объявления")
    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        return ResponseEntity.noContent().build();
    }

    @Operation(operationId = "updateComments", summary = "Обновить комментарий объявления")
    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<CommentDTO> updateComment(@PathVariable Integer adId, @PathVariable Integer commentId, @RequestBody CreateOrUpdateCommentDTO createOrUpdateCommentDTO) {
        return ResponseEntity.ok(new CommentDTO());
    }

    @GetMapping("/me")
    public ResponseEntity<AdsDTO> getAdsMe() {
        return ResponseEntity.ok(new AdsDTO());
    }

    @Operation(operationId = "updateImage", summary = "Обновить картинку объявления")
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateAdImage(@PathVariable Integer id, @RequestPart("image") MultipartFile image) {
        return ResponseEntity.ok().build();
    }
}