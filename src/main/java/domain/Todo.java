package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Todo {
    private static long sequence = 0;
    private long id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Todo(String title) {
        id = ++sequence;
        this.title = title;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedUpdatedAt = updatedAt != null ? updatedAt.format(formatter) : null;

        return "Todo \n" +
                "id : " + id +
                ", 할 일 : '" + title + '\'' +
                ", 완료여부 : " + (completed ? "완료" : "미완료" ) +
                ", 생성일자 : " + createdAt.format(formatter) +
                ", 수정일자 : " + formattedUpdatedAt +"\n" ;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void toggleComplete() {
        this.completed = !completed;
        this.updatedAt = LocalDateTime.now();
    }
}
