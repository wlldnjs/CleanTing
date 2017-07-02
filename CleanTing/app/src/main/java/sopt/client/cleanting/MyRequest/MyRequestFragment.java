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

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

import static android.app.Activity.RESULT_OK;
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
    ArrayList<MyRequestData> itemData;
    LinearLayoutManager layoutManager;
    MyRequestAdapter myRequestAdapter;
    int selectPosition;

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

        itemData = new ArrayList<MyRequestData>();
        itemData.add(new MyRequestData("2017년 6월 5일 (월)","13:00~19:00","1"));
        itemData.add(new MyRequestData("2017년 6월 6일 (화)","14:00~19:00","1"));
        itemData.add(new MyRequestData("2017년 6월 7일 (수)","15:00~19:00","1"));
        itemData.add(new MyRequestData("2017년 6월 8일 (목)","16:00~19:00","1"));
        itemData.add(new MyRequestData("2017년 6월 9일 (금)","17:00~19:00","2"));
        FragmentManager fm = getFragmentManager();
        bundleList = getBundleList();
        myRequestAdapter = new MyRequestAdapter(itemData,clickListener,context, fm, bundleList);
        recyclerMyLocation.setAdapter(myRequestAdapter);
        recyclerMyLocation.scrollToPosition(0);
        Log.d("onCreateView", "호출");
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
                Toast.makeText(context, itemData.get(temp_position-1).day +"," +itemData.get(temp_position-1).time , Toast.LENGTH_SHORT).show();
                MyRequestData datas = itemData.get(temp_position-1);
                Intent intent = new Intent(context, MyRequestRecruit.class);
                intent.putExtra("datas", datas);
                selectPosition = temp_position-1;
//                intent.putExtra("position", temp_position-1);
                startActivityForResult(intent,REQUEST_JOIN);
            }
        }
    };
    public ArrayList<Bundle> getBundleList(){
//        for(int i=0; i<3; i++){
            bundleList.add(getBundle("", "테스트","테스트2","테스트3","2"));
        bundleList.add(getBundle("", "테스트2","테스트2","테스트3","1"));
        bundleList.add(getBundle("", "테스트3","테스트2","테스트3","3"));
//        }
        return bundleList;
    }

    public Bundle getBundle(String img_url, String cleaner_name, String date, String time, String member_count){
        Bundle bundle = new Bundle();
        bundle.putString("img_url", img_url);
        bundle.putString("cleaner_name", cleaner_name);
        bundle.putString("date", date);
        bundle.putString("time", time);
        bundle.putString("member_count", member_count);
        return bundle;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_JOIN){
                Toast.makeText(context, "참여 완료", Toast.LENGTH_SHORT).show();
//            int position = this.getActivity().getIntent().getIntExtra("position",0);
                Log.d("포지션 값",""+selectPosition);

                MyRequestData getData = itemData.get(selectPosition);
                int memeber = Integer.parseInt(getData.member);
                Log.d("변경 전 멤버 수",""+memeber);
                memeber++;
                Log.d("변경 후 멤버 수",""+memeber);
                getData.member = String.valueOf(memeber);
                Log.d("세팅된 멤버 수",""+getData.member);
                itemData.set(selectPosition,getData);
                myRequestAdapter.notifyDataSetChanged();

                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(this);
                ft.attach(this);
                ft.commit();
//                itemData.add(selectPosition,getData);
//                itemData.remove(selectPosition+1);
//                myRequestAdapter.notifyDataSetChanged();
//                itemData.add(0,getData);
//                ArrayList<MyRequestData> newArray = new ArrayList<MyRequestData>();
//                newArray.addAll(itemData);
//                itemData.removeAll(itemData);
//                myRequestAdapter.notifyDataSetChanged();
//                itemData.addAll(newArray);
//                myRequestAdapter.notifyDataSetChanged();
//                myRequestAdapter.notifyItemChanged(selectPosition);
            }
        }
    }



}