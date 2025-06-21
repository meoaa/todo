package v1;

import domain.Todo;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoListV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Todo> store = new ArrayList<>();
        int menu;
        String title;
        int index = 0;

        while(true){
            System.out.println("메뉴를 선택해주세요. \n 1.작성 2.조회 3.변경 4.전체조회 5.삭제 6.종료");
            menu = sc.nextInt();sc.nextLine();

            if(menu == 6){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch(menu){
                case 1 :
                    System.out.println("할 일을 작성합니다.");
                    System.out.print("할 일을 입력해주세요.");
                    title = sc.next();
                    store.add(new Todo(title));
                    System.out.println("할 일이 등록되었습니다.");
                    System.out.println(store.get(index++));
                    break;

                case 2 :
                    System.out.println("할 일을 조회합니다.");
                    if (checkEmptyTodo(store)) break;
                    System.out.print("id를 입력해주세요.");

                    try {
                        int id = sc.nextInt();sc.nextLine();
                        Todo findTodo = store.stream()
                                .filter(todo -> todo.getId() == id)
                                .findFirst()
                                .orElseThrow(TodoListV1::getIllegalArgumentException);
                        System.out.println("findTodo = " + findTodo);
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("할 일의 상태를 변경합니다.");
                    if (checkEmptyTodo(store)) break;
                    System.out.println("id를 입력해주세요.");
                    try {
                        int id = sc.nextInt(); sc.nextLine();
                        Todo findTodo = store.stream()
                                .filter(todo -> todo.getId() == id)
                                .findFirst()
                                .orElseThrow(TodoListV1::getIllegalArgumentException);
                        findTodo.toggleComplete();
                        System.out.println("할 일이 변경되었습니다.");
                        System.out.println("findTodo = " + findTodo);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("할 일을 전체조회합니다.");
                    if (checkEmptyTodo(store)) break;
                    System.out.println("store = " + store);
                    break;

                case 5:
                    System.out.println("할 일을 삭제합니다");
                    if (checkEmptyTodo(store)) break;
                    System.out.println("id를 입력해주세요.");
                    try{
                        int id = sc.nextInt(); sc.nextLine();
                        Todo findTodo = store.stream()
                                .filter(todo -> todo.getId() == id)
                                .findFirst()
                                .orElseThrow(TodoListV1::getIllegalArgumentException);
                        store.remove(findTodo);
                        index--;
                        System.out.println("삭제되었습니다.");
                        System.out.println("store = " + store);
                    } catch (Exception ex){
                        System.out.println(ex.getMessage());
                    }
                    break;

                default :
                    System.out.println("올바르지 않은 메뉴입니다. 다시 입력해주세요.");
            }
        }
    }

    private static IllegalArgumentException getIllegalArgumentException() {
        return new IllegalArgumentException("해당 id와 일치하는 할 일이 존재하지 않습니다.");
    }

    private static boolean checkEmptyTodo(ArrayList<Todo> store) {
        if(store.isEmpty()){
            System.out.println("할 일이 존재하지 않습니다.");
            return true;
        }
        return false;
    }
}
