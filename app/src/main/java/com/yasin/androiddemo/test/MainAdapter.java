package com.yasin.androiddemo.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.yasin.androiddemo.R;
import com.yasin.androiddemo.entity.MainEntity;
import com.yasin.androiddemo.entity.Node;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private Context mContext;
    private List<MainEntity> mainEntityList;

    public MainAdapter(Context mContext, List<MainEntity> mainEntityList) {
        this.mContext = mContext;
        this.mainEntityList = mainEntityList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }

    class AThread extends Thread{
        @Override
        public void run() {
            super.run();
        }
    }
}
