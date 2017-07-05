package sopt.client.cleanting.MakeTing.SearchList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.Cleanner.SearchLocationCleanerData;
import sopt.client.cleanting.MakeTing.ListCleaner.ListCleanerViewHolder;
import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class SearchRecyclerAdapter extends RecyclerView.Adapter<ListCleanerViewHolder> {

    private final View.OnClickListener clickListener;
    ArrayList<SearchLocationCleanerData> Lcleaners;

    public SearchRecyclerAdapter(ArrayList<SearchLocationCleanerData> itemdatas,View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        this.Lcleaners = itemdatas;
    }

    @Override
    public ListCleanerViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cleaner_list, parent, false);
        ListCleanerViewHolder viewHolder = new ListCleanerViewHolder(view);             //커스텀 뷰홀더 객체 생성
        view.setOnClickListener(clickListener);                     // 정의된 클릭이벤트를 달아준다

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListCleanerViewHolder holder, int position) {
        holder.ListCleanername.setText(Lcleaners.get(position).name+" 클리너");             // 클리너 이름
        holder.ListCleanerhistory.setText("청소 경력 : "+ Lcleaners.get(position).career + "개월");
        holder.ListCleanercomment.setText("후기 : "+ Lcleaners.get(position).review_cnt);

        if(Lcleaners.get(position).rate.equals("0"))
        {
            holder.ListCleanerrate1.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate2.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate3.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate4.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate5.setImageResource(R.drawable.star_line);
        }
        if(Lcleaners.get(position).rate.equals("1"))
        {
            holder.ListCleanerrate2.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate3.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate4.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate5.setImageResource(R.drawable.star_line);
        }
        if(Lcleaners.get(position).rate.equals("2"))
        {
            holder.ListCleanerrate3.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate4.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate5.setImageResource(R.drawable.star_line);
        }
        if(Lcleaners.get(position).rate.equals("3"))
        {
            holder.ListCleanerrate4.setImageResource(R.drawable.star_line);
            holder.ListCleanerrate5.setImageResource(R.drawable.star_line);
        }
        if(Lcleaners.get(position).rate.equals("4"))
        {
            holder.ListCleanerrate5.setImageResource(R.drawable.star_line);
        }
    }

    @Override
    public int getItemCount() {
        return Lcleaners != null ? Lcleaners.size() : 0;
    }
}
