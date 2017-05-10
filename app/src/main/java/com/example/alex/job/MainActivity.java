package com.example.alex.job;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alex.activity.ActivityLifecycle;

public class MainActivity extends AppCompatActivity implements MyAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecycleView = (RecyclerView) findViewById(R.id.recycleView);
        mRecycleView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(topicList);
        mAdapter.setOnItemClickListener(this);
        mRecycleView.setAdapter(mAdapter);
    }

    @Override
    public void onClicked(int position) {
        if (position < topicActivity.length) {
            Intent intent = new Intent(this, topicActivity[position]);
            startActivity(intent);
        } else {
            Toast.makeText(this, "没有指定要启动的Activity #" + position, Toast.LENGTH_SHORT).show();
        }
    }

    private RecyclerView mRecycleView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private final static String TAG = MainActivity.class.getName();

    private String[] topicList = new String[]{
            "Activity Lifecycle Test",
            "Text 2",
            "Text 3",
            "Text 4",
            "Text 5",
            "Text 6",
            "Text 7",
            "Text 8",
            "Text 9",
            "Text 10"
    };

    private Class[] topicActivity = new Class[] {
            ActivityLifecycle.class,
    };
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onClicked(int position);
    }

    public MyAdapter(String[] data) {
        mData = data;
    }


    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_adapter_item_text, parent, false);
        return new ViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textView.setText(mData[position]);
        holder.textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onClicked(position);
                }
                Log.d(TAG, "onClick #" + position);
            }
        });
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
    private OnItemClickListener listener;

    private final static String TAG = MyAdapter.class.getName();
}
