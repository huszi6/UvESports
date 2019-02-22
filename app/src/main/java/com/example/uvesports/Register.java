package com.example.uvesports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Register extends AppCompatActivity {

    EditText etMail, etPassword;
    Button btnRegister, btnGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnGoToLogin = findViewById(R.id.btnGoToLogin);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etMail.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty())
                {
                    Toast.makeText(Register.this, "Please enter all details!", Toast.LENGTH_SHORT).show();
                }
                else {
                    String email = etMail.getText().toString().trim();
                    String password = etPassword.getText().toString().trim();

                    BackendlessUser user = new BackendlessUser();
                    user.setEmail(email);
                    user.setPassword(password);

                    Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
                        @Override
                        public void handleResponse(BackendlessUser response) {

                            Toast.makeText(Register.this, "User has been registered successfully!", Toast.LENGTH_SHORT).show();
                            Register.this.finish();

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(Register.this, "Error: " + fault.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });

        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });
    }
}
