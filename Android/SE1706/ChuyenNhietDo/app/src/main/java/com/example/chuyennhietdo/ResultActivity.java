package com.example.chuyennhietdo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView txtNghiem;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        //Ánh xạ Id
        txtNghiem = findViewById(R.id.tvNghiem);
        btnBack = findViewById(R.id.btnBack);
        //Nhaanj intent
        Intent myIntent = getIntent();
        //Lay du lieu khoi bundle
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
        //Lay du lieu tu bundle
        assert myBundle != null;
        int a = myBundle.getInt("a");
        int b = myBundle.getInt("b");
        String nghiem;//giai phuong trinh
        if(a == 0 && b == 0){
            nghiem = "Phương trình vô số nghiệm";
        }else if(a == 0 && b != 0){
            nghiem = "Phương trình vô nghiệm";
        }else{
            nghiem = "Phương trình có nghiệm x = " + (-b/a);
        }
        txtNghiem.setText(nghiem);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                //khai bao
                Intent myIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(myIntent);
               }
            });





                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnBack), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
}