package azhar.researcher.pg_azharresearcher;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EndPoint {

    @GET("/One_Researcher/{id}")
    Call<ResearcherModel> getOneResearcher(@Path("id") int id);

    @GET("/is_researcher_exist/{username}/{password}")
    Call<ResearcherModel> getResearcherByUsernameAndPassword(@Path("username") String username, @Path("password") String password);

    @GET("supervisors_res/{id}")
    Call<ArrayList<SupervisorModel>> getAllSupervisor_res(@Path("id") int id);

    @POST("create_a_note/")
    Call<Note> sendNotes(@Body Note note);

    @GET("instructionForGranted/")
    Call<AllDataForGrantInstructions> getInstructionsForGrant();

    @GET("instructionForFormation/")
    Call<AllDataForCommit> getInstructionsForCommit();

    @GET("instructionForForeigns/")
    Call<AllDataForExternalInstructions> getInstructionsForExternal();

    @GET("instructionForEgyptians/")
    Call<AllDataForEgyptionInstructions> getInstructionsForEgyptions();

    @PATCH("update_username_pass_Researcher/{id}/{username}/{passw}")
    Call<ResearcherModel> changeUsernameAndPassword(@Path("id") int id, @Path("username") String username, @Path("passw") String password);

    @GET("get_a_Order_Supervisor_Researcher/{supId}/{resId}")
    Call<ArrayList<RecievedRequestModel>> getAllRequestsFromOneSupervisorToOneResearcher(@Path("supId") int supId, @Path("resId") int resId);

    @GET("get_a_note_change_Address/{id}")
    Call<ChangeTitleRequestModel> getOneChangeTitleRequest(@Path("id") int id);

    @GET("get_a_note_changingSupervisor/{id}")
    Call<ChangeSupervisorsRequestModel> getOneChangeSupervisorRequest(@Path("id") int id);


    @GET("get_a_note_Extension/{id}")
    Call<ExtensionRequestModel> getOneExtendRequest(@Path("id") int id);


    @GET("showReportsForOneResearcher/{supId}/{resId}")
    Call<ArrayList<ReportModel>> getAllReportsFromOneSupervisorToOneResearcher(@Path("supId") int supId, @Path("resId") int resId);

    @GET("get_a_report/{id}")
    Call<ReportModel> getOneReportById(@Path("id") int id);
}
