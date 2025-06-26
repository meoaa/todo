package v4;


import domain.dto.TodoCreateRequestDto;
import domain.dto.TodoResponseDto;
import v4.config.TodoConfig;
import v4.service.TodoService;

import java.util.List;
import java.util.Scanner;

public class TodoList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TodoConfig todoConfig = new TodoConfig();
        TodoService todoService = todoConfig.todoService();

        int menu;

        while(true){
            print("메뉴를 선택해주세요. \n 1.작성 2.조회 3.변경 4.전체조회 5.삭제 6.종료");
            menu = sc.nextInt();sc.nextLine();

            if(menu == 6){
                print("프로그램을 종료합니다.");
                break;
            }

            switch(menu){
                case 1 :
                    print("할 일을 작성합니다.");
                    System.out.print("할 일을 입력해주세요.");
                    String title = sc.next();
                    try{
                        TodoResponseDto responseDto = todoService.createTodo(new TodoCreateRequestDto(title));
                        print("할 일이 등록되었습니다.");
                        print(responseDto);
                    } catch (Exception ex) {
                        print(ex.getMessage());
                    }
                    break;

                case 2 :
                    print("할 일을 조회합니다.");
                    System.out.print("id를 입력해주세요.");
                    try {
                        int id = sc.nextInt();sc.nextLine();
                        TodoResponseDto responseDto = todoService.findOneTodo(id);
                        print(responseDto);
                    } catch (Exception ex) {
                        print(ex.getMessage());
                    }
                    break;

                case 3:
                    print("할 일의 상태를 변경합니다.");
                    print("id를 입력해주세요.");
                    try {
                        int id = sc.nextInt(); sc.nextLine();
                        TodoResponseDto responseDto = todoService.updatedCompleted(id);
                        print("할 일이 변경되었습니다.");
                        print(responseDto);
                    } catch (Exception ex){
                        print(ex.getMessage());
                    }
                    break;

                case 4:
                    print("할 일을 전체조회합니다.");
                    try{
                        List<TodoResponseDto> responseDtos = todoService.findAllTodo();
                        print(responseDtos);
                    } catch (Exception ex){
                        print(ex.getMessage());
                    }
                    break;

                case 5:
                    print("할 일을 삭제합니다");
                    print("id를 입력해주세요.");
                    try{
                        int id = sc.nextInt(); sc.nextLine();
                        print("정말 삭제하시겠습니까? (y/n)");
                        String confirm = sc.nextLine();

                        if(confirm.equalsIgnoreCase("y")){
                            long deletedTodoId = todoService.deleteTodo(id);
                            print("삭제되었습니다. id :" + deletedTodoId);
                        } else {
                            print("삭제가 취소되었습니다.");
                        }

                    } catch (Exception ex){
                        print(ex.getMessage());
                    }
                    break;

                default :
                    print("올바르지 않은 메뉴입니다. 다시 입력해주세요.");
            }
        }
    }

    private static void print(String string) {
        System.out.println(string);
    }

    private static void print(Object object) {
        System.out.println(object);
    }
}
