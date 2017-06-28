package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-25.
 */

public class MyRequestFragment extends Fragment{
    NetworkService service;
    Context context;
    RecyclerView recyclerMyLocation;
    ArrayList<MyRequestData> itemData;
    LinearLayoutManager layoutManager;
    MyRequestAdapter myRequestAdapter;

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
        itemData.add(new MyRequestData("2017년 6월 5일 (월)","13:00~19:00"));
        itemData.add(new MyRequestData("2017년 6월 6일 (월)","14:00~19:00"));
        itemData.add(new MyRequestData("2017년 6월 7일 (월)","15:00~19:00"));
        itemData.add(new MyRequestData("2017년 6월 8일 (월)","16:00~19:00"));
        itemData.add(new MyRequestData("2017년 6월 9일 (월)","17:00~19:00"));
        FragmentManager fm = getFragmentManager();
        myRequestAdapter = new MyRequestAdapter(itemData,clickListener,context, fm);
        recyclerMyLocation.setAdapter(myRequestAdapter);
        recyclerMyLocation.scrollToPosition(0);
        return layout;
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final int temp_position = recyclerMyLocation.getChildPosition(view);
            if(temp_position == 0){
                Toast.makeText(context, "헤더입니다.", Toast.LENGTH_SHORT).show();
            } else {
//                String temp = myRequestAdapter.itemDatas.get(temp_position-1).writer;
                Toast.makeText(context, temp_position + "번 댓글", Toast.LENGTH_SHORT).show();
            }
        }
    };
}