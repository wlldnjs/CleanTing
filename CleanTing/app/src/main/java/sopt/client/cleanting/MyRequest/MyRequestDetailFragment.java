package sopt.client.cleanting.MyRequest;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import sopt.client.cleanting.R;

/**
 * Created by 김지원 on 2017-06-28.
 */

public class MyRequestDetailFragment extends Fragment {
    Context context;
    TextView cleaner, date, time;
    ImageView member1, member2, member3;
    LinearLayout layout;
    String memberCount;

    public MyRequestDetailFragment() {
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.viewpager_my_request_detail,container,false);
        cleaner = (TextView)layout.findViewById(R.id.my_request_detail_cleaner);
        date = (TextView)layout.findViewById(R.id.my_request_detail_date1);
        time = (TextView)layout.findViewById(R.id.my_request_detail_time1);
        member1 = (ImageView)layout.findViewById(R.id.my_request_detail_member1);
        member2 = (ImageView)layout.findViewById(R.id.my_request_detail_member2);
        member3 = (ImageView)layout.findViewById(R.id.my_request_detail_member3);

        cleaner.setText(getArguments().getString("cleaner_name"));
        date.setText(getArguments().getString("date"));
        time.setText(getArguments().getString("time"));
        memberCount = getArguments().getString("member_count");
        if(memberCount.equals("2")){
            member1.setImageResource(R.drawable.man_line);
        } else if(memberCount.equals("1")){
            member1.setImageResource(R.drawable.man_line);
            member2.setImageResource(R.drawable.man_line);
        }

        return layout;
    }

    public void setData(String date1, String time1){
        date.setText(date1);
        time.setText(time1);
    }
}
