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
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

import sopt.client.cleanting.Application.ApplicationController;
import sopt.client.cleanting.Network.NetworkService;
import sopt.client.cleanting.R;


public class AlarmFragment extends Fragment {
    NetworkService service;
    Context context;
    public ExpandableListView expandableListView; // ExpandableListView 변수 선언
    public CustomExpandableListViewAdapter mCustomExpListViewAdapter; // 위 ExpandableListView를 받을 CustomAdapter(2번 class에 해당)를 선언
    public ArrayList<String> parentList; // ExpandableListView의 Parent 항목이 될 List 변수 선언
    public ArrayList<ChildListData> fruit; // ExpandableListView의 Child 항목이 될 List를 각각 선언
    public ArrayList<ChildListData> vegetables;
    public ArrayList<ChildListData> etc;
    public HashMap<String, ArrayList<ChildListData>> childList; // 위 ParentList와 ChildList를 연결할 HashMap 변수 선언

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
        int width = newDisplay.getWidth();  //Indicator위치변경용!!!

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_alarm); // activity_main.xml을 MainActivity에 연결

        // ExpandableListView의 ParentList에 해당할 항목을 입력
        parentList = new ArrayList<String>();
        parentList.add("GROUP A");
        parentList.add("GROUP B");
        parentList.add("GROUP C");


        // 앞서 ParentList에 연결할 ChildList 항목을 선언 및 입력
        ChildListData apple = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData pair = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData persimmon = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        fruit = new ArrayList<ChildListData>();
        fruit.add(apple);
        fruit.add(pair);
        fruit.add(persimmon);

        ChildListData onion = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData cabbage = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData potato = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        vegetables = new ArrayList<ChildListData>();
        vegetables.add(onion);
        vegetables.add(cabbage);
        vegetables.add(potato);

        ChildListData snack  = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData beer = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        ChildListData soju = new ChildListData(getResources().getDrawable(R.mipmap.ic_launcher));
        etc = new ArrayList<ChildListData>();
        etc.add(snack);
        etc.add(beer);
        etc.add(soju);

        // 위에서 선언한 ParentList와 ChildList를 HashMap을 통해
        childList = new HashMap<String, ArrayList<ChildListData>>();
        childList.put(parentList.get(0), fruit);
        childList.put(parentList.get(1), vegetables);
        childList.put(parentList.get(2), etc);



        // 앞서 정의해 놓은 ExpandableListView와 그 CustomAdapter를 선언 및 연결한 후
        // ExpandableListView에 대한 OnClickListener 등을 선언
        expandableListView = (ExpandableListView)layout.findViewById(R.id.expandablelist);
        mCustomExpListViewAdapter = new CustomExpandableListViewAdapter(this, parentList, childList);
        expandableListView.setAdapter(mCustomExpListViewAdapter);
        expandableListView.setIndicatorBounds(width-50, width);


        int groupCount = (int) mCustomExpListViewAdapter.getGroupCount();
        expandableListView.expandGroup(0);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });



        return layout;
    }
}
