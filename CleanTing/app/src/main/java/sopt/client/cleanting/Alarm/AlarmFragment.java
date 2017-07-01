package sopt.client.cleanting.Alarm;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;


public class AlarmFragment extends Fragment {
    NetworkService service;
    Context context;
    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;
    private ImageView group_bar;
    public AlarmFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        service = ApplicationController.getInstance().getNetworkService();
        LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_alarm,container,false);
        Display newDisplay = getActivity().getWindowManager().getDefaultDisplay();
        int width = newDisplay.getWidth();  //Indicator위치변경용!!


        super.onCreate(savedInstanceState);
        listView=(ExpandableListView) layout.findViewById(R.id.expandablelist);
        initData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
        listView.setIndicatorBounds(width-50, width);
        listView.expandGroup(0);//첫번째 goupA 열어놓고 시작

        group_bar=(ImageView)getActivity().findViewById(R.id.group_bar);



        //열릴때 parentList이미지 바뀌는거! 일단 임의로 아무이미지나 넣어놓음
//        for(int i=0;i<listView.getCount();i++){
//            if(listView.expandGroup(i)==true){
//                group_bar.setImageResource(R.drawable.edit);
//            }
//            else{
//               group_bar.setImageResource(R.drawable.line);
//           }
//        }

        return layout;
    }


    private void initData() {

        listDataHeader = new ArrayList<>();
        listHashMap = new HashMap<>();

        listDataHeader.add("GroupA");
        listDataHeader.add("GroupB");
        listDataHeader.add("GroupC");
        listDataHeader.add("GroupD");

        List<String> groupA=new ArrayList<>();
        groupA.add("안녕");

        List<String> groupB= new ArrayList<>();
        groupB.add("내이름은");
        groupB.add("김진영이야");
        groupB.add("만나서");
        groupB.add("반가워");

        List<String> groupC=new ArrayList<>();
        groupC.add("너의");
        groupC.add("이름은");
        groupC.add("뭐니");

        List<String> groupD=new ArrayList<>();
        groupD.add("앞으로");
        groupD.add("친하게");
        groupD.add("지내자");

        listHashMap.put(listDataHeader.get(0),groupA);
        listHashMap.put(listDataHeader.get(1),groupB);
        listHashMap.put(listDataHeader.get(2),groupC);
        listHashMap.put(listDataHeader.get(3),groupD);

    }




    }


