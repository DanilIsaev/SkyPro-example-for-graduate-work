
package ru.skypro.homework.dto.comment;

import java.util.List;
import java.util.Objects;

public class CommentsDTO {

    private Integer count;
    private List<CommentDTO> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<CommentDTO> getResults() {
        return results;
    }

    public void setResults(List<CommentDTO> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentsDTO commentsDTO = (CommentsDTO) o;
        return Objects.equals(count, commentsDTO.count) && Objects.equals(results, commentsDTO.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, results);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "count=" + count +
                ", results=" + results +
                '}';
    }
}
