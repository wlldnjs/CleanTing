package sopt.client.cleanting.Community;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-30.
 */

public class CommunityFragment extends Fragment {
    NetworkService service;
    Context context;

    public ImageView more_btn;
    LinearLayout frameLinear;
    LinearLayout btn_remove;

    TextView search_tv;
    TextView filter_tv;
    ImageView Floatimg;

    private RecyclerView BrecyclerView;
    private ArrayList<Bulletin> bulletinArrayList;
    private BulletinListRecylerAdapter BrecyclerAdapter;
    private LinearLayoutManager layoutManager;


    public CommunityFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        FrameLayout layout = (FrameLayout)inflater.inflate(R.layout.fragment_community,container,false);

        more_btn = (ImageView)layout.findViewById(R.id.more_btn);
        frameLinear = (LinearLayout)layout.findViewById(R.id.frameLinear);

        more_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLinear.setVisibility(v.VISIBLE);
                more_btn.setVisibility(v.INVISIBLE);
            }
        });

        BrecyclerView = (RecyclerView)layout.findViewById(R.id.BulletinRecyclerView);
        BrecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        BrecyclerView.setLayoutManager(layoutManager);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        bulletinArrayList = new ArrayList<Bulletin>();                         //사용자 정의 데이터를 갖는 arraylist
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));
        bulletinArrayList.add(new Bulletin("제목", "날짜","사러가자","12"));

        BrecyclerAdapter = new BulletinListRecylerAdapter(bulletinArrayList,clickEvent);
        BrecyclerView.setAdapter(BrecyclerAdapter);

        btn_remove = (LinearLayout)layout.findViewById(R.id.btn_remove);
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameLinear.setVisibility(v.INVISIBLE);
                more_btn.setVisibility(v.VISIBLE);
            }
        });

        search_tv = (TextView)layout.findViewById(R.id.B_search);
        search_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CommunitySearchActivity.class);
                startActivity(intent);
            }
        });

        filter_tv = (TextView)layout.findViewById(R.id.B_filter);
        filter_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CommunityFilterActivity.class);
                startActivity(intent);
            }
        });

        Floatimg = (ImageView)layout.findViewById(R.id.floatimg);
        Floatimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),CommunityWriteActivity.class);
                startActivity(intent);
            }
        });

        return layout;
    }
    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = BrecyclerView.getChildPosition(v);           //position 을 지원하지 않는다 따라서 직접 얻어와야함
            Intent intent = new Intent(getContext(),CommunityBulletinDetailActivity.class);
            startActivity(intent);
        }
    };
}