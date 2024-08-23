package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    private boolean isAppMinimized = false;
    TextView tvIndex;
    Button btnCloseHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnCloseHome = findViewById(R.id.btnClose);
        tvIndex = findViewById(R.id.tvUserName);
        Intent myIntent = getIntent();
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
        assert myBundle != null;
        String userName = myBundle.getString("username");
        if (userName != null) {
            userName = "Welcome " + userName;
            tvIndex.setText(userName);
        }
        btnCloseHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                        finish();
                        System.exit(0);
            }
        });


    }
    @Override
    protected void onPause() {
        super.onPause();
        isAppMinimized = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isAppMinimized) {
            isAppMinimized = false;
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        String title = item.getTitle().toString();
        int id = item.getItemId();
        Toast.makeText(this,title,Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}