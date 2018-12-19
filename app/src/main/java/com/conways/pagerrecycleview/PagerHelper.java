package com.conways.pagerrecycleview;

import android.support.annotation.Nullable;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class PagerHelper extends PagerSnapHelper {

    private int currentPage = -1;
    private OnpageSlectedLisenter onpageSlectedLisenter;
    private RecyclerView recyclerView;


    @Nullable
    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        View currentView = super.findSnapView(layoutManager);
        if (null != currentView) {
            currentPage = layoutManager.getPosition(currentView);
            if (null != onpageSlectedLisenter) {
                onpageSlectedLisenter.onPageSlected(currentPage);
            }
        }
        return currentView;
    }

    @Override
    public void attachToRecyclerView(@Nullable RecyclerView recyclerView) throws IllegalStateException {
        this.recyclerView = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        this.recyclerView.scrollToPosition(currentPage);

    }

    public interface OnpageSlectedLisenter {
        void onPageSlected(int positon);
    }

    public void setOnpageSlectedLisenter(OnpageSlectedLisenter onpageSlectedLisenter) {
        this.onpageSlectedLisenter = onpageSlectedLisenter;
    }
}
