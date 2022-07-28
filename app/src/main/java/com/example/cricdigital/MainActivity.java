package com.example.cricdigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.cricdigital.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {


    public ActivityMainBinding binding;
//    private FirebaseAuth mAuth;
//    private String verificationId;
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//    private boolean codeSend=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


      //  mAuth = FirebaseAuth.getInstance();


//        binding.btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                if(!codeSend){
//
//                    if(binding.etPhone.getText().toString().trim().isEmpty()){
//                        Toast.makeText(MainActivity.this, "Empty Phone Number", Toast.LENGTH_SHORT).show();
//                    }else if(binding.etPhone.getText().toString().trim().length() !=10 ){
//                        Toast.makeText(MainActivity.this, "Type Valid Phone Number", Toast.LENGTH_SHORT).show();
//                    }else {
//
//                        String phone = "+92" + binding.etPhone.getText().toString();
//                        sendVerificationCode(phone);
//
//
//
//
//                        binding.etOtpEnter.setVisibility(View.VISIBLE);
//
//                        binding.btnNext.setText("Continue");
//                        Toast.makeText(MainActivity.this, "otp send on your number", Toast.LENGTH_SHORT).show();
//                    }
//
//
//
//                }
//                else
//                {
//
//                    if (binding.etOtp.getText().toString().trim().isEmpty()) {
//                        binding.etOtp.setError("Empty OTP");
//                        Toast.makeText(MainActivity.this, "Empty OTP", Toast.LENGTH_SHORT).show();
//                    }
//                    else if (binding.etOtp.getText().toString().trim().length() !=6) {
//                        Toast.makeText(MainActivity.this, "OTP is not Valid", Toast.LENGTH_SHORT).show();
//                    }else {
//                        verifyCode(binding.etOtp.getText().toString());
//                        Toast.makeText(MainActivity.this, "OTP Confirm", Toast.LENGTH_SHORT).show();
//                        String number = binding.etPhone.getText().toString().trim();
//                        binding.etPhone.setText(number);
//                    }
//
//                }
//
//
//
//
//
//            }
//        });
//
//    }
//
//
//    private void signInWithCredential(PhoneAuthCredential credential) {
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Intent i = new Intent(MainActivity.this, MainActivity.class);
//                            startActivity(i);
//                            finish();
//                        } else {
//                            Toast.makeText(MainActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
//
//
//
//
//
//    private void sendVerificationCode(String number) {
//        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
//                .setPhoneNumber(number)            // Phone number to verify
//                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                .setActivity(this)                 // Activity (for callback binding)
//                .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
//                .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
//            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
//            verificationId = s;
//        }
//
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//            final String code = phoneAuthCredential.getSmsCode();
//
//            if (code != null) {
//                binding.etOtp.setText(code);
//                verifyCode(code);
//            }
//        }
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//    };
//    private void verifyCode(String code) {
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//        signInWithCredential(credential);
//
//
//
//
//
//    }

    }

}