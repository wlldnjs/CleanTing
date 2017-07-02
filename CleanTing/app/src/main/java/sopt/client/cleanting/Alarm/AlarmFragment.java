package sopt.client.cleanting.Alarm;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;


public class AlarmFragment extends Fragment {
    private static final String[]  LIST_MENU ={"List1","List2","List3"} ;

    NetworkService service;
    Context context;
    ListView listview1,listview2,listview3;
    RelativeLayout groupA,groupB,groupC;
    LinearLayout groupA_item,groupB_item,groupC_item;
    AlarmAdapter Adapter;
    static int flag_a=0;
    static int flag_b,flag_c=1;
    public AlarmFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_alarm,container,false);
        service = ApplicationController.getInstance().getNetworkService();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        super.onCreate(savedInstanceState);

        ///////////////////////Parent랑 Child선언////////////////////////////
        groupA = (RelativeLayout)layout.findViewById(R.id.groupA);
        groupB = (RelativeLayout)layout.findViewById(R.id.groupB);
        groupC = (RelativeLayout)layout.findViewById(R.id.groupC);

        groupA_item=(LinearLayout)layout.findViewById(R.id.groupA_item);
        groupB_item=(LinearLayout)layout.findViewById(R.id.groupB_item);
        groupC_item=(LinearLayout)layout.findViewById(R.id.groupC_item);


        Adapter = new AlarmAdapter();

        listview1 = (ListView)layout.findViewById(R.id.listview1);
        listview1.setAdapter(Adapter);
        Adapter.addItem("김진영님이 집을 나갔습니다.","11:00PM");
        Adapter.addItem("김진영님이 다시 들어왔습니다.","12:35PM");
        Adapter.addItem("김진영님이 가출했습니다.","13:35PM");

        listview2=(ListView)layout.findViewById(R.id.listview2);
        listview2.setAdapter(Adapter);
        Adapter.addItem("잘있어라","13:50PM");
        Adapter.addItem("세상아","15:50PM");

        listview3=(ListView)layout.findViewById(R.id.listview3);
        listview3.setAdapter(Adapter);
        Adapter.addItem("나","11:00PM");
        Adapter.addItem("휴가좀","16:23PM");
        Adapter.addItem("다녀올게","09:00AM");


        ////////////////클릭하면 색깔바뀌게 하는 기능////////////////////////

        groupA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(flag_a ==0){
                    groupA_item.setVisibility(View.GONE);
                    groupA.setBackgroundResource(R.drawable.yellow_box_line);
                    flag_a=1;
                }
                else{
                    groupA_item.setVisibility(View.VISIBLE);
                    groupA.setBackgroundResource(R.drawable.yellow_box);
                    flag_a=0;
                }
            }
        });
        groupB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag_b==1){
                    groupB_item.setVisibility(View.VISIBLE);
                    groupB.setBackgroundResource(R.drawable.yellow_box);
                    flag_b=0;
                }
                else{
                    groupB_item.setVisibility(View.GONE);
                    groupB.setBackgroundResource(R.drawable.yellow_box_line);
                    flag_b=1;
                }
            }
        });
        groupC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag_c==1){
                    groupC_item.setVisibility(View.VISIBLE);
                    groupC.setBackgroundResource(R.drawable.yellow_box);
                    flag_c=0;
                }
                else{
                    groupC_item.setVisibility(View.GONE);
                    groupC.setBackgroundResource(R.drawable.yellow_box_line);
                    flag_c=1;
                }
            }
        });
        ////////////////////////////////////////////////////////////////////

        return layout;
    }



    }


