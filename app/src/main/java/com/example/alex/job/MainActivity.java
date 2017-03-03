package com.example.alex.job;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(new String[]{
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4",
                "Text 5",
                "Text 6",
                "Text 7",
                "Text 8",
                "Text 9",
                "Text 10",
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4",
                "Text 5",
                "Text 6",
                "Text 7",
                "Text 8",
                "Text 9",
                "Text 10",
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4",
                "Text 5",
                "Text 6",
                "Text 7",
                "Text 8",
                "Text 9",
                "Text 10",
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4",
                "Text 5",
                "Text 6",
                "Text 7",
                "Text 8",
                "Text 9",
                "Text 10",
                "Text 1",
                "Text 2",
                "Text 3",
                "Text 4",
                "Text 5",
                "Text 6",
                "Text 7",
                "Text 8",
                "Text 9",
                "Text 10"
        });
        mRecycleView.setAdapter(mAdapter);
    }

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public MyAdapter(String[] data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_item_text, parent, false);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(mData[position]);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }

        public TextView textView;

    }

    private String[] mData;
}
