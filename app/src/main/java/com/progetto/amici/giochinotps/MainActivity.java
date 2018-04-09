package com.progetto.amici.giochinotps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button pvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pvp = (Button) findViewById(R.id.button_pvp);

        pvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this, PVPActivity.class);
                next.putExtra("player1", "Me");
                next.putExtra("player2", "Te");
                startActivity(next);
                startActivity(next);
            }
        });
    }
}
