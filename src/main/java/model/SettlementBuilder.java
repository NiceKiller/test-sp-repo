package model;

import enums.SettlementCategories;

public class SettlementBuilder {
    private String text;
    private SettlementCategories categories;
    private String price;
    private String age;

    public SettlementBuilder setText(String text) {
        this.text = text;
        return this;
    }

    public SettlementBuilder setCategories(SettlementCategories categories) {
        this.categories = categories;
        return this;
    }

    public SettlementBuilder setPrice(String price) {
        this.price = price;
        return this;
    }

    public SettlementBuilder setAge(String age) {
        this.age = age;
        return this;
    }

    public Settlement createSettlement() {
        return new Settlement(text, categories, price, age);
    }
}