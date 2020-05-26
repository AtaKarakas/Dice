package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.Random;



public class guessActivity extends AppCompatActivity {

    private ImageView imageView;
    private EditText editTextGuess;
    private Button buttonGuess;
    private int randomNum;
    private int counter;

    public void timer(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        imageView = findViewById(R.id.imageViewDice);
        editTextGuess = findViewById(R.id.editTextGuess);
        buttonGuess = findViewById(R.id.buttonGuess);
        counter = 5;

        Random r = new Random();
        randomNum = r.nextInt(6)+1;
        Log.e("Random Number :",String.valueOf(randomNum));

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                {
                    imageView.setBackgroundResource(R.drawable.one);
                    timer();
                    imageView.setBackgroundResource(R.drawable.two);
                    timer();
                    imageView.setBackgroundResource(R.drawable.three);
                    timer();
                    imageView.setBackgroundResource(R.drawable.four);
                    timer();
                    imageView.setBackgroundResource(R.drawable.five);
                    timer();
                    imageView.setBackgroundResource(R.drawable.six);
                    timer();
                    imageView.setBackgroundResource(R.drawable.images);
                }

                counter = counter-1;
                int uGuess= Integer.parseInt(editTextGuess.getText().toString());

                if (uGuess == randomNum){
                    startActivity(new Intent(guessActivity.this,resultActivity.class));
                    finish();
                }else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Try Again!",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });
    }
}
