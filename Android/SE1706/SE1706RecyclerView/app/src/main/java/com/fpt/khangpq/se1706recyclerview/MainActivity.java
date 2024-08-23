package com.fpt.khangpq.se1706recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private Button btnClear;
    private List<SMS> data;

    private void bindingView() {
        rcv = findViewById(R.id.rcv);
        btnClear = findViewById(R.id.btnClear);
    }

    private void bindingAction() {
        btnClear.setOnClickListener(this::onBtnClearClick);
    }

    private void onBtnClearClick(View view) {
        data = new ArrayList<>();
        adapter.setData(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindingView();
        bindingAction();
        fakeData();
        initRcv();
    }

    private void fakeData() {
        data = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            data.add(new SMS(i + ". phone number", i + ". SMS content"));
        }
    }

    private SMSRcvAdapter adapter;

    private void initRcv() {
//        rcv.setLayoutManager(new LinearLayoutManager(this));
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new SMSRcvAdapter(data, this);
        rcv.setAdapter(adapter);

    }
}