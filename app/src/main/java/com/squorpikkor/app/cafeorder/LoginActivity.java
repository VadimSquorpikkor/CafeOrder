package com.squorpikkor.app.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public static final String PASSWORD = "password";
    public static final String USER_NAME = "user_name";
    TextView passwordText;
    TextView nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordText = findViewById(R.id.password_text);
        nameText = findViewById(R.id.name_text);

        findViewById(R.id.open_order).setOnClickListener(view -> {
            String pass = passwordText.getText().toString().trim();
            String name = nameText.getText().toString().trim();
            if (!pass.isEmpty() && !name.isEmpty()) {
                Intent intent = new Intent(this, SetOrderActivity.class);
                intent.putExtra(PASSWORD, pass);
                intent.putExtra(USER_NAME, name);
                startActivity(intent);
            } else {
                Toast.makeText(this, R.string.enter_data, Toast.LENGTH_SHORT).show();
            }
        });
    }

}