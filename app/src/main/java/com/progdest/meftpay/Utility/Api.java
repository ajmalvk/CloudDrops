package com.progdest.meftpay.Utility;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    /****
     *
     *  Login check phone
     *
     **/


    @FormUrlEncoded
    @Headers("token-valid: jvEKetgL*~~^?tk^rg[V?3Ta:38Jwtfrt}`&:.#r-DA5m?3(xQ")
    @POST("login/login_check_phone")
    Call<JsonObject> loginUserCheckPhone(
            @Field("phone") String phone_number
    );


    /****
     *
     *  Login Verify code
     *
     **/


    @FormUrlEncoded
    @Headers("token-valid: CNwmc&@`+PVZN<+nZ@2d`fR*8#{Tj3;VW,>=D#@#Ev)xX@my#A")
    @POST("login/login_verify_user_code")
    Call<JsonObject> loginUserVerifyPhone(
            @Field("code") String verify_code,
            @Field("user_id") String user_id,
            @Field("name") String name,
            @Field("firebase_token") String firebase_token
    );


    /****
     *
     * Get Home Data
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: @`g:c-;'v;-3#T5@nU`YNMECVa7#r,@2De@+A`[?]@f#sD@s#X"
    })
    @GET("profiledata/get_home_data")
    Call<JsonObject> getHome(@Header("access-token") String tokken);



    /****
     *
     * Check Login
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: @`g:c-;'v;-3#T5@nU`YNMECVa7#r,@2De@+A`[?]@f#sD@s#X"
    })
    @GET("profiledata/check_login")
    Call<JsonObject> checkLogin(@Header("access-token") String tokken);



    /****
     *
     * Get Products by Category
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: Qv,/qHS9`f^+5`#'?vb:TE(-A<W@#yqAP@#/?*ee<7r/*(snSH"
    })
    @GET("profiledata/get_products_by_category")
    Call<JsonObject> getProductsByCategory(
            @Header("access-token") String tokken,
            @Field("category_id") String category_id
    );


    /****
     *
     * Logout User
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: Y=)6TtmzZm^,M+2v~GK~fbXc]uyu<$6yW<{bFw(#JpSJ~b^;b*"
    })
    @GET("profiledata/logout_user")
    Call<JsonObject> logoutUser(@Header("access-token") String tokken);


    /****
     *
     *
     * Get User
     *
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: Y=)6TtmzZm^,M+2v~GK~fbXc]uyu<$6yW<{bFw(#JpSJ~b^;b*"
    })
    @GET("profiledata/get_user")
    Call<JsonObject> getUser(@Header("access-token") String tokken);


    /****
     *
     * Insert User Address
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: zK}'2d!'nvwxN@zp%V%[*7vte8]T#Q`,5`!?#R[S>pJbvs&THJ"
    })
    @GET("profiledata/insert_user_address")
    Call<JsonObject> insertUserAddress(
            @Header("access-token") String tokken,
            @Field("title") String address_title,
            @Field("name") String address_name,
            @Field("locality") String address_locality,
            @Field("address_line1") String address_line1,
            @Field("address_line2") String address_line2,
            @Field("post") String post,
            @Field("pin") String pin,
            @Field("area") String area,
            @Field("city") String city,
            @Field("landmark") String landmark,
            @Field("phone") String phone,
            @Field("latitude") String latitude,
            @Field("longitude") String longitude,
            @Field("id") String address_id,
            @Field("main") String main
    );


    /****
     *
     * Delete User Address
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: NsfxU#A:c6Nj,&TAr%L@(eEHfm_x).VzQ%H{73_ZWg%GM9<5#MJ"
    })
    @GET("profiledata/delete_user_address")
    Call<JsonObject> deleteUsrAddress(
            @Header("access-token") String tokken,
            @Field("id") String address_id
    );



    /****
     *
     * Add To Cart
     *
     **/




    @Headers({  "token-valid: ~F^S]_#xn*>esC!2h3Gw_UG}#x898D{B65Auz%Eavk_nR<%??k",
            "token-valid-second: ED@ca?pzL,s]mGv^[n5e,URuVm*#g7z^Yen=`?aWKH*@ZhMG=T"
    })
    @GET("profiledata/add_cart")
    Call<JsonObject> addCart(
            @Header("access-token") String tokken,
            @Field("product") String product_id,
            @Field("quantity") String product_quantity
    );
}
