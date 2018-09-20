package edu.virginia.cs.cs4720.bucketlistactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Date;


public class BucketListActivity extends AppCompatActivity {

    ArrayList<BucketItem> bucketItems;
    EditText bucketItemName;
    RecyclerView rvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list);



        rvItems = (RecyclerView) findViewById(R.id.rvItems);
        bucketItemName = (EditText) findViewById(R.id.itemName);


        BucketListAdapter adapter = new BucketListAdapter(this, bucketItems);

        rvItems.setAdapter(adapter);

        rvItems.setLayoutManager(new LinearLayoutManager(this));

        bucketItems = BucketItem.createInitialBucketList(1, "streak", new Date(1,2,3), "streaking the lawn",2.5,3.1,false);
    }

    public void onAddButtonClick(View view) {
        //launch new activity, screen to add items and item info
        Intent intent = new Intent(this, AddItemActivity.class);
        startActivity(intent);
    }

    public void addBucketItem(View view){

        if(!bucketItemName.getText().toString().equals("")){
            Log.d("BucketListActivity","createItem " + bucketItemName.getText().toString());
            bucketItems.add(new BucketItem(bucketItemName.getText().toString(), new Date(1,1,1), null, 0.0,0.0,false));
            rvItems.getAdapter().notifyDataSetChanged();

            bucketItemName.setText("");
        }
    }
}
