package com.example.taxmate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class regno_page extends AppCompatActivity {

    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regno_page);

        db = FirebaseFirestore.getInstance();

        Button b = (Button) findViewById(R.id.btn);

        EditText nameInput = findViewById(R.id.editTextTextPersonName1);
        EditText emailInput = findViewById(R.id.editTextTextEmailAddress1);
        EditText passwordInput = findViewById(R.id.editTextTextPassword1);
        EditText passwordConfirmInput = findViewById(R.id.editTextTextPassword);
        EditText mobileInput = findViewById(R.id.editTextPhone);
        EditText dobInput = findViewById(R.id.editTextDate1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = nameInput.getText().toString();
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();
                String passwordConfirm = passwordConfirmInput.getText().toString();
                String mobile = mobileInput.getText().toString();
                String dob = dobInput.getText().toString();

                if(name.isEmpty() || email.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty() || mobile.isEmpty() || dob.isEmpty()) {
                    Toast.makeText(regno_page.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!password.equals(passwordConfirm)) {
                    Toast.makeText(regno_page.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

                Map<String, Object> user = new HashMap<>();
                user.put("name", name);
                user.put("email", email);
                user.put("password", password);
                user.put("mobile", mobile);
                user.put("dob", dob);

                db.collection("users")
                        .add(user)
                        .addOnSuccessListener(documentReference -> {
                            Toast.makeText(regno_page.this, "Registered Successfully! Welcome!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(view.getContext(), homepage.class);
                            startActivity(intent);
                        })
                        .addOnFailureListener(e -> Toast.makeText(regno_page.this, "Error adding user", Toast.LENGTH_SHORT).show());
            }
        });
    }
}
