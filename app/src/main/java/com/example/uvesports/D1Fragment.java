package com.example.uvesports;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;


public class D1Fragment extends Fragment {
    private ListView lvList;

    private D1Adapter adapter;

//    Ez kell mindenkepp fragment, enelkul nem fog mukodni (Empty consturctor)
    public D1Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_d1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvList = view.findViewById(R.id.lvList);

        DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setGroupBy("date_of DESC");

        Backendless.Persistence.of(D1.class).find(queryBuilder, new AsyncCallback<List<D1>>() {
            @Override
            public void handleResponse(List<D1> response) {

                adapter = new D1Adapter(getContext(),response);
                lvList.setAdapter(adapter);

            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(getContext(), "Error: " +fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
