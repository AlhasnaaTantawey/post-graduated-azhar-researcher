package azhar.researcher.pg_azharresearcher;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResearcherModel {
    @SerializedName("degree")
    @Expose
    private String degree;

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @SerializedName("UniAccept")
    @Expose
    private int uniAccept;

    @SerializedName("InsertValue")
    @Expose
    private int insertValue;
    @SerializedName("ID")
    @Expose
    private int id;
    @SerializedName("Arname")
    @Expose
    private String arabicName;
    @SerializedName("Enname")
    @Expose
    private String Enname;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("Azhar")
    @Expose
    private String azhar;
    @SerializedName("Forign")
    @Expose
    private String forign;
    @SerializedName("BirthDate")
    @Expose
    private String birthDate;
    @SerializedName("BirthBlace")
    @Expose
    private String birthPlace;
    @SerializedName("village")
    @Expose
    private String village;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("CurrentPlace")
    @Expose
    private String currentPlace;
    @SerializedName("Tel")
    @Expose
    private String telephone;
    @SerializedName("Mobaile")
    @Expose
    private String mobaile;
    @SerializedName("InJop")
    @Expose
    private int inJop;
    @SerializedName("Jop")
    @Expose
    private String jop;
    @SerializedName("JopPlace")
    @Expose
    private String jopPlace;

    @SerializedName("JopTel")
    @Expose
    private String jopTelphone;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @SerializedName("DeptID")
    @Expose
    private int deptId;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("NationalID")
    @Expose
    private String nationalID;
    @SerializedName("NationalPlace")
    @Expose
    private String nationalPlace;
    @SerializedName("NationalDate")
    @Expose
    private String nationalDate;
    @SerializedName("MsgArAddress")
    @Expose
    private String msgArAddress;

    @SerializedName("MsgEnAddress")
    @Expose
    private String msgEnAddress;
    @SerializedName("LastFac")
    @Expose
    private String lastFac;
    @SerializedName("Qualification")
    @Expose
    private String qualification;
    @SerializedName("QualSpecialization")
    @Expose
    private String qualSpecialization;
    @SerializedName("QualFac")
    @Expose
    private String qualFac;
    @SerializedName("QualDate")
    @Expose
    private String qualDate;
    @SerializedName("QualUnivesity")
    @Expose
    private String qualUnivesity;

    @SerializedName("QualGrade")
    @Expose
    private int qualGrade;

    @SerializedName("MsgAccept")
    @Expose
    private String msgAccept;

    @SerializedName("Dept_Council")
    @Expose
    private String dept_Council;
    @SerializedName("Fac_Council")
    @Expose
    private String fac_Council;


    @SerializedName("Fac_Council_No")
    @Expose
    private String fac_Council_No;

    @SerializedName("Uni_Council")
    @Expose
    private String uni_Council;

    @SerializedName("Regsitretion_Period")
    @Expose
    private String regsitretion_Period;

    @SerializedName("IsCancelled")
    @Expose
    private int isCancelled;

    @SerializedName("DegId")
    @Expose
    private int degId;

    @SerializedName("MilitrayId")
    @Expose
    private int militrayId;


    @SerializedName("BrId")
    @Expose
    private int brId;

    @SerializedName("SpId")
    @Expose
    private int spId;


    @Override
    public String toString() {
        return "ResearcherModel{" +
                "id=" + id +
                ", arabicName='" + arabicName + '\'' +
                ", Enname='" + Enname + '\'' +
                ", gender='" + gender + '\'' +
                ", azhar='" + azhar + '\'' +
                ", forign='" + forign + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", birthPlace='" + birthPlace + '\'' +
                ", village='" + village + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", currentPlace='" + currentPlace + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobaile='" + mobaile + '\'' +
                ", inJop=" + inJop +
                ", jop='" + jop + '\'' +
                ", jopPlace='" + jopPlace + '\'' +
                ", jopTelphone='" + jopTelphone + '\'' +
                ", deptId=" + deptId +
                ", specialization='" + specialization + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", nationalPlace='" + nationalPlace + '\'' +
                ", nationalDate='" + nationalDate + '\'' +
                ", msgArAddress='" + msgArAddress + '\'' +
                ", msgEnAddress='" + msgEnAddress + '\'' +
                ", lastFac='" + lastFac + '\'' +
                ", qualification='" + qualification + '\'' +
                ", qualSpecialization='" + qualSpecialization + '\'' +
                ", qualFac='" + qualFac + '\'' +
                ", qualDate='" + qualDate + '\'' +
                ", qualUnivesity='" + qualUnivesity + '\'' +
                ", qualGrade=" + qualGrade +
                ", msgAccept='" + msgAccept + '\'' +
                ", dept_Council='" + dept_Council + '\'' +
                ", fac_Council='" + fac_Council + '\'' +
                ", fac_Council_No='" + fac_Council_No + '\'' +
                ", uni_Council='" + uni_Council + '\'' +
                ", regsitretion_Period='" + regsitretion_Period + '\'' +
                ", isCancelled=" + isCancelled +
                ", degId=" + degId +
                ", militrayId=" + militrayId +
                ", brId=" + brId +
                ", spId=" + spId +
                ", isGranted=" + isGranted +
                ", deptAccept=" + deptAccept +
                ", facAccept=" + facAccept +
                ", uniAccept=" + uniAccept +
                ", insertValue=" + insertValue +
                '}';
    }

    @SerializedName("IsGranted")
    @Expose
    private int isGranted;

    @SerializedName("DeptAccept")
    @Expose
    private int deptAccept;
    @SerializedName("FacAccept")
    @Expose
    private int facAccept;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnname() {
        return Enname;
    }

    public void setEnname(String enname) {
        Enname = enname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAzhar() {
        return azhar;
    }

    public void setAzhar(String azhar) {
        this.azhar = azhar;
    }

    public String getForign() {
        return forign;
    }

    public void setForign(String forign) {
        this.forign = forign;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurrentPlace() {
        return currentPlace;
    }

    public void setCurrentPlace(String currentPlace) {
        this.currentPlace = currentPlace;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobaile() {
        return mobaile;
    }

    public void setMobaile(String mobaile) {
        this.mobaile = mobaile;
    }

    public int getInJop() {
        return inJop;
    }

    public void setInJop(int inJop) {
        this.inJop = inJop;
    }

    public String getJop() {
        return jop;
    }

    public void setJop(String jop) {
        this.jop = jop;
    }

    public String getJopPlace() {
        return jopPlace;
    }

    public void setJopPlace(String jopPlace) {
        this.jopPlace = jopPlace;
    }

    public String getJopTelphone() {
        return jopTelphone;
    }

    public void setJopTelphone(String jopTelphone) {
        this.jopTelphone = jopTelphone;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getNationalPlace() {
        return nationalPlace;
    }

    public void setNationalPlace(String nationalPlace) {
        this.nationalPlace = nationalPlace;
    }

    public String getNationalDate() {
        return nationalDate;
    }

    public void setNationalDate(String nationalDate) {
        this.nationalDate = nationalDate;
    }

    public String getMsgArAddress() {
        return msgArAddress;
    }

    public void setMsgArAddress(String msgArAddress) {
        this.msgArAddress = msgArAddress;
    }

    public String getMsgEnAddress() {
        return msgEnAddress;
    }

    public void setMsgEnAddress(String msgEnAddress) {
        this.msgEnAddress = msgEnAddress;
    }

    public String getLastFac() {
        return lastFac;
    }

    public void setLastFac(String lastFac) {
        this.lastFac = lastFac;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualSpecialization() {
        return qualSpecialization;
    }

    public void setQualSpecialization(String qualSpecialization) {
        this.qualSpecialization = qualSpecialization;
    }

    public String getQualFac() {
        return qualFac;
    }

    public void setQualFac(String qualFac) {
        this.qualFac = qualFac;
    }

    public String getQualDate() {
        return qualDate;
    }

    public void setQualDate(String qualDate) {
        this.qualDate = qualDate;
    }

    public String getQualUnivesity() {
        return qualUnivesity;
    }

    public void setQualUnivesity(String qualUnivesity) {
        this.qualUnivesity = qualUnivesity;
    }

    public int getQualGrade() {
        return qualGrade;
    }

    public void setQualGrade(int qualGrade) {
        this.qualGrade = qualGrade;
    }

    public String getMsgAccept() {
        return msgAccept;
    }

    public void setMsgAccept(String msgAccept) {
        this.msgAccept = msgAccept;
    }

    public String getDept_Council() {
        return dept_Council;
    }

    public void setDept_Council(String dept_Council) {
        this.dept_Council = dept_Council;
    }

    public String getFac_Council() {
        return fac_Council;
    }

    public void setFac_Council(String fac_Council) {
        this.fac_Council = fac_Council;
    }

    public String getFac_Council_No() {
        return fac_Council_No;
    }

    public void setFac_Council_No(String fac_Council_No) {
        this.fac_Council_No = fac_Council_No;
    }

    public String getUni_Council() {
        return uni_Council;
    }

    public void setUni_Council(String uni_Council) {
        this.uni_Council = uni_Council;
    }

    public String getRegsitretion_Period() {
        return regsitretion_Period;
    }

    public void setRegsitretion_Period(String regsitretion_Period) {
        this.regsitretion_Period = regsitretion_Period;
    }

    public int getIsCancelled() {
        return isCancelled;
    }

    public void setIsCancelled(int isCancelled) {
        this.isCancelled = isCancelled;
    }

    public int getDegId() {
        return degId;
    }

    public void setDegId(int degId) {
        this.degId = degId;
    }

    public int getMilitrayId() {
        return militrayId;
    }

    public void setMilitrayId(int militrayId) {
        this.militrayId = militrayId;
    }

    public int getBrId() {
        return brId;
    }

    public void setBrId(int brId) {
        this.brId = brId;
    }

    public int getSpId() {
        return spId;
    }

    public void setSpId(int spId) {
        this.spId = spId;
    }

    public int getIsGranted() {
        return isGranted;
    }

    public void setIsGranted(int isGranted) {
        this.isGranted = isGranted;
    }

    public int getDeptAccept() {
        return deptAccept;
    }

    public void setDeptAccept(int deptAccept) {
        this.deptAccept = deptAccept;
    }

    public int getFacAccept() {
        return facAccept;
    }

    public void setFacAccept(int facAccept) {
        this.facAccept = facAccept;
    }

    public int getUniAccept() {
        return uniAccept;
    }

    public void setUniAccept(int uniAccept) {
        this.uniAccept = uniAccept;
    }

    public int getInsertValue() {
        return insertValue;
    }

    public void setInsertValue(int insertValue) {
        this.insertValue = insertValue;
    }


}
