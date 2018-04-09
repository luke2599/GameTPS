package com.progetto.amici.giochinotps;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PVPActivity extends AppCompatActivity {

    private String currentTurn = "1";
    private Boolean endGame = false;
    private int globalp1Score;
    private int globalp2Score;
    TextView player1;
    TextView player2;
    TextView resultView;
    TextView player1Score;
    TextView player2Score;
    TextView p1Score;
    TextView p2Score;
    String p1;
    String p2;
    int flag=0;
    double turn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            super.onRestoreInstanceState(savedInstanceState);
            p1=savedInstanceState.getString("player1");
            p2=savedInstanceState.getString("player2");
            globalp1Score = savedInstanceState.getInt("globalp1Score");
            globalp2Score = savedInstanceState.getInt("globalp2Score");
            currentTurn = savedInstanceState.getString("currentTurn");
            flag=savedInstanceState.getInt("flag");
            endGame=savedInstanceState.getBoolean("endGame");
            turn=savedInstanceState.getDouble("turn");


        }
        setContentView(R.layout.activity_pvpgame);

         player1Score = (TextView) findViewById(R.id.player1Score);
         player2Score = (TextView) findViewById(R.id.player2Score);

         player1 = (TextView) findViewById(R.id.player1View);
         player2 = (TextView) findViewById(R.id.player2View);

         resultView = (TextView) findViewById(R.id.resultView);

        if(flag==0) {
            Intent i = getIntent();
            p1 = i.getStringExtra("player1");
            p2 = i.getStringExtra("player2");

            globalp1Score = 0;
            globalp2Score = 0;
        }

        player1.setText(p1);
        player2.setText(p2);
        player1Score.setText(""+globalp1Score);
        player2Score.setText(""+globalp2Score);


        //Funzione random che decide chi inizia
        double turn = (int)(Math.random()*2);
        if(turn == 1) {
            currentTurn = "1";
            resultView.setText("Turno di " + p1);
        }else{
            currentTurn = "2";
            resultView.setText("Turno di " + p2);
        }


    }


    public void execute(View v){
        Button pressed = (Button) findViewById(v.getId());
        resultView = (TextView) findViewById(R.id.resultView);
         p1Score = (TextView) findViewById(R.id.player1Score);
         p2Score = (TextView) findViewById(R.id.player2Score);

        if(pressed.getText().toString() != "")
            return;
        if(endGame)
            return;

        if(currentTurn == "1")
            pressed.setText("O");
        else
            pressed.setText("X");

        String result = checkGrid();

        if(result != ""){
            endGame = true;
            if(result == "pari") {
                resultView.setText("Parita'");
                return;
            }
            else{
                resultView.setText("Vince " + result);
                if(currentTurn == "1") {
                    globalp1Score++;
                    p1Score.setText(""+globalp1Score);
                }else{
                    globalp2Score++;
                    p2Score.setText(""+globalp2Score);
                }
                return;
            }
        }

        currentTurn = (currentTurn == "1" ? "2" : "1");

        player1 = (TextView) findViewById(R.id.player1View);
        player2 = (TextView) findViewById(R.id.player2View);
        resultView.setText(currentTurn == "1" ? "Turno di " + player1.getText().toString() : "Turno di " + player2.getText().toString());
    }

    public String checkGrid(){
        Button ts = (Button) findViewById(R.id.ts);
        Button tc = (Button) findViewById(R.id.tc);
        Button tr = (Button) findViewById(R.id.tr);
        Button cs = (Button) findViewById(R.id.cs);
        Button cc = (Button) findViewById(R.id.cc);
        Button cr = (Button) findViewById(R.id.cr);
        Button bs = (Button) findViewById(R.id.bs);
        Button bc = (Button) findViewById(R.id.bc);
        Button br = (Button) findViewById(R.id.br);

        player1 = (TextView) findViewById(R.id.player1View);
        player2 = (TextView) findViewById(R.id.player2View);

        Boolean end = false;

        if((ts.getText().toString() == "O" && tc.getText().toString() == "O" && tr.getText().toString() == "O")){
            ts.setTextColor(Color.GREEN);
            tc.setTextColor(Color.GREEN);
            tr.setTextColor(Color.GREEN);
            end = true;
        }
        if(cs.getText().toString() == "O" && cc.getText().toString() == "O" && cr.getText().toString() == "O"){
            cs.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            cr.setTextColor(Color.GREEN);
            end = true;
        }
        if(bs.getText().toString() == "O" && bc.getText().toString() == "O" && br.getText().toString() == "O"){
            bs.setTextColor(Color.GREEN);
            bc.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(ts.getText().toString() == "O" && cs.getText().toString() == "O" && bs.getText().toString() == "O"){
            ts.setTextColor(Color.GREEN);
            cs.setTextColor(Color.GREEN);
            bs.setTextColor(Color.GREEN);
            end = true;
        }
        if(tc.getText().toString() == "O" && cc.getText().toString() == "O" && bc.getText().toString() == "O"){
            tc.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            bc.setTextColor(Color.GREEN);
            end = true;
        }
        if(tr.getText().toString() == "O" && cr.getText().toString() == "O" && br.getText().toString() == "O"){
            tr.setTextColor(Color.GREEN);
            cr.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(ts.getText().toString() == "O" && cc.getText().toString() == "O" && br.getText().toString() == "O"){
            ts.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(bs.getText().toString() == "O" && cc.getText().toString() == "O" && tr.getText().toString() == "O"){
            bs.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            tr.setTextColor(Color.GREEN);
            end = true;
        }
            
        if(end)
            return player1.getText().toString();

        if((ts.getText().toString() == "X" && tc.getText().toString() == "X" && tr.getText().toString() == "X")){
            ts.setTextColor(Color.GREEN);
            tc.setTextColor(Color.GREEN);
            tr.setTextColor(Color.GREEN);
            end = true;
        }
        if(cs.getText().toString() == "X" && cc.getText().toString() == "X" && cr.getText().toString() == "X"){
            cs.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            cr.setTextColor(Color.GREEN);
            end = true;
        }
        if(bs.getText().toString() == "X" && bc.getText().toString() == "X" && br.getText().toString() == "X"){
            bs.setTextColor(Color.GREEN);
            bc.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(ts.getText().toString() == "X" && cs.getText().toString() == "X" && bs.getText().toString() == "X"){
            ts.setTextColor(Color.GREEN);
            cs.setTextColor(Color.GREEN);
            bs.setTextColor(Color.GREEN);
            end = true;
        }
        if(tc.getText().toString() == "X" && cc.getText().toString() == "X" && bc.getText().toString() == "X"){
            tc.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            bc.setTextColor(Color.GREEN);
            end = true;
        }
        if(tr.getText().toString() == "X" && cr.getText().toString() == "X" && br.getText().toString() == "X"){
            tr.setTextColor(Color.GREEN);
            cr.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(ts.getText().toString() == "X" && cc.getText().toString() == "X" && br.getText().toString() == "X"){
            ts.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            br.setTextColor(Color.GREEN);
            end = true;
        }
        if(bs.getText().toString() == "X" && cc.getText().toString() == "X" && tr.getText().toString() == "X"){
            bs.setTextColor(Color.GREEN);
            cc.setTextColor(Color.GREEN);
            tr.setTextColor(Color.GREEN);
            end = true;
        }
        
        if(end)
            return player2.getText().toString();

        if(
            ts.getText().toString() != "" &&
            tc.getText().toString() != "" &&
            tr.getText().toString() != "" &&
            cs.getText().toString() != "" &&
            cc.getText().toString() != "" &&
            cr.getText().toString() != "" &&
            bs.getText().toString() != "" &&
            bc.getText().toString() != "" &&
            br.getText().toString() != ""
                )
            return "pari";
        return "";
    }

    public void resetGame(View v){
        endGame = false;

        player1 = (TextView) findViewById(R.id.player1View);
        player2 = (TextView) findViewById(R.id.player2View);
        resultView = (TextView) findViewById(R.id.resultView);

        turn = (int)(Math.random()*2);
        if(turn == 1) {
            currentTurn = "1";
            resultView.setText("Turno di " + player1.getText().toString());
        }else{
            currentTurn = "2";
            resultView.setText("Turno di " + player2.getText().toString());
        }

        Button ts = (Button) findViewById(R.id.ts);
        Button tc = (Button) findViewById(R.id.tc);
        Button tr = (Button) findViewById(R.id.tr);
        Button cs = (Button) findViewById(R.id.cs);
        Button cc = (Button) findViewById(R.id.cc);
        Button cr = (Button) findViewById(R.id.cr);
        Button bs = (Button) findViewById(R.id.bs);
        Button bc = (Button) findViewById(R.id.bc);
        Button br = (Button) findViewById(R.id.br);

        ts.setText("");
        tc.setText("");
        tr.setText("");
        cs.setText("");
        cc.setText("");
        cr.setText("");
        bs.setText("");
        bc.setText("");
        br.setText("");


        ts.setTextColor(Color.BLACK);
        tc.setTextColor(Color.BLACK);
        tr.setTextColor(Color.BLACK);
        cs.setTextColor(Color.BLACK);
        cc.setTextColor(Color.BLACK);
        cr.setTextColor(Color.BLACK);
        bs.setTextColor(Color.BLACK);
        bc.setTextColor(Color.BLACK);
        br.setTextColor(Color.BLACK);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("currentTurn", currentTurn);
        outState.putString("player1", p1);
        outState.putString("player2", p2);
        outState.putInt("globalp1Score", globalp1Score);
        outState.putInt("globalp2Score", globalp2Score);
        outState.putInt("flag", 1);
        outState.putDouble("turn", turn);
        outState.putBoolean("endGame", endGame);

    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        p1=savedInstanceState.getString("player1");
        p2=savedInstanceState.getString("player2");
        globalp1Score = savedInstanceState.getInt("globalp1Score");
        globalp2Score = savedInstanceState.getInt("globalp2Score");
        currentTurn = savedInstanceState.getString("currentTurn");
        flag=savedInstanceState.getInt("flag");
        endGame=savedInstanceState.getBoolean("endGame");
        turn=savedInstanceState.getDouble("turn");

        p1Score = (TextView) findViewById(R.id.player1Score);
        p2Score = (TextView) findViewById(R.id.player2Score);
        p1Score.setText(""+globalp1Score);
        p2Score.setText(""+globalp2Score);
    }
}
