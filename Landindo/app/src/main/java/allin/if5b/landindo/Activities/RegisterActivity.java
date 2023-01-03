package allin.if5b.landindo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import allin.if5b.landindo.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String password = binding.etPassword.getText().toString();
                String konfirmasiPassword = binding.etKonfirmasiPassword.getText().toString();

                boolean bolehRegister = true;
                if (TextUtils.isEmpty(username)){
                    bolehRegister = false;
                    binding.etUsername.setError("Username Tidak Boleh Kosong !!");
                }
                if (TextUtils.isEmpty(password)){
                    bolehRegister = false;
                    binding.etPassword.setError("Password Tidak Boleh Kosong !!");
                }
                if (TextUtils.isEmpty(konfirmasiPassword)){
                    bolehRegister = false;
                    binding.etKonfirmasiPassword.setError("Konfirmasi Password Tidak Boleh Kosong !!");
                }
                if (!password.equals(konfirmasiPassword)){
                    bolehRegister = false;
                    binding.etPassword.setError("Password Harus Sama !!");
                }
                if (password.length()<6){
                    bolehRegister = false;
                    binding.etPassword.setError("Password Minimal 6 karakter !!");
                }

                if (bolehRegister){
                    register(username, password);
                }
            }
        });

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void register(String username, String password) {
    }
}