package com.example.iqbal.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String,List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();

        expandableListView = findViewById(R.id.elv);
        customAdapter = new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);


    }

    public void prepareListData()
    {
        String[] headerList = getResources().getStringArray(R.array.abbr_list_header);
        String[] childList = getResources().getStringArray(R.array.abbr_list_child);

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        for (int i=0; i<headerList.length; i++)
        {
            listDataHeader.add(headerList[i]);

            List<String> child = new ArrayList<>();
            child.add(childList[i]);

            listDataChild.put(listDataHeader.get(i),child);
        }

    }
}
