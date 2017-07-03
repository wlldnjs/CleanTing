package sopt.client.cleanting.MakeTing.CleanerDetail;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sopt.client.cleanting.R;

/**
 * Created by glgld on 2017-07-03.
 */

public class ReviewlistViewHolder extends RecyclerView.ViewHolder {

    TextView writername;
    TextView writedate;
    ImageView star_img;
    TextView writecomment;

    public ReviewlistViewHolder(View itemView) {
        super(itemView);

        writername = (TextView)itemView.findViewById(R.id.writername);
        writedate = (TextView)itemView.findViewById(R.id.writedate);
        writecomment = (TextView)itemView.findViewById(R.id.writecomment);
    }
}
