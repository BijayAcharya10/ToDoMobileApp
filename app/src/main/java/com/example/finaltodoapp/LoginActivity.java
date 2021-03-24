package com.example.finaltodoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaltodoapp.helpers.DatabaseHelper;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private final AppCompatActivity activity = LoginActivity.this;
    private NestedScrollView nestedScrollView;
    private TextView txtSignUp;
    private EditText txtUsername;
    private EditText txtPassword;
    private Button btnLogin;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      //  getSupportActionBar().hide();
        initViews();
        initListeners();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews(){
        txtSignUp = (TextView) findViewById(R.id.txtsignup);
        txtUsername = (EditText) findViewById(R.id.inputUsername);
        txtPassword = (EditText) findViewById(R.id.inputPassword);
        btnLogin = (Button) findViewById(R.id.btnSignup);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btnLogin.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
//        inputValidation = new InputValidation(activity);
    }


    /**
     * This implemented method is to listen the click on view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignup:
                verifyFromSQLite();
                break;
            case R.id.txtsignup:
                // Navigate to RegisterActivity
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
 //             finish();
                break;
        }
    }


    /**
     * This method is to validate the input text fields and verify login credentials from SQLite
     */
    private void verifyFromSQLite() {
        if (databaseHelper.checkUser(txtUsername.getText().toString().trim()
                , txtPassword.getText().toString().trim())) {
            Intent accountsIntent = new Intent(activity, MainActivity.class);
            accountsIntent.putExtra("EMAIL", txtUsername.getText().toString().trim());
            emptyInputEditText();
            startActivity(accountsIntent);
        } else {
            // Snack Bar to show success message that record is wrong
            Toast.makeText(this, "Cant login", Toast.LENGTH_SHORT).show();
//            Snackbar.make(nestedScrollView, getString(R.string.error_valid_username_password), Snackbar.LENGTH_LONG).show();
        }
    }
    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        txtUsername.setText(null);
        txtPassword.setText(null);
    }
}