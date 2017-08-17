package exercise.pclap.basemvp.interactor;

import java.util.concurrent.TimeUnit;

import exercise.pclap.basemvp.commom.CONST;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by PC Lap on 8/17/2017.
 */
public class APIClient {

    private static Retrofit retrofit = null;

    private static OkHttpClient getOkHttp(){
        //tra du lieu khi request
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(3000, TimeUnit.SECONDS)
                .readTimeout(3000, TimeUnit.SECONDS)
                .writeTimeout(3000, TimeUnit.SECONDS)
                .build();

        return okHttpClient;
    }
    private static Retrofit getClient(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(CONST.BASE_URL)
                    .client(getOkHttp())
                    .build();
            return retrofit;
        }
        return retrofit;
    }

}
