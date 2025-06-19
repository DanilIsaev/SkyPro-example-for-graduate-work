
package ru.skypro.homework.dto;

import java.util.List;
import java.util.Objects;

public class Comments {

    private Integer count;
    private List<Comment> results;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Comment> getResults() {
        return results;
    }

    public void setResults(List<Comment> results) {
        this.results = results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return Objects.equals(count, comments.count) && Objects.equals(results, comments.results);
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
