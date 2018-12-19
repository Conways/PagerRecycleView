package com.conways.pagerrecycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements PagerHelper.OnpageSlectedLisenter {

    MyAdapter myAdapter;
    RecyclerView recyclerView;
    PagerHelper pagerHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        myAdapter = new MyAdapter();
        pagerHelper = new PagerHelper();
        pagerHelper.setOnpageSlectedLisenter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myAdapter);
        pagerHelper.attachToRecyclerView(recyclerView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.refresh();
                pagerHelper.setCurrentPage(0);
                button.setText(pagerHelper.getCurrentPage() + "");
            }
        });

    }

    @Override
    public void onPageSlected(int positon) {
        button.setText(positon + "");
    }
}
