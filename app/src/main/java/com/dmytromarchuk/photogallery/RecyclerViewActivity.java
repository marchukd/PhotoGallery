package com.dmytromarchuk.photogallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;



public class RecyclerViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);
        initDatabase();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, PicturesData.listAll(PicturesData.class));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    private void initDatabase() {
        if (PicturesData.count(PicturesData.class) == 0)
            new DataBaseCreator().createDatabase();
    }
}
