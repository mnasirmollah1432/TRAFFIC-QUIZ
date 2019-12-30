package com.pgdit.hatekhari.assignment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


public class DisplayResult extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finallayout);

        TextView your_name = findViewById(R.id.lastd);
        TextView your_score = findViewById(R.id.score);

        Intent mint = getIntent();

        String value =  mint.getStringExtra("total");
        String email = mint.getStringExtra("email");
        String s = mint.getStringExtra("user_name");

        your_name.setText(s);
        your_score.setText("Your Total Score is: \n" + value);
        //Log.d("last",s);

        findViewById(R.id.text_view_retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DisplayResult.this, MainActivity.class));
                finish();
            }
        });

        sendEmail(email, s, value);
    }

    private void sendEmail(String email, String name, String result) {
        String subject = "Quiz Result";
        String message = "Congratulation " + name + " , your quiz result is " + result;

        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.execute();
    }
}
