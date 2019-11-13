package ba.unsa.etf.rpr;

public class Field {
    public String position;
 public boolean is_free;

 public Field(){

 }

 public Field(String position){
     this.position=position;
 }

    public String getPosition() {
        return this.position;
    }

    public void setIs_free(boolean is_free) {
        this.is_free=is_free;
    }

    public void setPosition(String number){
     this.position=position;
    }

    public boolean isIs_free() {
        return this.is_free;
    }

}
