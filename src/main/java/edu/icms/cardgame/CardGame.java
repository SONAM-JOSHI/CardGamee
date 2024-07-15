package edu.icms.cardgame;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CardGame extends AppCompatActivity {
    //init
    ImageView blackCardImage, redCardImage;
    Button playBtn;
    TextView msgText;

    int blackCardNumber, redCardNumber;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_card_game);

        //assocation with xml
        blackCardImage = findViewById(R.id.blackCard);
        redCardImage = findViewById(R.id.redCard);
        playBtn = findViewById(R.id.playBtn);
        msgText = findViewById(R.id.msgText);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blackCardNumber =   randomCard();
                redCardNumber = randomCard();
                flipCard(redCardNumber,blackCardNumber);
                checkWin();


            }
        });

    }

    int randomCard(){
        Random random = new Random();
        int randomNum = random.nextInt(13)+1;
        return randomNum;

    }


    void flipCard(int redCard, int blackCard){
        int resourceBlack = getResources().getIdentifier("black"+redCard, "drawable", getPackageName());
        blackCardImage.setImageResource(resourceBlack);

        int resourceRed = getResources().getIdentifier("red"+blackCard, "drawable", getPackageName());
        redCardImage.setImageResource(resourceRed);

    }

    ///


    void checkWin(){
        String result = "";
        if(redCardNumber==blackCardNumber){
            result = "Draw!";
        }

        else if(redCardNumber==1 && blackCardNumber!=1){
            result = "Red Wins!";
        }

        else if(blackCardNumber==1 && redCardNumber!=1){
            result = "Black Wins!";
        }
        else if(redCardNumber> blackCardNumber){
            result = "Red Wins!";
        }


        else if(blackCardNumber>redCardNumber) {
            result = "Black Wins!";
        }

        else {
            result="";
        }

        msgText.setText(result);
    }

    void reset(){

        flipCard(0,0);
        msgText.setText("");
        blackCardNumber = 0;
        redCardNumber = 0;
    }

}