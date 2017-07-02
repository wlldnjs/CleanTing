package sopt.client.cleanting.MakeTing.ListCleaner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class ListCleanerRecyclerAdapter  extends RecyclerView.Adapter<ListCleanerViewHolder> {

    private final View.OnClickListener clickListener;
    ArrayList<ListCleanerData> Lcleaners;

    public ListCleanerRecyclerAdapter(ArrayList<ListCleanerData> itemdatas,View.OnClickListener clickListener) {
        this.clickListener = clickListener;
        this.Lcleaners = itemdatas;
    }

    @Override
    public ListCleanerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cleaner_list, parent, false);
        ListCleanerViewHolder viewHolder = new ListCleanerViewHolder(view);             //커스텀 뷰홀더 객체 생성
        view.setOnClickListener(clickListener);                     // 정의된 클릭이벤트를 달아준다

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ListCleanerViewHolder holder, int position) {
        holder.ListCleanername.setText(Lcleaners.get(position).getListCleanername());             // 클리너 이름
        holder.ListCleanerhistory.setText("청소 이력 : "+ Lcleaners.get(position).getListCleanerhistory());
        holder.ListCleanercomment.setText("후기 : "+ Lcleaners.get(position).getListCleanercomment());
    }

    @Override
    public int getItemCount() {
        return Lcleaners != null ? Lcleaners.size() : 0;
    }
}
