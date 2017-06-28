package sopt.client.cleanting;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * Created by 김지원 on 2017-06-29.
 */

public class CustomLayoutManager extends LinearLayoutManager{
    private boolean isScrollEnabled = true;
    public CustomLayoutManager(Context context) {
        super(context);
    }
    public void setScrollEnabled(boolean flag){
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
