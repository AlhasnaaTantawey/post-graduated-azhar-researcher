package azhar.researcher.pg_azharresearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class AllDataForExternalInstructions {
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("partOne")
    @Expose
    private PartForExternal partOne;

    @SerializedName("partTwo")
    @Expose
    private PartForExternal partTwo;

    @SerializedName("partThree")
    @Expose
    private PartForExternal partThree;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PartForExternal getPartOne() {
        return partOne;
    }

    public void setPartOne(PartForExternal partOne) {
        this.partOne = partOne;
    }

    public PartForExternal getPartTwo() {
        return partTwo;
    }

    public void setPartTwo(PartForExternal partTwo) {
        this.partTwo = partTwo;
    }

    public PartForExternal getPartThree() {
        return partThree;
    }

    public void setPartThree(PartForExternal partThree) {
        this.partThree = partThree;
    }
}
class PartForExternal{
    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Registration Terms")
    @Expose
    ArrayList<String>Registration_Terms;


    @SerializedName("Registration Files")
    @Expose
    ArrayList<Item> RegistrationFiles;


    @SerializedName("Fees")
    @Expose
    ArrayList<Item> fees;

    @SerializedName("additionalInformation")
    @Expose
    ArrayList<String>additionalInformation;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getRegistration_Terms() {
        return Registration_Terms;
    }

    public void setRegistration_Terms(ArrayList<String> registration_Terms) {
        Registration_Terms = registration_Terms;
    }

    public ArrayList<Item> getRegistrationFiles() {
        return RegistrationFiles;
    }

    public void setRegistrationFiles(ArrayList<Item> registrationFiles) {
        RegistrationFiles = registrationFiles;
    }

    public ArrayList<Item> getFees() {
        return fees;
    }

    public void setFees(ArrayList<Item> fees) {
        this.fees = fees;
    }

    public ArrayList<String> getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(ArrayList<String> additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
}
