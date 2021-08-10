package com.example.traveljournal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public EditText editTextUsername;
    public EditText editTextPassword;
    public Button button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextUsername = findViewById(R.id.username);
        editTextPassword = findViewById(R.id.password);
        button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(v -> validate(editTextUsername.getText().toString(), editTextPassword.getText().toString()));
    }

    private void validate(String username, String password) {
        if (!username.equals("") && !password.equals("")) {
            Intent intent = new Intent(LoginActivity.this, NavigationDrawer.class);
            intent.putExtra("Username", username);
            startActivity(intent);
        } else {
            button_login.setEnabled(false);
        }
    }
}