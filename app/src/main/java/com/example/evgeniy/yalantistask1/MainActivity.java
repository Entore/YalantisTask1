package com.example.evgeniy.yalantistask1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private List<String> mImage;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    private static final int TOAST_CUT_SYMBOLS = 9;
    private static final int TOAST_X_OFFSET = 0;
    private static final int TOAST_Y_OFFSET = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mImage = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.images)));
        showImage(mImage);

    }

    private void showImage(List<String> arrayList) {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        ImageRecyclerAdapter adapter = new ImageRecyclerAdapter(this, arrayList);
        mRecyclerView.setAdapter(adapter);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }


    public void showToast(String text) {

        Toast toast = Toast.makeText(this, text.substring(TOAST_CUT_SYMBOLS), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, TOAST_X_OFFSET, TOAST_Y_OFFSET);
        toast.show();
    }


    public void showOnClick(View view) {

        showToast(view.getClass().getSimpleName());
    }

}
