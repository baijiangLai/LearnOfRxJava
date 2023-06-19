package com.lixiang.rxjavademo.switchThread;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 */
public interface WeatherServiceApi {
        //获取天气信息
        @GET("simpleWeather/query")
        Observable<Weather> getInformation(@Query("city") String city, @Query("key") String key);
}
