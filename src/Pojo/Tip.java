package Pojo;

public class Tip {
    private  int id;
    private  String tstring;

    @Override
    public String toString() {
        return id+"   "+tstring ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTstring() {
        return tstring;
    }

    public void setTstring(String tstring) {
        this.tstring = tstring;
    }
}
