package com.example.phungmanhquan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.phungmanhquan.Database.AppDatabase;
import com.example.phungmanhquan.Database.User;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txName, txEmail, tvDes;
    Spinner spinner;
    Button btnSubmit;
    CheckBox ck;
    AppDatabase db;
    String gender = "Gripe";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db = AppDatabase.getAppDatabase(this);
        setContentView(R.layout.activity_main);
        txName = findViewById(R.id.txName);
        txEmail = findViewById(R.id.txEmail);
        tvDes = findViewById(R.id.tvDes);
        spinner = findViewById(R.id.spinner);
        btnSubmit = findViewById(R.id.btnSubmit);
        ck = findViewById(R.id.ck);

        String[] listGender = {"Gripe", "1", "2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,  android.R.layout.simple_spinner_item, listGender);
        spinner.setAdapter(adapter);
    }

    private void OnRegister(){
        if (txName.getText().toString().isEmpty()){
            Toast.makeText(this, "please enter name", Toast.LENGTH_LONG).show();
            return;
        }
        if (txEmail.getText().toString().isEmpty()){
            Toast.makeText(this, "please enter Email", Toast.LENGTH_LONG).show();
            return;
        }
        if (tvDes.getText().toString().isEmpty()){
            Toast.makeText(this, "please enter Description", Toast.LENGTH_LONG).show();
            return;
        }
        if (!ck.getText().toString().isEmpty()){
            Toast.makeText(this, "checkbox", Toast.LENGTH_LONG).show();

        }
        else {
            User user = new User();
            user.Name = txName.getText().toString();
            user.Email = txEmail.getText().toString();
            user.Gender = gender;
            user.Description = tvDes.getText().toString();
            db.userDAO().Insert(user);
        }
        Total();
    }

    private void Total(){
        User model = (User) db.userDAO().getUserAll();
        Toast.makeText(this, "this" +model.id, Toast.LENGTH_LONG).show();

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSubmit:
                OnRegister();
                break;
        }
    }
}