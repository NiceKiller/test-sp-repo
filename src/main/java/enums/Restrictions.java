package enums;

/**
 * Created by bzawa on 1/16/2017.
 */

    public enum Restrictions{
        NONE("No restrictions"), EDIT("Editing restricted"), VIEWEDIT("Viewing and editing restricted");

        private String value;

        Restrictions(String value){
            this.value = value;
        }

        public String getValue(){
            return this.value;
        }
    }

