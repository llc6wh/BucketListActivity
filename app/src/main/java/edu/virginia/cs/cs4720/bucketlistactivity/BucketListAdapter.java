package edu.virginia.cs.cs4720.bucketlistactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class BucketListAdapter extends RecyclerView.Adapter<BucketListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTextView;
        public ViewHolder(View itemView){
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.itemName);
        }

    }

    private List<BucketItem> mBucketItems;
    private Context mContext;

    public BucketListAdapter(Context context, List<BucketItem> bucketItems){
        mBucketItems = bucketItems;
        mContext = context;
    }

    private Context getContext(){
        return mContext;
    }

    @Override
    public BucketListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.activity_bucket_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BucketListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        BucketItem item = mBucketItems.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.itemTextView;
        textView.setText(item.getName());
        if(!item.getIsCompleted()) {
            textView.setClickable(false);
            textView.setActivated(false);
            textView.setEnabled(false);

        }

    }
    @Override
    public int getItemCount() {
        return mBucketItems.size();
    }

}
