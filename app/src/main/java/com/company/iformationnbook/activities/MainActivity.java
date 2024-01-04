package com.company.iformationnbook.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.company.iformationnbook.adaptors.AdapterClass;
import com.company.iformationnbook.ModelClass;
import com.company.iformationnbook.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<ModelClass> arrayList;
    private AdapterClass adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ModelClass modelClass1=new ModelClass("countries","Countries");
        ModelClass  modelClass2=new ModelClass("leaders","Leaders");
        ModelClass  modelClass3=new ModelClass("museum", "Museums");
        ModelClass modelClass4=new ModelClass("sevenwonders","Seven Wonders of The World");

        arrayList.add(modelClass1);
        arrayList.add(modelClass2);
        arrayList.add(modelClass3);
        arrayList.add(modelClass4);

        adapter=new AdapterClass(arrayList,this);
        recyclerView.setAdapter(adapter);

    }
}