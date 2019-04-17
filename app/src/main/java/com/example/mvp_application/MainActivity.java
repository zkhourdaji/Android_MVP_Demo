package com.example.mvp_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SayHelloContract.View, View.OnClickListener {

    private SayHelloContract.Presenter mPresnter;

    private TextView mMessageView;
    private TextView mFirstNameView;
    private TextView mLastNameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_screen);
        intitViews();
        mPresnter = new SayHelloPresenter(this);
    }

    private void intitViews() {
        mMessageView = findViewById(R.id.message);
        mFirstNameView = findViewById(R.id.firstName);
        mLastNameView = findViewById(R.id.lastName);

        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.showMessage).setOnClickListener(this);
    }


    @Override
    public void showMessage(String message) {
        mMessageView.setText(message);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.update:
                mPresnter.saveName(mFirstNameView.getText().toString(), mLastNameView.getText().toString());
                break;
            case R.id.showMessage:
                mPresnter.loadMessage();
                break;
        }
    }
}
