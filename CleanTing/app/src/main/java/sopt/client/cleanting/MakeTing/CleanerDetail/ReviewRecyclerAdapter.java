package sopt.client.cleanting.MakeTing.CleanerDetail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class ReviewRecyclerAdapter extends RecyclerView.Adapter<ReviewlistViewHolder> {

    ArrayList<ReviewItem> reviews;

    public ReviewRecyclerAdapter(ArrayList<ReviewItem> itemdatas) {
        this.reviews = itemdatas;
    }

    @Override
    public ReviewlistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_list, parent, false);
        ReviewlistViewHolder viewHolder = new ReviewlistViewHolder(view);             //커스텀 뷰홀더 객체 생성

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ReviewlistViewHolder holder, int position) {

        holder.writername.setText(reviews.get(position).getWritername());             // 클리너 이름
        holder.writedate.setText(reviews.get(position).getWritedate());
        holder.writecomment.setText(reviews.get(position).getWritecomment());
    }
    @Override
    public int getItemCount() {
        return reviews != null ? reviews.size() : 0;
    }
}
