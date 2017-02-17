package model;

import enums.SettlementCategories;

/**
 * Created by bzawa on 2/15/2017.
 */
public class Settlement {

    private String text;
    private SettlementCategories categories;
    private String price;
    private String age;

    public Settlement(String text, SettlementCategories categories, String price, String age) {
        this.text = text;
        this.categories = categories;
        this.price = price;
        this.age = age;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SettlementCategories getCategories() {
        return categories;
    }

    public void setCategories(SettlementCategories categories) {
        this.categories = categories;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
