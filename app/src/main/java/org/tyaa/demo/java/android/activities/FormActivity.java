package org.tyaa.demo.java.android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    public static final String FEEDBACK_EXTRA = "feedback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        if (getIntent().hasExtra(MainActivity.MESSAGE_EXTRA)) {
            Toast.makeText(
                    FormActivity.this,
                    getIntent().getStringExtra(MainActivity.MESSAGE_EXTRA),
                    Toast.LENGTH_LONG
            ).show();
        }
        ((EditText)findViewById(R.id.formMessageEditText)).setOnKeyListener((v, keyCode, event) -> {
            Intent intent = new Intent();
            intent.putExtra(FEEDBACK_EXTRA, ((EditText)findViewById(R.id.formMessageEditText)).getText().toString());
            setResult(RESULT_OK, intent);
            return false;
        });
    }

    /* @Override
    protected void onDestroy() {
        System.out.println("MyDebug: FormActivity onDestroy Start");
        System.out.println(((EditText)findViewById(R.id.formMessageEditText)).getText());
        System.out.println("MyDebug: FormActivity onDestroy Finish");
        super.onDestroy();
    } */
}