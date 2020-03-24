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

    String imageLink = "https://g.hizliresim.com/alex-pettyfer-01";
    String videoLink = "https://instagram.fsaw1-4.fna.fbcdn.net/v/t50.2886-16/88281411_240939810272750_6032082819699755303_n.mp4?_nc_ht=instagram.fsaw1-4.fna.fbcdn.net&_nc_cat=102&_nc_ohc=Y-4u58ammoYAX_Xt-QI&oe=5E7643A0&oh=611789c13ba64aef95783daf07543936";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExampleList = new ArrayList<>();
        mExampleList.add(new RecyclerObje(imageLink,imageLink));
        mExampleList.add(new RecyclerObje(imageLink,imageLink));
        mExampleList.add(new RecyclerObje(imageLink,imageLink));
        mExampleList.add(new RecyclerObje(imageLink,imageLink));


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
