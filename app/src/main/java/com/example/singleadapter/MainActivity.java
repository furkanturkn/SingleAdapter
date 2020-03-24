package com.example.singleadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.singleadapter.ExAdapter.GenjitsuAdapter;
import com.example.singleadapter.Objects.RecyclerObje;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GenjitsuAdapter mAdapter;

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<RecyclerObje> mExampleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildRecyclerView();

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.exRecycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new GenjitsuAdapter(mExampleList);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new GenjitsuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //changeItem(position, "Clicked");
            }

            @Override
            public void onButtonClick(int position) {
                //ShareItem(position);
            }
        });

    }
}
