package com.example.uvesports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class Login extends AppCompatActivity {

    private Button btn_login, btnGoToRegister;
    private EditText etMail, etPassword;
    private TextView tv_Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btnLogin);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
        tv_Reset = findViewById(R.id.tv_Reset);
        btnGoToRegister = findViewById(R.id.btnGoToRegister);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etMail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        Toast.makeText(Login.this, "Logged in successfully!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login.this,MainActivity.class));
                        Login.this.finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(Login.this, "Error: " + fault, Toast.LENGTH_SHORT).show();

                    }
                }, true);

            }
        });

        tv_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etMail.getText().toString().isEmpty()){
                    Toast.makeText(Login.this, "Please enter your email address in the email field!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String email = etMail.getText().toString().trim();

                    Backendless.UserService.restorePassword(email, new AsyncCallback<Void>() {
                        @Override
                        public void handleResponse(Void response) {
                            Toast.makeText(Login.this, "Reset instructions sent to email address!", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void handleFault(BackendlessFault fault) {
                            Toast.makeText(Login.this, "Error: " + fault, Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });

        btnGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

    }




}
