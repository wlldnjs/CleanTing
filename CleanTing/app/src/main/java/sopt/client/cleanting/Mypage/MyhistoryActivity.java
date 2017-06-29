package sopt.client.cleanting.Mypage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import sopt.client.cleanting.R;

public class MyhistoryActivity extends AppCompatActivity {

    private RecyclerView historyrecyclerView;
    private ArrayList<Historydata> historydatas;
    private HistoryRecyclerViewAdapter historyrecyclerAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myhistory);

        historyrecyclerView = (RecyclerView)findViewById(R.id.HistoryRecyclerview);
        historyrecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);             //리니어레이아웃의 형태이면 방향은 수직
        historyrecyclerView.setLayoutManager(layoutManager);

        historydatas = new ArrayList<Historydata>();                         //사용자 정의 데이터를 갖는 arraylist
        historydatas.add(new Historydata("박클리너1","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너2","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historydatas.add(new Historydata("박클리너3","2017.06.28","9:00 - 17:00"));
        historyrecyclerAdapter = new HistoryRecyclerViewAdapter(historydatas);
        historyrecyclerView.setAdapter(historyrecyclerAdapter);
    }
}
