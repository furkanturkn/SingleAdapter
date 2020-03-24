package com.example.singleadapter.ExAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.singleadapter.Objects.RecyclerObje;
import com.example.singleadapter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Genjitsu on 24.03.2020.
 */
public class GenjitsuAdapter extends RecyclerView.Adapter<GenjitsuAdapter.ExampleViewHolder> {
    private ArrayList<RecyclerObje> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onButtonClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mUserImage,mClickableButton;
        public TextView mTextView1;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            mTextView1 = itemView.findViewById(R.id.user_name);
            mUserImage = itemView.findViewById(R.id.user_img);
            mClickableButton = itemView.findViewById(R.id.img_button);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            mClickableButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onButtonClick(position);
                        }
                    }
                }
            });
        }
    }

    public GenjitsuAdapter(ArrayList<RecyclerObje> exampleList) {
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_card, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v,mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(final ExampleViewHolder holder, int position) {
        RecyclerObje currentItem = mExampleList.get(position);

        holder.mTextView1.setText(currentItem.getTestString1());
        try{
            Picasso.get().load(currentItem.getTestString2()).into(holder.mUserImage);
        }catch (Exception e){
            Log.d("picassoerror: ", String.valueOf(e));
        }
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
