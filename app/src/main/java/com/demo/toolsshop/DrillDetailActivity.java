package com.demo.toolsshop;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.textservice.TextInfo;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DrillDetailActivity extends AppCompatActivity {


    private TextView textViewInfo;
    private TextView textViewTitle;
    private ImageView imageViewDrill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drill_detail);
        
        ActionBar actionBar = getSupportActionBar(); //Ссылка на Акшн бар с названием
        if(actionBar !=null) //проверка существует ли экшн бар..
        {
            actionBar.hide(); //скрываем экшн бар
        }

        textViewInfo = findViewById(R.id.textViewInfo);
        textViewTitle = findViewById(R.id.textViewTitle);
        imageViewDrill = findViewById(R.id.imageViewDrill);

        Intent intent = getIntent();
        if (intent.hasExtra("title")&&intent.hasExtra("info")&&intent.hasExtra("resId"))
        {
            String title = intent.getStringExtra("title");
            String info = intent.getStringExtra("info");
            int resId = intent.getIntExtra("resId",-1);

            textViewTitle.setText(title);
            textViewInfo.setText(info);
            imageViewDrill.setImageResource(resId);
        }else{
            Intent backToCategory = new Intent(this, DrillCategoryActivity.class);
            startActivity(backToCategory);
        }
    }
}
