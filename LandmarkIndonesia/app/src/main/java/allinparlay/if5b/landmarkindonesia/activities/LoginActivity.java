package allinparlay.if5b.landmarkindonesia.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import allinparlay.if5b.landmarkindonesia.R;
import allinparlay.if5b.landmarkindonesia.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });

       binding.btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String username = binding.etUsername.getText().toString();
               String password = binding.etPassword.getText().toString();

               boolean bolehLogin = true;

               if (TextUtils.isEmpty(username)){
                   bolehLogin = false;
                   binding.etUsername.setError("Username Tidak Boleh Kosong !!");
               }
               if (TextUtils.isEmpty(password)){
                   bolehLogin = false;
                   binding.etPassword.setError("Password Tidak Boleh Kosong !!");
               }
               if (bolehLogin){
                   login(username, password);
               }

           }
       });
    }

    private void login(String username, String password) {
        showProgressBar();


    }

    private void showProgressBar() {binding.progressBar.setVisibility(View.VISIBLE);}
    private void hideProgressBar() {binding.progressBar.setVisibility(View.GONE);}
}