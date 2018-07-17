package com.admin.taufiq.taufiq;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

     RecyclerView mRecylerView;
     private ArrayList<presiden> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecylerView = findViewById(R.id.myRecyclerView);
        mRecylerView.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PresidenData.getListData());

        setActionBarTitle("Mode List");

        showRecycleList();


    }
    // ListView Show on
    private void showRecycleList(){
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter adapter = new MyAdapter(this);
        adapter.setListPresiden(list);
        mRecylerView.setAdapter(adapter);


    }



    //GridView Show on
    private void ShowRecyclerGrid(){
        mRecylerView.setLayoutManager( new GridLayoutManager(this,3));
        GridAdapter gridPresidenAdapater = new GridAdapter(this);
        gridPresidenAdapater.setGridList(list);
        mRecylerView.setAdapter(gridPresidenAdapater);
    }


    //CardView Show on
    private void showCardView(){
        mRecylerView.setLayoutManager(new LinearLayoutManager(this));
        CardAdapter cardAdapter = new CardAdapter(this);
        cardAdapter.setListPresiden(list);
        mRecylerView.setAdapter(cardAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }


    //Menu Item On Action Bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String title = null;
        switch (item.getItemId()){
            case R.id.action_list:
                showRecycleList();
                title = "Mode List";
            break;

            case R.id.action_grid:
                ShowRecyclerGrid();
                title = "Mode Grid";
                break;

            case R.id.action_cardview:
                showCardView();
                title = "Mode Card";
                break;

        }
        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);
    }


}
