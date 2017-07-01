package com.example.expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter=new ExpandableListAdapter(this,listDataHeader,listHashMap);
        listView.setAdapter(listAdapter);
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
