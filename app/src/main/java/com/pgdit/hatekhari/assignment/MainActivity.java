package com.pgdit.hatekhari.assignment;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    String[] questions;
    int[][] answers;
    int queue[]=new int[6];
    int numberofquestioncomplete = 0;
    int answerlog[] = new int[5];
    int anscnt = 0;
    int correct_ans_count;
    int correct_answer[] = new int[10];
    String user_name;

    //function for generating unique number
    private int[] random_number_generator(){
        int question_list[] = new int[6];
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<10; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<6; i++) {
            question_list[i] = list.get(i);
        }
        return question_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questions= new String[] {"Which of these is a hazard waring line",
                "Which sign means 'no entry'?",
                "Which is the sign for a ring road ?",
                "Which of these signs means the end of a dual carriageway?",
                "Which sign means no motor vehicles are allowed?",
                "Traffic signs giving orders are generally which shape?",
                "Which of these signs means that the national speed limit applies?",
                "Which sign means ‘minimum speed’?",
                "Which sign means ‘crossroads’?",
                "Identify the logo of App Store of Windows"};

        answers= new int[][] {
                {R.drawable.hazard1, R.drawable.hazard2, R.drawable.hazard3, R.drawable.hazard4, R.drawable.hazard4},
                {R.drawable.noentry1, R.drawable.noentry2, R.drawable.noentry3, R.drawable.hazard4, R.drawable.noentry3},
                {R.drawable.ringroad1, R.drawable.ringroad2, R.drawable.ringroad3, R.drawable.ringroad4, R.drawable.ringroad3},
                {R.drawable.dualcarriageway1, R.drawable.dualcarriageway2, R.drawable.dualcarriageway3, R.drawable.dualcarriageway3, R.drawable.dualcarriageway4},
                {R.drawable.motorallowed1,R.drawable.motorallowed2, R.drawable.motorallowed3, R.drawable.motorallowed3, R.drawable.motorallowed4},
                {R.drawable.givingorders1,R.drawable.givingorders2, R.drawable.givingorders3, R.drawable.givingorders3, R.drawable.givingorders4},
                {R.drawable.speedlimit1, R.drawable.speedlimit2, R.drawable.speedlimit3, R.drawable.speedlimit4, R.drawable.speedlimit2},

                {R.drawable.minimumspeed1, R.drawable.minimumspeed2, R.drawable.minimumspeed3, R.drawable.minimumspeed4, R.drawable.minimumspeed4},
                {R.drawable.crossroads1, R.drawable.crossroads2, R.drawable.crossroads3, R.drawable.crossroads4, R.drawable.crossroads3},
                {R.drawable.black, R.drawable.appstore, R.drawable.windowsstore, R.drawable.crossroads3, R.drawable.windowsstore}

        };
        correct_answer[0] = 0;
        correct_answer[1] = 3;
        correct_answer[2] = 1;
        correct_answer[3] = 0;
        correct_answer[4] = 1;
        correct_answer[5] = 1;
        correct_answer[6] = 1;
        correct_answer[7] = 1;
        correct_answer[8] = 0;
        correct_answer[9] = 2;

        queue = random_number_generator();
        displayquestion();
    }

    public void displayquestion () {
        if(anscnt <=4) {
            TextView ques = (TextView) findViewById(R.id.lbl_question);
            ImageButton opt1 = (ImageButton) findViewById(R.id.option1);
            ImageButton opt2 = (ImageButton) findViewById(R.id.option2);
            ImageButton opt3 = (ImageButton) findViewById(R.id.option3);
            ImageButton opt4 = (ImageButton) findViewById(R.id.option4);

            ques.setText(questions[queue[numberofquestioncomplete]]);
            opt1.setImageResource(answers[queue[numberofquestioncomplete]][0]);
            opt2.setImageResource(answers[queue[numberofquestioncomplete]][1]);
            opt3.setImageResource(answers[queue[numberofquestioncomplete]][2]);
            opt4.setImageResource(answers[queue[numberofquestioncomplete]][3]);

            numberofquestioncomplete++;}
    }
    public void onClickCard(View view) {
        anscnt++;
        if (anscnt >= 5) {

            Intent i = getIntent();
            String user_name = i.getStringExtra("name");
            String email = i.getStringExtra("email");

            Intent intd = new Intent(getApplicationContext(), DisplayResult.class);
            intd.putExtra("user_name",user_name);
            intd.putExtra("email",email);
            intd.putExtra("total", Integer.toString(correct_ans_count));
            startActivity(intd);
            finish();
        }

        ImageButton opt1 = (ImageButton) findViewById(R.id.option1);
        ImageButton opt2 = (ImageButton) findViewById(R.id.option2);
        ImageButton opt3 = (ImageButton) findViewById(R.id.option3);
        ImageButton opt4 = (ImageButton) findViewById(R.id.option4);


        if (anscnt < 5) {
            if (opt1.isPressed() == true) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 0 )){ correct_ans_count++;}
                //ans
            }
            if (opt2.isPressed() == true) {
                if((correct_answer[queue[numberofquestioncomplete-1]] == 1)){ correct_ans_count++;}
                //anscnt++;

            }
            if (opt3.isPressed() == true) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 2){correct_ans_count++;}
                // anscnt++;
            }
            if (opt4.isPressed() == true) {
                if(correct_answer[queue[numberofquestioncomplete-1]] == 3){correct_ans_count++;}
                //anscnt++;
            }
        }
        if(anscnt < 5)
        {
            displayquestion();
        }

    }
}
