package azhar.researcher.pg_azharresearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllDataForCommit {
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("formationPartOne")
    @Expose
    private FormationPartOne formationPartOne;
    @SerializedName("formationPartTwo")
    @Expose
    private FormationPartOne formationPartTwo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FormationPartOne getFormationPartOne() {
        return formationPartOne;
    }

    public void setFormationPartOne(FormationPartOne formationPartOne) {
        this.formationPartOne = formationPartOne;
    }

    public FormationPartOne getFormationPartTwo() {
        return formationPartTwo;
    }

    public void setFormationPartTwo(FormationPartOne formationPartTwo) {
        this.formationPartTwo = formationPartTwo;
    }
}

class FormationPartOne {
    @SerializedName("Title")
    @Expose
    private String title;

    @SerializedName("Conditions")
    @Expose
    ArrayList<Item> conditions;

    @SerializedName("AdditionalInformation")
    @Expose
    ArrayList<String> AdditionalInformation;

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
        return AdditionalInformation;
    }

    public void setAdditionalInformation(ArrayList<String> additionalInformation) {
        AdditionalInformation = additionalInformation;
    }
}


