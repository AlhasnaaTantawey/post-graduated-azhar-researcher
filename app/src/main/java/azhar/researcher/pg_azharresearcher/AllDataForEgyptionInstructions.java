package azhar.researcher.pg_azharresearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllDataForEgyptionInstructions {
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("egyptianPartOne")
    @Expose
    private EgyptianPartOne egyptianPartOne;

    @SerializedName("egyptianPartTwo")
    @Expose
    private EgyptianPartTwo egyptianPartTwo;

    @SerializedName("egyptianPartThree")
    @Expose
    private EgyptianPartTwo egyptianPartThree;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EgyptianPartOne getEgyptianPartOne() {
        return egyptianPartOne;
    }

    public void setEgyptianPartOne(EgyptianPartOne egyptianPartOne) {
        this.egyptianPartOne = egyptianPartOne;
    }

    public EgyptianPartTwo getEgyptianPartTwo() {
        return egyptianPartTwo;
    }

    public void setEgyptianPartTwo(EgyptianPartTwo egyptianPartTwo) {
        this.egyptianPartTwo = egyptianPartTwo;
    }

    public EgyptianPartTwo getEgyptianPartThree() {
        return egyptianPartThree;
    }

    public void setEgyptianPartThree(EgyptianPartTwo egyptianPartThree) {
        this.egyptianPartThree = egyptianPartThree;
    }
}

 class EgyptianPartOne {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Registration")
    @Expose
    private ArrayList<String> registration;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getRegistration() {
        return registration;
    }

    public void setRegistration(ArrayList<String> registration) {
        this.registration = registration;
    }
}

class EgyptianPartTwo {
    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("conditions")
    @Expose
    private ArrayList<Item> conditions;

    @SerializedName("additionalInformation")
    @Expose
    private ArrayList<String> additionalInformation;

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

    public ArrayList<String> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(ArrayList<String> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}

