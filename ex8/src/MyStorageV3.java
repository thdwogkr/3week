import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MyStorageV3 {

    static Map<String, Integer> list = new HashMap<>();
    static final int max_num = 5;

    public static void main(String[] args) {
        System.out.println("[System] 코드스테이츠 점장님 어서오세요.");
        int select = 0;
        Scanner sc = new Scanner(System.in);



        while(select!=6) {

            System.out.println("메뉴출력");
            select = sc.nextInt();

            switch(select) {
                case 1 :
                    prod_input(sc);
                    System.out.println("제품등록");
                    break;
                case 2 :
                    prod_remove(sc);
                    System.out.println("제품제거");
                    break;
                case 3 :
                    prod_amount_add(sc);
                    System.out.println("제품 수량 추가");
                    break;
                case 4 :
                    prod_amount_decrease(sc);
                    System.out.println("제품 수량 감소");
                    break;
                case 5 :
                    prod_search();
                    System.out.println("제품 보여주기");
                    break;
                case 6 :
                    System.out.println("프로그램 종료");
                    break;
                default :
                    System.out.println("경고 메시지");
                    break;
            }



        }





        System.out.println("[System] 프로그램을 종료합니다.");
        System.out.println("[System] 감사합니다.");


    }

    private static void prod_search() {
        show_list();
    }

    private static void prod_amount_decrease(Scanner sc) {
        System.out.println("[System] 제품의 출고를 진행합니다.");
        show_list();
        System.out.println("[System] 출고를 진행할 제품명을 입력하세요 : ");
        String str = sc.next();
        System.out.println("[System] 원하는 출고량을 입력해주세요. : ");
        int i = sc.nextInt();
        list.put(str, list.get(str) - i);
        System.out.println("[Clear] 출고가 완료됐습니다.");
        show_list();
    }

    private static void prod_amount_add(Scanner sc) {
        System.out.println("[System] 물건의 수량을 추가합니다.(입고)");
        show_list();
        System.out.println("[System] 수량을 추가할 제품명을 입력하세요 : ");
        String str = sc.next();
        System.out.println("[System] 추가할 수량을 입력해주세요. : ");
        int i = sc.nextInt();
        list.put(str, list.get(str) + i);
        System.out.println("[Clear] 정상적으로 제품의 수량 추가가 완료됐습니다.");
        show_list();
    }

    private static void prod_remove(Scanner sc) {
        System.out.println("[System] 제품 등록 취소를 원하는 제품명을 입력하세요 : ");
        String item = sc.next();
        list.remove(item);
        System.out.println("제품 등록 취소가 완료됐습니다.");
        show_list();
    }

    private static void prod_input(Scanner sc) {
        System.out.println("[System] 제품 등록을 원하는 제품명을 입력하세요 : ");
        String item = sc.next();
        list.put(item,0);
        System.out.println("[System] 등록이 안료됐습니다.");
        show_list();
    }

    private static void show_list() {
        System.out.println("[System] 현재 등록된 제품 목록");
        for( Map.Entry<String, Integer> e : list.entrySet() ) {
            System.out.printf("> %s : %d개\n", e.getKey(), e.getValue());
        }
        for( int i = 0 ; i < max_num-list.size() ; i++ ) {
            System.out.println("> 등록 가능 : 0개");
        }
    }


}
