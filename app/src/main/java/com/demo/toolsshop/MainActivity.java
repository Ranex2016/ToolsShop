package com.demo.toolsshop;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listViewTools; //объявляем переменную типа "список"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar(); //Ссылка на Акшн бар с названием
        if(actionBar !=null) //проверка существует ли экшн бар..
        {
            actionBar.hide(); //скрываем экшн бар
        }
        listViewTools = findViewById(R.id.ListViewTools); //получаем ссылку

        //крепим на список слушатель событий и передаем в него ананимный класс у которого нужно реализовать метод.
        listViewTools.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Создаем  всплывающую додсказку для теста.
                //..предаем в неё главную активность getApplicationContext()
                //Toast.makeText(getApplicationContext(), "Позиция: " + position,Toast.LENGTH_SHORT).show();
                switch (position)
                {
                    case 0:
                        Intent intent = new Intent(getApplicationContext(), DrillCategoryActivity.class);
                        startActivity(intent);
                }
            }
        });

    }
}
