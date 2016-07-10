package com.example.alex.mkxproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;

public class Character extends AppCompatActivity {

    String character;
    String variation;
    TextView textView;
    ImageButton addCharacter;
    boolean added = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
        textView = (TextView) findViewById(R.id.textView);
        addCharacter = (ImageButton)findViewById(R.id.add_character);

        //Retrieve information from the SelectCharacter activity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            character = extras.getString("character");
            variation = extras.getString("variation");
        }
        textView.setText("Character: " + character + "\nVariation: " + variation);

        //Handle Click Listeners
        addCharacter.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(added){
                            added = false;
                            Toast.makeText(getApplicationContext(), "Removed from my characters.", Toast.LENGTH_SHORT).show();
                            addCharacter.setBackgroundResource(R.drawable.ic_add_black_24dp);
                        }
                        else{
                            added = true;
                            Toast.makeText(getApplicationContext(), "Added to my characters.", Toast.LENGTH_SHORT).show();
                            addCharacter.setBackgroundResource(R.drawable.ic_remove_black_24dp);
                        }
                    }
                }
        );
    }
    //TODO
    @Override
    public void onBackPressed() {
//        Intent i = new Intent(this, SelectCharacter.class);
//        i.putExtras("isAdded", added);
//
//        super.onBackPressed();
    }
}
