package allin.if5b.landindo.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import allin.if5b.landindo.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        progressDialog = new ProgressDialog(this);


        binding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = binding.etUsername.getText().toString();
                String email = binding.etEmail.getText().toString();
                String nomortelepon = binding.etNomortelpon.getText().toString();
                String password = binding.etPassword.getText().toString();

                boolean bolehRegister = true;
                if (TextUtils.isEmpty(username)){
                    bolehRegister = false;
                    binding.etUsername.setError("Username Tidak Boleh Kosong !!");
                }
                if (TextUtils.isEmpty(email)){
                    bolehRegister = false;
                    binding.etEmail.setError("Email Tidak Boleh Kosong !!");
                }
                if (TextUtils.isEmpty(nomortelepon)){
                    bolehRegister = false;
                    binding.etNomortelpon.setError("Nomor Telpon Tidak Boleh Kosong !!");
                }
                if (!password.equals(password)){
                    bolehRegister = false;
                    binding.etPassword.setError("Password Tidak Boleh Kosong !!");
                }
                if (password.length()<6){
                    bolehRegister = false;
                    binding.etPassword.setError("Password Minimal 6 karakter !!");
                }

                else {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    firebaseFirestore.collection("datauser")
                                            .document(FirebaseAuth.getInstance().getUid())
                                            .set(new UserModels(username, email, nomortelepon));
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(RegisterActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
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