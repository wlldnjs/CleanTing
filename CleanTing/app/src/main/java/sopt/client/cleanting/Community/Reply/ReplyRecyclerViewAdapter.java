package sopt.client.cleanting.Community.Reply;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class ReplyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    ArrayList<ReplyData> itemdata;
    Context context;

    public ReplyRecyclerViewAdapter(ArrayList<ReplyData> itemdata,Context context) {
        this.context = context;
        this.itemdata = itemdata;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER)
        {
            View v = LayoutInflater.from(context).inflate(R.layout.custom_recyclerview_header,parent,false);
            return new CHeaderViewHolder(v);
        }
        if (viewType == TYPE_ITEM)
        {
            View v = LayoutInflater.from(context).inflate(R.layout.custom_recyclerview_item,parent,false);
            return new CBaseViewHolder(v);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof CHeaderViewHolder)
        {

        }
        else if(holder instanceof CBaseViewHolder)
        {
            ReplyData currentitem = itemdata.get(position-1); // 포지션 재 정리
            CBaseViewHolder baseViewHolder = (CBaseViewHolder) holder;
            baseViewHolder.ReplyContent.setText(currentitem.getContent());
            baseViewHolder.ReplyDate.setText(currentitem.getWriter());
        }
    }
    @Override
    public int getItemCount() {
        return itemdata.size() + 1 ;
    }
}
