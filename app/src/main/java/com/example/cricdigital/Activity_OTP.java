package com.example.cricdigital;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cricdigital.databinding.ActivityMainBinding;
import com.example.cricdigital.databinding.ActivityOtpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Activity_OTP extends AppCompatActivity {



    public ActivityOtpBinding binding;
    private FirebaseAuth mAuth;
    private String verificationId;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private boolean sendVerificationCode=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityOtpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth=FirebaseAuth.getInstance();




        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                {

                    if (binding.etOtp.getText().toString().trim().isEmpty()) {
                        binding.etOtp.setError("Empty OTP");
                        Toast.makeText(Activity_OTP.this, "Empty OTP", Toast.LENGTH_SHORT).show();
                    }
                    else if (binding.etOtp.getText().toString().trim().length() !=6) {
                        Toast.makeText(Activity_OTP.this, "OTP is not Valid", Toast.LENGTH_SHORT).show();
                    }else {
                     //  verifyCode(binding.etOtp.getText().toString());
                        Toast.makeText(Activity_OTP.this, "OTP Confirm", Toast.LENGTH_SHORT).show();
                        String number = binding.etPhone.getText().toString().trim();
                        startActivity(new Intent(Activity_OTP.this,MainActivity.class));
                        binding.etPhone.setText(number);
                        finish();
                    }

                }


            }
        });







        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                    if(binding.etPhone.getText().toString().trim().isEmpty()){
                        Toast.makeText(Activity_OTP.this, "Empty Phone Number", Toast.LENGTH_SHORT).show();
                    }else if(binding.etPhone.getText().toString().trim().length() !=11 ){
                        Toast.makeText(Activity_OTP.this, "Type Valid Phone Number", Toast.LENGTH_SHORT).show();
                    }else {

//                        String phone =  binding.etPhone.getText().toString();
//                        phone="+92"+phone.substring(1);
//                        sendVerificationCode(phone);




                        binding.etOtpEnter.setVisibility(View.VISIBLE);
                        binding.btnContinue.setVisibility(View.VISIBLE);
                        binding.btnNext.setVisibility(View.GONE);

                        Toast.makeText(Activity_OTP.this, "otp send on your number", Toast.LENGTH_SHORT).show();
                    }









            }
        });

    }


    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Intent i = new Intent(Activity_OTP.this, MainActivity.class);
                            startActivity(i);
                            finish();
                        } else {
                            Toast.makeText(Activity_OTP.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }





    private void sendVerificationCode(String number) {
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(mAuth)
                .setPhoneNumber(number)            // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            final String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                binding.etOtp.setText(code);
                verifyCode(code);
            }
        }
        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Activity_OTP.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };
    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);





    }

}