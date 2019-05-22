
package com.example.e_market;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Book> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);


        list.addAll(BookData.getListData());
        setActionBarTitle("E-Market : Book");
        showRecyclerList();

    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListBookAdapter listBookAdapter = new ListBookAdapter(this);
        listBookAdapter.setListBook(list);
        rvCategory.setAdapter(listBookAdapter);

        ItemClickSupport.addTo(rvCategory).setmOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent move = new Intent(MainActivity.this, DetailActivity.class);
                move.putExtra(DetailActivity.EXTRA_NAME, list.get(position).getName());
                move.putExtra(DetailActivity.EXTRA_DESCRIPTION, list.get(position).getDescription());
                move.putExtra(DetailActivity.EXTRA_PRICE, list.get(position).getPrice());
                move.putExtra(DetailActivity.EXTRA_PHOTO, list.get(position).getPhoto());
                startActivity(move);
            }
        });
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
