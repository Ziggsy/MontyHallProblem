package com.upgradedsoftware.android.montyhallproblem;

import java.util.Random;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class Calculate extends AppCompatActivity {

    private String variantsString;
    private Integer variants;
    private TextView mTextSwitch;
    private TextView mTextStay;
    private int switchWins = 0;
    private int stayWins = 0;

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = getIntent();
        variantsString = intent.getExtras().getString("NUMBER");
        variants = Integer.parseInt(variantsString);

        mTextSwitch = (TextView) findViewById(R.id.textSwitch);
        mTextStay = (TextView) findViewById(R.id.textStay);

        Random gen = new Random();
        for(int plays = 0; plays < variants ; plays++ ){
            int[] doors = {0,0,0}; //0 - коза, 1 - машина
            doors[gen.nextInt(3)] = 1;//выбираем побудную дверь
            int choice = gen.nextInt(3); //имитирум выбор двери игроком
            int shown;
            do shown = gen.nextInt(3); //Рандомим дверь которая не победная и не выбранная игроком
            while(doors[shown] == 1 || shown == choice);

            if (doors[choice] == 1) stayWins++; // если выбранная дверь игроком - победная (нужно было не менять)
            else switchWins++; // если выбранная дверь игроком - пустая (нужно было менять)
        }

        mTextStay.setText("Зритиель победит " + stayWins + " раз если не будет менять дверь");
        mTextSwitch.setText("Зритель победит " + switchWins + " раз если дверь поменяет");



    }
}
