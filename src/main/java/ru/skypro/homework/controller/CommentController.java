package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.comment.*;

@RestController
@RequestMapping("/ads/{adId}/comments")
@Tag(name = "Комментарии", description = "API для работы с комментариями")
public class CommentController {

    @GetMapping
    @Operation(summary = "Получение комментариев объявления")
    public ResponseEntity<CommentsDto> getComments(
            @Parameter(description = "ID объявления") @PathVariable Integer adId) {
        return ResponseEntity.ok(new CommentsDto());
    }

    @PostMapping
    @Operation(summary = "Добавление комментария к объявлению")
    public ResponseEntity<CommentDto> addComment(
            @Parameter(description = "ID объявления") @PathVariable Integer adId,
            @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return ResponseEntity.ok(new CommentDto());
    }

    @DeleteMapping("/{commentId}")
    @Operation(summary = "Удаление комментария")
    public ResponseEntity<?> deleteComment(
            @Parameter(description = "ID объявления") @PathVariable Integer adId,
            @Parameter(description = "ID комментария") @PathVariable Integer commentId) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{commentId}")
    @Operation(summary = "Обновление комментария")
    public ResponseEntity<CommentDto> updateComment(
            @Parameter(description = "ID объявления") @PathVariable Integer adId,
            @Parameter(description = "ID комментария") @PathVariable Integer commentId,
            @RequestBody CreateOrUpdateCommentDto createOrUpdateCommentDto) {
        return ResponseEntity.ok(new CommentDto());
    }
}