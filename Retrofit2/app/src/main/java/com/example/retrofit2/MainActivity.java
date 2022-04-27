package com.example.retrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etEmail;
    Button btnCreate;
    Button btnSearch;
    Button btnDelete;
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();
        btnCreate = findViewById(R.id.createButton);
        btnSearch = findViewById(R.id.searchButton);
        btnDelete = findViewById(R.id.deleteButton);
        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewUser();
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUser();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteUser();
            }
        });
    }

    private void createNewUser() {
        String name = etName.getText().toString();
        String email = etEmail.getText().toString();
        User user = new User("", name, email, "Active", "Male");
        viewModel.createNewUser(user);
    }

    private void getUser() {
        String id = etName.getText().toString();
        viewModel.getUser(id);
    }

    private void deleteUser() {
        String id = etName.getText().toString();
        viewModel.deleteUser(id);
    }


    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.getCreateUserObserver().observe(this, new Observer<UserResponse>() {
            @Override
            public void onChanged(UserResponse userResponse) {
                if (userResponse == null) {
                    Toast.makeText(MainActivity.this, "failed to create new user", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "Successfully created new user", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}