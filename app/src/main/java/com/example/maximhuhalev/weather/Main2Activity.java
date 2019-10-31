package com.example.maximhuhalev.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.*[@#$%^&+=])" +
                    "(?=\\S+$)" +
                    ".{4,}" +
                    "$");

    private EditText textInputUsername;
    private EditText textInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textInputUsername = findViewById(R.id.username);
        textInputPassword = findViewById(R.id.password);
    }

    private boolean validateUsername() {
        String usernameInput = textInputUsername.getText().toString().trim();

        if (usernameInput.isEmpty()) {
            textInputUsername.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            textInputUsername.setError("Username too long");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = textInputPassword.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Password too weak");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if (!validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Username: " + textInputUsername.getText().toString();
        input += "\n";
        input += "Password: " + textInputPassword.getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(intent);
    }

}
