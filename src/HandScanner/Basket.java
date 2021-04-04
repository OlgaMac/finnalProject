package HandScanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Basket {
    private ArrayList<Article> articles;
    Scanner scanner = new Scanner(System.in);
    ArrayList<Article> availableArticles = readArticle();
    
    public Basket() throws IOException {

        this.articles = new ArrayList<Article>();
    }
    
    public boolean addArticle(Article article){

        return this.articles.add(article);
    }
    
    public boolean deleteArticle(Article article){
         return this.articles.remove(article);
    }
    
    public ArrayList<Article> getArticles() {

        return articles;
    }
    
    public String printInvoice(){
        String text = "";
        int sum = 0;
        
        for(Article article : this.articles){
            text +=  String.format("Cod: %d, Name; %s, Price: %d\n", article.getCod(), article.getName(), article.getPrice());
            sum += article.getPrice();
        }
        text += String.format("Total price of all items: %d", sum);
        return text;
    }
    public void addCoodIntoBasket(){
        boolean added = false;
        int cod = scanner.nextInt();
        if (cod < 0) {
            try {
                throw new Exception("Negative vendor cod entered");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Article article : availableArticles) {
            if (article.getCod() == cod) {
                if (addArticle(article)) {
                    System.out.println("Article added to basket");
                    added = true;
                    break;
                }
            }
        }
        if (!added) {
            System.out.println("Article not found");
        }
    }

    public  void searchForDeleteGoodIntoBasket(){
        boolean isIt = false;
        int cod = scanner.nextInt();
        if (cod < 0) {
            try {
                throw new Exception("Negative vendor cod entered");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (Article article : this.articles) {
            if (article.getCod() == cod) {
                if (deleteArticle(article)) {
                    System.out.println("Article deleted from basket");
                    isIt = true;
                    break;
                }
            }
        }
        if (!isIt) {
            System.out.println("Article not found");
        }
    }
    private static ArrayList<Article> readArticle() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Goods.txt"));
        ArrayList<Article> articles = new ArrayList<>();

        reader.readLine();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] cells = line.split("\\s*,\\s*");
            if (cells.length == 3) {
                articles.add(new Article(Integer.parseInt(cells[0]), cells[1], Integer.parseInt(cells[2])));
            } else {
                System.out.println("Skipping line: " + line);
            }
        }

        reader.close();
        return articles;
    }
    @Override
    public String toString(){
        String text = "";
        for(Article article : this.articles){
            text +=  String.format("Cod: %d, Name; %s, Price: %d\n", article.getCod(), article.getName(), article.getPrice());
        }
        return text;
    }
}
