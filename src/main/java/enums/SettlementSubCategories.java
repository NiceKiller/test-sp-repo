package enums;

/**
 * Created by bzawa on 2/15/2017.
 */
public enum SettlementSubCategories {

    //TODO: Add all subcategories
    BIKES("Bikes"), MISCELLANEOUS("Miscellaneous"), BACKPACKS("Backpacks");

    private String value;

    SettlementSubCategories(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
