package HandScanner;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Basket basket = new Basket();
        int choice;
        do {
            System.out.println("#########################");
            System.out.println("Choose an action:");
            System.out.println("(1) list basket items");
            System.out.println("(2) add item to basket");
            System.out.println("(3) delete itm from basket");
            System.out.println("(4) print invoice");
            System.out.println("(0) exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (basket.getArticles().size() != 0) {
                        System.out.println(basket);
                    } else {
                        System.out.println("Basket is empty");
                    }
                    break;

                case 2:
                    System.out.print("Enter the vendor cod of article: ");
                    basket.addCoodIntoBasket();
                    break;

                case 3:
                    System.out.println(basket);
                    System.out.print("Enter the vendor cod of article to delete: ");
                    basket.searchForDeleteGoodIntoBasket();
                    break;

                case 4:
                    System.out.println(basket.printInvoice());
                    break;
                default:
                    System.out.println("Вы не выбрали не один пункт меню");
            }
        } while (choice != 0);
    }
}


