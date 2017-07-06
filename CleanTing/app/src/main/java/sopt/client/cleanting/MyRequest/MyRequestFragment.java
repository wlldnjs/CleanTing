package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.MakeTing.MakeTingLocationResult;
import sopt.client.cleanting.MakeTing.MakeTingLocationResultData;
import sopt.client.cleanting.MakeTing.SendTingLocationData;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static android.app.Activity.RESULT_OK;
import static sopt.client.cleanting.Main.Login.LoginActivity.loginUserDatas;
import static sopt.client.cleanting.Main.MainActivity.REQUEST_JOIN;

/**
 * Created by 김지원 on 2017-06-25.
 */

public class MyRequestFragment extends Fragment{
    NetworkService service;
//    Bundle bundle;
    ArrayList<Bundle> bundleList = new ArrayList<Bundle>();
    Context context;
    RecyclerView recyclerMyLocation;
    ArrayList<MakeTingLocationResultData> itemData;
    LinearLayoutManager layoutManager;
    MyRequestAdapter myRequestAdapter;
    int selectPosition;
    public static boolean refreshView = true;
    boolean firstCreate = true;
//    FragmentTransaction ft = getFragmentManager().beginTransaction();

    public MyRequestFragment() {
    }
    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_myrequest,container,false);
        recyclerMyLocation = (RecyclerView)layout.findViewById(R.id.recycler_my_location);
        recyclerMyLocation.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerMyLocation.setLayoutManager(layoutManager);

        itemData = new ArrayList<MakeTingLocationResultData>();
        SendTingLocationData sendTingLocationData = new SendTingLocationData();
        sendTingLocationData.userLat = "37.5218849";
        sendTingLocationData.userLng = "126.8513412";
        Call<MakeTingLocationResult> makeTingLocationResultCall = service.getMakeTingLocationResult(loginUserDatas.userId,sendTingLocationData);
        makeTingLocationResultCall.enqueue(new Callback<MakeTingLocationResult>() {
            @Override
            public void onResponse(Call<MakeTingLocationResult> call, Response<MakeTingLocationResult> response) {
                if(response.isSuccessful()){
                    itemData = response.body().result;

                }
            }

            @Override
            public void onFailure(Call<MakeTingLocationResult> call, Throwable t) {

            }
        });
//        itemData.add(new MyRequestData("2017년 6월 5일 (월)","13:00~19:00","1"));
//        itemData.add(new MyRequestData("2017년 6월 6일 (화)","14:00~19:00","1"));
//        itemData.add(new MyRequestData("2017년 6월 7일 (수)","15:00~19:00","1"));
//        itemData.add(new MyRequestData("2017년 6월 8일 (목)","16:00~19:00","1"));
//        itemData.add(new MyRequestData("2017년 6월 9일 (금)","17:00~19:00","2"));

//        bundleList.clear();
//        bundleList = getBundleList();
//        if(refreshView){
//            Toast.makeText(context, "메인페이지 refresh", Toast.LENGTH_SHORT).show();
//            RefreshView();
//            refreshView = false;
//        }

        if(firstCreate){
            RefreshView();
            firstCreate = false;
        }

        Log.d("MyRequestFragment", "onCreateView 호출");
        return layout;
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int temp_position = recyclerMyLocation.getChildPosition(view);
            if(temp_position == 0){
//                Toast.makeText(context, "헤더입니다.", Toast.LENGTH_SHORT).show();
            } else {
//                String temp = myRequestAdapter.itemDatas.get(temp_position-1).writer;
                MakeTingLocationResultData datas = itemData.get(temp_position-1);
                Intent intent = new Intent(context, MyRequestRecruit.class);
                intent.putExtra("datas", datas);
                selectPosition = temp_position-1;
//                intent.putExtra("position", temp_position-1);
                startActivityForResult(intent,REQUEST_JOIN);
            }
        }
    };
    public ArrayList<Bundle> getBundleList(){
        Call<RequestTingDetailResult> requestTingDetailResultCall = service.getRequestTingDetailResult(loginUserDatas.userId);
        requestTingDetailResultCall.enqueue(new Callback<RequestTingDetailResult>() {
            @Override
            public void onResponse(Call<RequestTingDetailResult> call, Response<RequestTingDetailResult> response) {
                if(response.isSuccessful()){
                    for(int i=0; i<response.body().result.size(); i++){
                        bundleList.add(getBundle(response.body().result.get(i)));
                    }
                    FragmentManager fm = getFragmentManager();
                    myRequestAdapter = new MyRequestAdapter(itemData,clickListener,context, fm, bundleList);
                    recyclerMyLocation.setAdapter(myRequestAdapter);
                    recyclerMyLocation.scrollToPosition(0);

                }else {
                    Toast.makeText(context, "통신 실패", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RequestTingDetailResult> call, Throwable t) {
                Toast.makeText(context, "인터넷확인", Toast.LENGTH_SHORT).show();
            }
        });

        return bundleList;
    }

    public Bundle getBundle(RequestTingDetailResultData requestTingDetailResultData){
        Bundle bundle = new Bundle();
//        bundle.putString("img_url", img_url);
        bundle.putString("tingId", requestTingDetailResultData.tingId);
        bundle.putString("date", requestTingDetailResultData.date);
        bundle.putString("startTime", requestTingDetailResultData.startTime);
        bundle.putString("endTime", requestTingDetailResultData.endTime);
        bundle.putString("cnt", requestTingDetailResultData.cnt);
        bundle.putString("cleanerId", requestTingDetailResultData.cleanerId);
        bundle.putString("userId", requestTingDetailResultData.userId);
        bundle.putString("price", requestTingDetailResultData.price);
        bundle.putString("request", requestTingDetailResultData.request);
        bundle.putString("warning", requestTingDetailResultData.warning);
        bundle.putString("name", requestTingDetailResultData.name);
        bundle.putString("phone", requestTingDetailResultData.phone);
        return bundle;
    }

    public void RefreshView(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this);
        ft.attach(this);
        ft.commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_JOIN) {
                Toast.makeText(context, "참여 완료", Toast.LENGTH_SHORT).show();
                RefreshView();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("MyRequestFragment", "onResume 호출");
        bundleList.clear();
        bundleList = getBundleList();
        if(refreshView){
            Toast.makeText(context, "메인페이지 refresh", Toast.LENGTH_SHORT).show();
            RefreshView();
            refreshView = false;
        }
    }
}