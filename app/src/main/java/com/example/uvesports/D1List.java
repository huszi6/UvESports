package com.example.uvesports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class D1List extends AppCompatActivity {

    ListView lvList;

    D1Adapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d1_list);

        lvList = findViewById(R.id.lvList);

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setGroupBy("date_of DESC");

        Backendless.Persistence.of(D1.class).find(queryBuilder, new AsyncCallback<List<D1>>() {
            @Override
            public void handleResponse(List<D1> response) {

                adapter = new D1Adapter(D1List.this,response);
                lvList.setAdapter(adapter);

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(D1List.this, "Error: " +fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
