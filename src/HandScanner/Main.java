package HandScanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Article> availableArticles = readArticle();
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
                    addCoodIntoBasket(scanner, availableArticles, basket);
                    break;

                case 3:
                    System.out.println(basket);
                    System.out.print("Enter the vendor cod of article to delete: ");
                    searchForDeleteGoodIntoBasket(scanner, availableArticles, basket);
                    break;

                case 4:
                    System.out.println(basket.printInvoice());
                    break;
                default:
                    System.out.println("Вы не выбрали ни один пункт меню");
            }
        } while (choice != 0);
    }

    private static void searchForDeleteGoodIntoBasket(Scanner scanner, HashMap<Integer, Article> availableArticles, Basket basket) {
        Integer cod;
        cod = scanner.nextInt();
        if (cod < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Negative vendor cod entered");
            }
        }
        if (availableArticles.containsKey(cod)) {
            basket.deleteArticle(cod);
            System.out.println("Article deleted from basket");
        } else {
            System.out.println("Article not found");
        }
    }


    private static void addCoodIntoBasket(Scanner scanner, HashMap<Integer, Article> availableArticles, Basket basket) {
        Integer cod = scanner.nextInt();
        if (cod < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Negative vendor cod entered");
            }
        }
        if (availableArticles.containsKey(cod)) {
            basket.addArticle(cod, new Article(availableArticles.get(cod).getName(), availableArticles.get(cod).getPrice()));
            System.out.println("Article added to basket");

        } else {
            System.out.println("Article not found");
        }
    }


    private static HashMap<Integer, Article> readArticle() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Goods.txt"));
        HashMap<Integer, Article> articles = new HashMap();

        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] cells = line.split("\\s*,\\s*");
            if (cells.length == 3) {
                Integer key = Integer.parseInt(cells[0]);
                Article coods = new Article(cells[1], Integer.parseInt(cells[2]));
                articles.put(key, coods);
            } else {
                System.out.println("Skipping line: " + line);
            }
        }

        reader.close();
        return articles;
    }
}

