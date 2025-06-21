package v3.dto;

public class TodoCreateRequestDto {
    private String title;

    public TodoCreateRequestDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
