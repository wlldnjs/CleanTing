package sopt.client.cleanting.MakeTing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sopt.client.cleanting.MakeTing.CleanerDetail.DetailCleanerActivity;
import sopt.client.cleanting.MakeTing.ListCleaner.ListCleanerData;
import sopt.client.cleanting.MakeTing.ListCleaner.ListCleanerRecyclerAdapter;
import sopt.client.cleanting.MakeTing.RecentCleaner.RecentCleanerData;
import sopt.client.cleanting.MakeTing.RecentCleaner.RecentRecyclerAdapter;
import sopt.client.cleanting.R;

public class ChooseCleanerActivity extends AppCompatActivity implements TextView.OnEditorActionListener {

    private RecyclerView RrecyclerView;
    private ArrayList<RecentCleanerData> Rcleaners;
    private RecentRecyclerAdapter RrecyclerAdapter;
    private LinearLayoutManager layoutManager;

    private RecyclerView LrecyclerView;
    private ArrayList<ListCleanerData> Lcleaners;
    private ListCleanerRecyclerAdapter ListRrecyclerAdapter;
    private LinearLayoutManager layoutManager2;

    private RecyclerView SearchrecyclerView;
    private ArrayList<ListCleanerData> Scleaners;
    private LinearLayoutManager layoutManager3;
    private ListCleanerRecyclerAdapter SearchrecyclerAdapter;

    EditText search;
    LinearLayout wrapLinear;
    LinearLayout Search_Linear;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_cleaner);

        search = (EditText)findViewById(R.id.search_edit);
        wrapLinear = (LinearLayout)findViewById(R.id.wrapLinear);
        Search_Linear = (LinearLayout)findViewById(R.id.Search_Linear);

        search.setOnEditorActionListener(this);
        search.addTextChangedListener(textWatcherInput);

        RrecyclerView = (RecyclerView) findViewById(R.id.Recent_recyclerview);
        RrecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);             //리니어레이아웃의 형태이면 방향은 수직
        RrecyclerView.setLayoutManager(layoutManager);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        Rcleaners = new ArrayList<RecentCleanerData>();                         //사용자 정의 데이터를 갖는 arraylist
        Rcleaners.add(new RecentCleanerData("이름1", "날짜1"));
        Rcleaners.add(new RecentCleanerData("이름2", "날짜2"));
        Rcleaners.add(new RecentCleanerData("이름3", "날짜3"));
        Rcleaners.add(new RecentCleanerData("이름3", "날짜3"));
        Rcleaners.add(new RecentCleanerData("이름3", "날짜3"));
        Rcleaners.add(new RecentCleanerData("이름3", "날짜3"));

        RrecyclerAdapter = new RecentRecyclerAdapter(Rcleaners,clickEvent);
        RrecyclerView.setAdapter(RrecyclerAdapter);


        LrecyclerView = (RecyclerView)findViewById(R.id.Cleanerlist_recyclerview);
        LrecyclerView.setHasFixedSize(true);

        layoutManager2 = new LinearLayoutManager(this);
        layoutManager2.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        LrecyclerView.setLayoutManager(layoutManager2);                           //리사이클러뷰에 레이아웃매니저를 달아준다

        Lcleaners = new ArrayList<ListCleanerData>();                         //사용자 정의 데이터를 갖는 arraylist
        Lcleaners.add(new ListCleanerData("이름1","15","50"));
        Lcleaners.add(new ListCleanerData("이름2","16","52"));
        Lcleaners.add(new ListCleanerData("이름3","17","55"));
        Lcleaners.add(new ListCleanerData("이름3","17","55"));
        Lcleaners.add(new ListCleanerData("이름3","17","55"));

        ListRrecyclerAdapter = new ListCleanerRecyclerAdapter(Lcleaners,clickEvent);
        LrecyclerView.setAdapter(ListRrecyclerAdapter);

        SearchrecyclerView = (RecyclerView)findViewById(R.id.Search_recyclerview);
        SearchrecyclerView.setHasFixedSize(true);
        layoutManager3 = new LinearLayoutManager(this);

        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        arrayList.add("별점순");
        arrayList.add("인기순");
        arrayList.add("후기순");

        ArrayAdapter adtRegion = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,arrayList);
        spinner = (Spinner)findViewById(R.id.sort_spinner);
        spinner.setAdapter(adtRegion);


    }

    public View.OnClickListener clickEvent = new View.OnClickListener() {
        public void onClick(View v) {
            final int itemPosition = RrecyclerView.getChildPosition(v);           //position 을 지원하지 않는다 따라서 직접 얻어와야함

            Intent intent = new Intent(getApplicationContext(),DetailCleanerActivity.class);
            startActivity(intent);

//            Toast.makeText(getApplicationContext(), itemPosition + "번 리스트 클릭!!", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

        switch(v.getId())
        {
            case R.id.search_edit:
            {
                Toast.makeText(getApplicationContext(),"df",Toast.LENGTH_SHORT).show();

                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {

                }
                break;
            }
        }

        return false;
    }

    TextWatcher textWatcherInput = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // TODO Auto-generated method stub
            wrapLinear.setVisibility(View.INVISIBLE);
            Search_Linear.setVisibility(View.VISIBLE);
            String str = s.toString();
            ArrayList<ListCleanerData> arrayList;
            arrayList = new ArrayList<>();
            ListCleanerData listCleaner;
            listCleaner = new ListCleanerData(str,"10","20");
            arrayList.add(listCleaner);
            layoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
            SearchrecyclerView.setLayoutManager(layoutManager3);
            SearchrecyclerAdapter = new ListCleanerRecyclerAdapter(arrayList,clickEvent);
            SearchrecyclerView.setAdapter(SearchrecyclerAdapter);
            if(s.toString().equals(""))
            {
                Search_Linear.setVisibility(View.GONE);
                wrapLinear.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            wrapLinear.setVisibility(View.INVISIBLE);
            Search_Linear.setVisibility(View.VISIBLE);

            String str = s.toString();
            ArrayList<ListCleanerData> arrayList;
            arrayList = new ArrayList<>();
            ListCleanerData listCleaner;
            listCleaner = new ListCleanerData(str,"10","20");
            arrayList.add(listCleaner);
            layoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
            SearchrecyclerView.setLayoutManager(layoutManager3);
            SearchrecyclerAdapter = new ListCleanerRecyclerAdapter(arrayList,clickEvent);
            SearchrecyclerView.setAdapter(SearchrecyclerAdapter);

            if(s.toString().equals(""))
            {
                Search_Linear.setVisibility(View.GONE);
                wrapLinear.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            wrapLinear.setVisibility(View.INVISIBLE);
            Search_Linear.setVisibility(View.VISIBLE);

            String str = s.toString();
            ArrayList<ListCleanerData> arrayList;
            arrayList = new ArrayList<>();
            ListCleanerData listCleaner;
            listCleaner = new ListCleanerData(str,"10","20");
            arrayList.add(listCleaner);
            layoutManager3.setOrientation(LinearLayoutManager.VERTICAL);
            SearchrecyclerView.setLayoutManager(layoutManager3);
            SearchrecyclerAdapter = new ListCleanerRecyclerAdapter(arrayList,clickEvent);
            SearchrecyclerView.setAdapter(SearchrecyclerAdapter);

            if(s.toString().equals(""))
            {
                Search_Linear.setVisibility(View.GONE);
                wrapLinear.setVisibility(View.VISIBLE);
            }

        }
    };
}
