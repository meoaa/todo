package v2;

import domain.Todo;

import java.util.List;
import java.util.Scanner;

public class TodoListV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final TodoService todoService = new TodoService();
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
                        Todo savedTodo = todoService.createTodo(title);
                        print("할 일이 등록되었습니다.");
                        print(savedTodo);
                    } catch (Exception ex) {
                        print(ex.getMessage());
                    }
                    break;

                case 2 :
                    print("할 일을 조회합니다.");
                    System.out.print("id를 입력해주세요.");
                    try {
                        int id = sc.nextInt();sc.nextLine();
                        Todo findTodo = todoService.findOneTodo(id);
                        print(findTodo);
                    } catch (Exception ex) {
                        print(ex.getMessage());
                    }
                    break;

                case 3:
                    print("할 일의 상태를 변경합니다.");
                    print("id를 입력해주세요.");
                    try {
                        int id = sc.nextInt(); sc.nextLine();
                        Todo updatedTodo = todoService.updatedCompleted(id);
                        print("할 일이 변경되었습니다.");
                        print(updatedTodo);
                    } catch (Exception ex){
                        print(ex.getMessage());
                    }
                    break;

                case 4:
                    print("할 일을 전체조회합니다.");
                    try{
                        List<Todo> allTodo = todoService.findAllTodo();
                        print(allTodo);
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
