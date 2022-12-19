package azhar.researcher.pg_azharresearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllDataForGrantInstructions {
    @SerializedName("Title")
    @Expose
    private String title;
    private GrantedPartOne grantedPartOne;
    private GrantedPartOne grantedPartTwo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GrantedPartOne getGrantedPartOne() {
        return grantedPartOne;
    }

    public void setGrantedPartOne(GrantedPartOne grantedPartOne) {
        this.grantedPartOne = grantedPartOne;
    }

    public GrantedPartOne getGrantedPartTwo() {
        return grantedPartTwo;
    }

    public void setGrantedPartTwo(GrantedPartOne grantedPartTwo) {
        this.grantedPartTwo = grantedPartTwo;
    }
}

class GrantedPartOne {
    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Conditions")
    @Expose
    ArrayList<Item> conditions;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Item> getConditions() {
        return conditions;
    }

    public void setConditions(ArrayList<Item> conditions) {
        this.conditions = conditions;
    }
}

class Item {

    @SerializedName("num")
    @Expose
    private int num;

    @SerializedName("text")
    @Expose
    private String text;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}