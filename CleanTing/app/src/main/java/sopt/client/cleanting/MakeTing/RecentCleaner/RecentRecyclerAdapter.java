package sopt.client.cleanting.MakeTing.RecentCleaner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class RecentRecyclerAdapter extends RecyclerView.Adapter<RecentCleanerViewHolder> {

    private final View.OnClickListener clickListener;
    ArrayList<RecentCleanerData> Rcleaners;

    public RecentRecyclerAdapter(ArrayList<RecentCleanerData> itemdatas,View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        this.Rcleaners = itemdatas;
    }

    @Override
    public RecentCleanerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recent_cleaner, parent, false);
        RecentCleanerViewHolder viewHolder = new RecentCleanerViewHolder(view);             //커스텀 뷰홀더 객체 생성
        view.setOnClickListener(clickListener);                     // 정의된 클릭이벤트를 달아준다

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecentCleanerViewHolder holder, int position) {

        //        holder.R_CleanerImg.setImageResource(0);                  // 클리너 사진
        holder.R_CleanerName.setText(Rcleaners.get(position).getR_name());             // 클리너 이름
        holder.R_date.setText(Rcleaners.get(position).getR_date());
//        holder.R_starrate.setImageResource(0);   // 클리너 별점

    }

    @Override
    public int getItemCount() {
        return Rcleaners != null ? Rcleaners.size() : 0;
    }
}
