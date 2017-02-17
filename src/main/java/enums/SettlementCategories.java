package enums;

/**
 * Created by bzawa on 2/15/2017.
 */
public enum SettlementCategories {

    //TODO: add all values from categories select
    BAGS_BACKPACKS("Bags & Purses", SettlementSubCategories.BACKPACKS),
    BIKES_BIKES("Bikes & Accessories", SettlementSubCategories.BIKES),
    CARS("Cars, Boats & MC", null);

    private String value;
    private SettlementSubCategories subCategories;

    SettlementCategories(String value, SettlementSubCategories subCategories ){
        this.value = value;
        this.subCategories = subCategories;
    }

    public String getValue(){
        return value;
    }

    public SettlementSubCategories getSubCategories() {
        return subCategories;
    }
}
