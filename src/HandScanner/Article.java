package HandScanner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Article {
    private int cod;
    private String name;
    private int price;

    public Article(int cod, String name, int price) {
        this.cod = cod;
        this.name = name;
        this.price = price;
    }

    public int getCod() {

        return cod;
    }

    public void setCod(int cod) {

        this.cod = cod;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }
    
}
