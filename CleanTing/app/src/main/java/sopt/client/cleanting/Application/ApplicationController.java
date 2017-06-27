package sopt.client.cleanting.Application;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sopt.client.cleanting.Network.NetworkService;

/**
 * Created by 김지원 on 2017-06-25.
 */

public class ApplicationController extends Application {
    private static ApplicationController instance;
    public static ApplicationController getInstance(){
        return instance;
    }
    private static String baseUrl = "";
    private NetworkService networkService;
    public NetworkService getNetworkService(){
        return networkService;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationController.instance = this;

//        buildService();       //통신소스 완료 후 주석풀자.
    }

    public void buildService(){
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder.baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();

        networkService = retrofit.create(NetworkService.class);
    }
}
