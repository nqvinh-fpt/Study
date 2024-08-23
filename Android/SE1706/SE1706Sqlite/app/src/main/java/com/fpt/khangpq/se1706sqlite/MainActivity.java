package com.fpt.khangpq.se1706sqlite;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnSave;
    private Button btnLoad;
    private EditText edtName;
    private EditText edtPhone;

    private DBContext dbContext;

    private void bindingView() {
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        dbContext = new DBContext(this);
    }

    private void bindingAction() {
        btnSave.setOnClickListener(this::onBtnSaveClick);
        btnLoad.setOnClickListener(this::onBtnLoadClick);
    }

    private void onBtnLoadClick(View view) {
        Cursor c = dbContext.getAllContact();
        if (c.moveToFirst()) {
            do {
                int id = c.getInt(0);
                int phoneColIndex = c.getColumnIndex(DBContext.TB_CONTACT_COL_PHONE);
                String phone = c.getString(phoneColIndex);
                @SuppressLint("Range") String name =
                        c.getString(c.getColumnIndex(DBContext.TB_CONTACT_COL_NAME));
                Log.d("Khangpq.debug", id + " --- " + name + " --- " + phone);


            } while (c.moveToNext());
        }else{
            Toast.makeText(this, "Không có bản ghi nào", Toast.LENGTH_SHORT).show();
        }
    }

    private void onBtnSaveClick(View view) {
        String name = edtName.getText().toString();
        String phone = edtPhone.getText().toString();
        Contact c = new Contact(name, phone);
        long id = dbContext.insertContact2(c);
        Toast.makeText(this, id < 0 ? "Failed" : "Success insert with id=" + id, Toast.LENGTH_SHORT).show();
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
    }
}