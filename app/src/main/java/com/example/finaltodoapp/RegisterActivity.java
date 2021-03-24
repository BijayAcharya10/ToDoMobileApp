package com.example.finaltodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finaltodoapp.helpers.DatabaseHelper;
import com.example.finaltodoapp.model.User;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
        private TextView txtLogin;
        private EditText txtEmail;
        private EditText txtPassword;
        private EditText txtUsername;
        private EditText txtConfirmPassword;
        private Button btnSignup;
        private DatabaseHelper databaseHelper;
        private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initViews();
        initListeners();
        initObjects();



//        txtLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        txtLogin = (TextView) findViewById(R.id.txtlogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        txtEmail = (EditText) findViewById(R.id.inputEmail);
        txtUsername = (EditText) findViewById(R.id.inputUsername);
        txtPassword = (EditText) findViewById(R.id.inputPassword);
        txtConfirmPassword = (EditText) findViewById(R.id.inputConfirmPassword);
    }

    /**
     * This method is to initialize listeners
     */
    private void initListeners() {
        btnSignup.setOnClickListener(this);
        txtLogin.setOnClickListener(this);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        //inputValidation = new InputValidation(activity);
        databaseHelper = new DatabaseHelper(RegisterActivity.this);
        user = new User();
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
                postDataToSQLite();
                break;
            case R.id.txtlogin:
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    /**
     * This method is to validate the input text fields and post data to SQLite
     */
    private void postDataToSQLite() {
        if (!databaseHelper.checkUser(txtEmail.getText().toString().trim())) {
            user.setUsername(txtUsername.getText().toString().trim());
            user.setEmail(txtEmail.getText().toString().trim());
            user.setPassword(txtPassword.getText().toString().trim());
            databaseHelper.addUser(user);
            // Snack Bar to show success message that record saved successfully
           // Snackbar.make(nestedScrollView, getString(R.string.success_message), Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, "Record Saved Successfully", Toast.LENGTH_SHORT).show();
            emptyInputEditText();
        } else {
            // Snack Bar to show error message that record already exists
           // Snackbar.make(nestedScrollView, getString(R.string.error_email_exists), Snackbar.LENGTH_LONG).show();
            Toast.makeText(this, "User Already Exists", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method is to empty all input edit text
     */
    private void emptyInputEditText() {
        txtUsername.setText(null);
        txtEmail.setText(null);
        txtPassword.setText(null);
        txtConfirmPassword.setText(null);
    }

}