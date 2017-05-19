package com.nabeel.auxilio;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText txtEmailAddress;
    private EditText txtPassword;
    private EditText txtCPassword;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txtEmailAddress = (EditText) findViewById(R.id.emailEditText);
        txtPassword = (EditText) findViewById(R.id.pwdEditText);
        txtCPassword = (EditText) findViewById(R.id.cpwdEditText);
        mAuth = FirebaseAuth.getInstance();
    }
    public void signuponClick(View v) {

        final ProgressDialog progressDialog = ProgressDialog.show(SignUp.this, "Please wait...", "Processing...", true);
        (mAuth.createUserWithEmailAndPassword(txtEmailAddress.getText().toString(), txtPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()) {
                            Toast.makeText(SignUp.this, "Registration successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(SignUp.this, MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
