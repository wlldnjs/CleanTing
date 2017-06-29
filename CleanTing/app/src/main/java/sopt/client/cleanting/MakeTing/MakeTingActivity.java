package sopt.client.cleanting.MakeTing;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import sopt.client.cleanting.R;

public class MakeTingActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout selectDate1, selectTime1, selectRequest1, selectWorning1, selectCleaner1;
    LinearLayout selectDate2, selectTime2, selectRequest2, selectWorning2, selectCleaner2;
    TextView date, timeStart, timeEnd, request, warning, cleaner, amount;
    EditText warningEdit;
    ImageView requestBtn;
    ListView listView1, listView2;
    ArrayList<String> timeData;
    ArrayAdapter arrayAdapter;
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_ting);
        date = (TextView)findViewById(R.id.date_text);
        timeStart = (TextView)findViewById(R.id.time_start_text);
        timeEnd = (TextView)findViewById(R.id.time_end_text);
        request = (TextView)findViewById(R.id.request_text);
        warning = (TextView)findViewById(R.id.warning_text);
        cleaner= (TextView)findViewById(R.id.cleaner_text);
        amount = (TextView)findViewById(R.id.total_text);

        calendarView = (CalendarView)findViewById(R.id.calendarview);
        warningEdit = (EditText)findViewById(R.id.warning_edit);
        requestBtn = (ImageView)findViewById(R.id.make_ting_request_btn);

        selectDate1 = (RelativeLayout)findViewById(R.id.select_date_layout1);
        selectTime1 = (RelativeLayout)findViewById(R.id.select_time_layout1);
        selectRequest1 = (RelativeLayout)findViewById(R.id.select_request_layout1);
        selectWorning1 = (RelativeLayout)findViewById(R.id.select_warning_layout1);
        selectCleaner1 = (RelativeLayout)findViewById(R.id.select_cleaner_layout1);

        selectDate2 = (LinearLayout)findViewById(R.id.select_date_layout2);
        selectTime2 = (LinearLayout)findViewById(R.id.select_time_layout2);
        selectRequest2 = (LinearLayout)findViewById(R.id.select_request_layout2);
        selectWorning2 = (LinearLayout)findViewById(R.id.select_warning_layout2);
        selectCleaner2 = (LinearLayout) findViewById(R.id.select_cleaner_layout2);

        listView1 = (ListView)findViewById(R.id.select_time_list1);
        listView2 = (ListView)findViewById(R.id.select_time_list2);

        timeData = new ArrayList<String>();
        timeData.add("00:00");timeData.add("00:30");timeData.add("01:00");timeData.add("01:30");
        timeData.add("02:00");timeData.add("02:30");timeData.add("03:00");timeData.add("03:30");
        timeData.add("04:00");timeData.add("04:30");timeData.add("05:00");timeData.add("05:30");
        timeData.add("06:00");timeData.add("06:30");timeData.add("07:00");timeData.add("07:30");
        timeData.add("08:00");timeData.add("08:30");timeData.add("09:00");timeData.add("09:30");
        timeData.add("10:00");timeData.add("10:30");timeData.add("11:00");timeData.add("11:30");
        timeData.add("12:00");timeData.add("12:30");timeData.add("13:00");timeData.add("13:30");
        timeData.add("14:00");timeData.add("14:30");timeData.add("15:00");timeData.add("15:30");
        timeData.add("16:00");timeData.add("16:30");timeData.add("17:00");timeData.add("17:30");
        timeData.add("18:00");timeData.add("18:30");timeData.add("19:00");timeData.add("19:30");
        timeData.add("20:00");timeData.add("20:30");timeData.add("21:00");timeData.add("21:30");
        timeData.add("22:00");timeData.add("22:30");timeData.add("23:00");timeData.add("23:30");

        arrayAdapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,timeData);
        listView1.setAdapter(arrayAdapter);
        listView2.setAdapter(arrayAdapter);

        selectDate1.setOnClickListener(this);
        selectTime1.setOnClickListener(this);
        selectRequest1.setOnClickListener(this);
        selectWorning1.setOnClickListener(this);
        selectCleaner1.setOnClickListener(this);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                timeStart.setText(""+parent.getItemAtPosition(position));
            }
        });
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                timeEnd.setText(""+parent.getItemAtPosition(position));
            }
        });

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date.setText(""+month+"월 " +dayOfMonth+"일");
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.select_date_layout1:
                if(selectDate2.getVisibility() == View.GONE) {
                    selectDate2.setVisibility(View.VISIBLE);
                } else {
                    selectDate2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_time_layout1:
                if(selectTime2.getVisibility() == View.GONE) {
                    selectTime2.setVisibility(View.VISIBLE);
                } else {
                    selectTime2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_request_layout1:
                if(selectRequest2.getVisibility() == View.GONE) {
                    selectRequest2.setVisibility(View.VISIBLE);
                } else {
                    selectRequest2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_warning_layout1:
                if(selectWorning2.getVisibility() == View.GONE) {
                    selectWorning2.setVisibility(View.VISIBLE);
                } else {
                    selectWorning2.setVisibility(View.GONE);
                }
                break;
            case R.id.select_cleaner_layout1:
                if(selectCleaner2.getVisibility() == View.GONE) {
                    selectCleaner2.setVisibility(View.VISIBLE);
                } else {
                    selectCleaner2.setVisibility(View.GONE);
                }
                break;
        }
    }
}
