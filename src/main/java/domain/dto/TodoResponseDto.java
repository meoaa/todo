package domain.dto;

import domain.Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TodoResponseDto {
    private long id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TodoResponseDto(long id, String title, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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


    public static TodoResponseDto of(Todo todo){
        return new TodoResponseDto(todo.getId(), todo.getTitle(), todo.isCompleted(), todo.getCreatedAt(), todo.getUpdatedAt());
    }
}
