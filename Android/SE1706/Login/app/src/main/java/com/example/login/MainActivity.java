package com.example.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText txtUserName;
    EditText txtPassword;
    TextView txtError;
    Button btnLogin;

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
        btnLogin = findViewById(R.id.btnLogin);
        txtUserName = findViewById(R.id.edtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        txtError = findViewById(R.id.txtError);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {

                    txtError.setText("Username or password cannot be empty");
                }
                else if (!isValidUsername(username)) {
                    txtError.setText("Invalid username");
                }
                else if (!isValidPassword(password)) {
                    txtError.setText("Invalid password");
                }
                else if (username.equals("Admin123") && password.equals("Password@123")) {
                    Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                    Bundle mybundle = new Bundle();
                    mybundle.putString("username",username);
                    myIntent.putExtra("mypackage",mybundle);
                    startActivity(myIntent);
                }
                else {
                    txtError.setText("Invalid username or password");
            }
            }
        });
    }
    public static boolean isValidUsername(String username) {
        String usernameRegex = "^[a-zA-Z0-9]{5,15}$";
        Pattern pattern = Pattern.compile(usernameRegex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    public static boolean isValidPassword(String password) {String passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
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