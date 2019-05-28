package com.demo.toolsshop;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrillCategoryActivity extends AppCompatActivity {

    private ListView listViewDrills;
    private ArrayList<Drill> drills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_category);

        ActionBar actionBar = getSupportActionBar(); //Ссылка на Акшн бар с названием
        if(actionBar !=null) //проверка существует ли экшн бар..
        {
            actionBar.hide(); //скрываем экшн бар
        }

        drills = new ArrayList<>();
        // Заполняем наш список дрелей
        drills.add(new Drill(getString(R.string.drill_interskol_title),
                             getString(R.string.drill_interskol_info),
                                       R.drawable.interscol));
        drills.add(new Drill(getString(R.string.drill_makita_title),
                             getString(R.string.drill_makita_info),
                                       R.drawable.makita));
        drills.add(new Drill(getString(R.string.drill_dewalt_title),
                             getString(R.string.drill_dewalt_info),
                                       R.drawable.dewalt));

        listViewDrills = findViewById(R.id.listViewDrills);
        ArrayAdapter<Drill> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.list_item,drills);
        listViewDrills.setAdapter(adapter);
        //Добавляем слушатель событий
        listViewDrills.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Drill drill = drills.get(position);
                Intent intent = new Intent(getApplicationContext(),DrillDetailActivity.class);
                intent.putExtra("title",drill.getTitle());
                intent.putExtra("info", drill.getInfo());
                intent.putExtra("resId", drill.getImageResourceId());
                startActivity(intent);

            }
        });
    }
}
