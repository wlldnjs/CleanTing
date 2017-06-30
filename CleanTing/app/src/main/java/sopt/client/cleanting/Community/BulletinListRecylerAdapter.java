package sopt.client.cleanting.Community;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-06-30.
 */

public class BulletinListRecylerAdapter extends RecyclerView.Adapter<BulletinViewHolder>  {

    ArrayList<Bulletin> bulletinArrayList;

    public BulletinListRecylerAdapter(ArrayList<Bulletin> itemdatas)
    {
        this.bulletinArrayList = itemdatas;
    }


    @Override
    public BulletinViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bulletin_list,parent, false);
        BulletinViewHolder viewHolder = new BulletinViewHolder(view);             //커스텀 뷰홀더 객체 생성
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BulletinViewHolder holder, int position) {
        holder.BulletinTitle.setText(bulletinArrayList.get(position).B_title);
        holder.BulletinDate.setText(bulletinArrayList.get(position).B_date);
        holder.BullentinContent.setText(bulletinArrayList.get(position).B_content);
        holder.Bullentinreply.setText(bulletinArrayList.get(position).B_reply);
    }

    @Override
    public int getItemCount() {
        return bulletinArrayList != null ? bulletinArrayList.size() : 0;
    }
}
