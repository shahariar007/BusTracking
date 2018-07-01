package com.hossain.ju.bus.networking;


import com.hossain.ju.bus.model.Notice;
import com.hossain.ju.bus.model.route.Route;
import com.hossain.ju.bus.model.schedule.RouteSchedule;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Tariqul.Islam on 8/1/17.
 */

public interface APIServices {

    @POST("login")
    @Headers({"app-type: consumer-app", "Content-Type: application/json"})
    Call<ResponseBody> login(@Body HashMap<String, Object> body);



    @GET("get-all-routes")
    @Headers({"app-type: consumer-app", "Content-Type: application/json"})
    Call<ResponseWrapperArray<Route>> getAllRoutes(@Header("Authorization") String auth);

    @GET("get-location-by-schedule/{id}")
    @Headers({"app-type: consumer-app", "Content-Type: application/json"})
    Call<ResponseWrapperObject<RouteSchedule>> getBusLocationBySchedule(@Header("Authorization") String auth, @Path("id") int id);

    @GET("get-location/{id}")
    @Headers({"app-type: consumer-app", "Content-Type: application/json"})
    Call<ResponseWrapperArray<RouteSchedule>> getLocation(@Header("Authorization") String auth, @Path("id") int id);


    @GET("notice")
    @Headers({"app-type: consumer-app", "Content-Type: application/json"})
    Call<ResponseWrapperArray<Notice>> getAllNotification(@Header("Authorization") String auth);


}
