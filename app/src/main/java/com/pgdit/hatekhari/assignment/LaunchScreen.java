package com.pgdit.hatekhari.assignment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LaunchScreen extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);
    }

    public void onStartClicked(View view) {
        final EditText name = findViewById(R.id.txtname);
        EditText email = findViewById(R.id.txtemail);

        if(name.length() == 0 || TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(getApplicationContext(),"Please provide both name and email address.",
                    Toast.LENGTH_LONG).show();
        } else {
            Intent intd = new Intent(getApplicationContext(), MainActivity.class);
            intd.putExtra("name", name.getText().toString());
            intd.putExtra("email", email.getText().toString());
            startActivity(intd);
        }
    }

}
