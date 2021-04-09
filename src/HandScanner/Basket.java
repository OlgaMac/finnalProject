package HandScanner;

import java.util.HashMap;


public class Basket {

    private HashMap<Integer, Article> articles;

    public Basket() {
        this.articles = new HashMap<Integer, Article>();
    }


    public HashMap<Integer, Article> getArticles() {
        return articles;
    }

    public void setArticles(HashMap<Integer, Article> articles) {
        this.articles = articles;
    }

    public void addArticle(Integer cod, Article article) {
        this.articles.put(cod, article);
    }

    public void deleteArticle(Integer cod) {
        this.articles.remove(cod);
    }

    public String printInvoice() {
        String text = "";
        int sum = 0;

        for (HashMap.Entry<Integer, Article> e : articles.entrySet()) {
            text += String.format(" Name: %s, Price: %d\n", e.getValue().getName(), e.getValue().getPrice());
            sum += e.getValue().getPrice();
        }
        text += String.format("Total price of all items: %d", sum);
        return text;
    }

    @Override
    public String toString() {
        String text = "";
        for (HashMap.Entry<Integer, Article> e : articles.entrySet()) {
            text += String.format(" Name: %s, Price: %d\n", e.getValue().getName(), e.getValue().getPrice());
        }
        return text;
    }
}
