package sopt.client.cleanting.Mypage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;
import sopt.client.cleanting.ViewHolder.MyCleanHistoryViewHolder;

/**
 * Created by glgld on 2017-06-29.
 */

public class HistoryRecyclerViewAdapter extends RecyclerView.Adapter<MyCleanHistoryViewHolder> {

    ArrayList<Historydata> historydatas;

    public HistoryRecyclerViewAdapter(ArrayList<Historydata> itemdatas)
    {
        this.historydatas = itemdatas;
    }

    @Override
    public MyCleanHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cleanhistory_recycler, parent, false);
        MyCleanHistoryViewHolder viewHolder = new MyCleanHistoryViewHolder(view);             //커스텀 뷰홀더 객체 생성

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyCleanHistoryViewHolder holder, int position)
    {
        holder.cleanername_tv.setText(historydatas.get(position).Cleanername);
        holder.cleandate_tv.setText("");
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
