package allin.if5b.landindo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import allin.if5b.landindo.Service.Utilities;
import allin.if5b.landindo.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    public static final String TAG = "AllInParlay";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

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
                String email = binding.etEmail.getText().toString();
                String password = binding.etPassword.getText().toString();

                boolean bolehLogin = true;

                if (TextUtils.isEmpty(email)){
                    bolehLogin = false;
                    binding.etEmail.setError("Email Tidak Boleh Kosong !!");
                }
                if (TextUtils.isEmpty(password)){
                    bolehLogin = false;
                    binding.etPassword.setError("Password Tidak Boleh Kosong !!");
                }
                else {
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                   progressDialog.cancel();
                                    Toast.makeText(LoginActivity.this, "Login Berhasil", Toast.LENGTH_SHORT).show();
                                    String email = firebaseAuth.getCurrentUser().getEmail();
                                    Utilities.setValue(LoginActivity.this, "xEmail", email);
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    progressDialog.cancel();
                                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
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