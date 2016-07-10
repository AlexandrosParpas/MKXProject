package com.example.alex.mkxproject;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SelectCharacter extends AppCompatActivity {

    final Context context = this;
    private ListView cs, mc;
    private ArrayList <String> myCharacters;
    private String [] characterList = {"Alien", "Bo Rai Cho", "Cassie Cage", "D'Vorah", "Ermac", "Erron Black", "Ferra Torr", "Goro", "Jacqui Briggs", "Jason", "Jax", "Johnny Cage", "Kenshi", "Kitana", "Kotal Kahn", "Leatherface", "Liu Kang", "Mileena", "Kano", "Kung Jin", "Kung Lao", "Predator", "Quan Chi", "Raiden", "Reptile", "Scorpion", "Shinnok", "Sonya Blade", "Sub Zero", "Takeda", "Tanya", "Tremor", "Triborg"};
    public String [] variations = new String[4];
    Dialog variationsDialog;
    ListView variationsList;
    ArrayAdapter<String> mcAdapter;
    ArrayAdapter<String> csAdapter;
    String selectedCharacter;
    String selectedVariation;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_character);
        cs = (ListView) findViewById(R.id.cs);
        mc = (ListView) findViewById(R.id.mc);

        myCharacters = new ArrayList<>();

        mcAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, myCharacters);
        csAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, characterList);
        mc.setAdapter(mcAdapter);
        cs.setAdapter(csAdapter);

        ListUtils.setDynamicHeight(cs);
        ListUtils.setDynamicHeight(mc);

        //Creating Variations Dialog
        variationsDialog = new Dialog(context);
        variationsDialog.setContentView(R.layout.variations_dialog);
        variationsDialog.setTitle("Select Variation");
        variationsList = (ListView) variationsDialog.findViewById(R.id.variations);
        variationsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, variations));

        cs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                selectedCharacter = (cs.getItemAtPosition(position).toString());
                getVariations(selectedCharacter);
                variationsDialog.show();
            }
        });

        variationsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedVariation = (variationsList.getItemAtPosition(position).toString());
                i = new Intent(getApplicationContext(), Character.class);
                i.putExtra("character", selectedCharacter);
                i.putExtra("variation", selectedVariation);
                variationsDialog.dismiss();
                startActivity(i);
            }
        });

    }

    public static class ListUtils {
        public static void setDynamicHeight(ListView mListView) {
            ListAdapter mListAdapter = mListView.getAdapter();
            if (mListAdapter == null) {
                return;
            }
            int height = 0;
            int desiredWidth = View.MeasureSpec.makeMeasureSpec(mListView.getWidth(), View.MeasureSpec.UNSPECIFIED);
            for (int i = 0; i < mListAdapter.getCount(); i++) {
                View listItem = mListAdapter.getView(i, null, mListView);
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                height += listItem.getMeasuredHeight();
            }
            ViewGroup.LayoutParams params = mListView.getLayoutParams();
            params.height = height + (mListView.getDividerHeight() * (mListAdapter.getCount() - 1));
            mListView.setLayoutParams(params);
            mListView.requestLayout();
        }
    }

    public void getVariations(String character){
        variations[0] = "Variationless";
        switch (character){
            case "Alien":
                variations[1] = "Tarkatan";
                variations[2] = "Acidic";
                variations[3] = "Konjurer";
                break;
            case "Bo Rai Cho":
                variations[1] = "Bartitsu";
                variations[2] = "Dragon Breath";
                variations[3] = "Drunken Master";
                break;
            case "Cassie Cage":
                variations[1] = "Spec Ops";
                variations[2] = "Hollywood";
                variations[3] = "Brawler";
                break;
            case "D'Vorah":
                variations[1] = "Venomous";
                variations[2] = "Brood Mother";
                variations[3] = "Swarm Queen";
                break;
            case "Ermac":
                variations[1] = "Spectral";
                variations[2] = "Mystic";
                variations[3] = "Master of Souls";
                break;
            case "Erron Black":
                variations[1] = "Marksman";
                variations[2] = "Gunslinger";
                variations[3] = "Outlaw";
                break;
            case "Ferra Torr":
                variations[1] = "Lackey";
                variations[2] = "Ruthless";
                variations[3] = "Vicious";
                break;
            case "Goro":
                variations[1] = "Tigrar Fury";
                variations[2] = "Kuatan Warrior";
                variations[3] = "Dragon Fangs";
                break;
            case "Jacqui Briggs":
                variations[1] = "High Tech";
                variations[2] = "Shotgun";
                variations[3] = "Full Auto";
                break;
            case "Jason":
                variations[1] = "Unstoppable";
                variations[2] = "Slasher";
                variations[3] = "Relentless";
                break;
            case "Jax":
                variations[1] = "Wrestler";
                variations[2] = "Heavy Weapons";
                variations[3] = "Pumped Up";
                break;
            case "Johnny Cage":
                variations[1] = "A-List";
                variations[2] = "Fisticuffs";
                variations[3] = "Stunt Double";
                break;
            case "Kenshi":
                variations[1] = "Kenjutsu";
                variations[2] = "Balanced";
                variations[3] = "Possessed";
                break;
            case "Kitana":
                variations[1] = "Mournful";
                variations[2] = "Royal Storm";
                variations[3] = "Assassin";
                break;
            case "Kotal Kahn":
                variations[1] = "Sun God";
                variations[2] = "Blood God";
                variations[3] = "War God";
                break;
            case "Leatherface":
                variations[1] = "Pretty Lady";
                variations[2] = "Killer";
                variations[3] = "Butcher";
                break;
            case "Liu Kang":
                variations[1] = "Dualist";
                variations[2] = "Flame Fist";
                variations[3] = "Dragon's Fire";
                break;
            case "Mileena":
                variations[1] = "Ravenous";
                variations[2] = "Piercing";
                variations[3] = "Ethereal";
                break;
            case "Kano":
                variations[1] = "Commando";
                variations[2] = "Cutthroat";
                variations[3] = "Cybernetic";
                break;
            case "Kung Jin":
                variations[1] = "Shaolin";
                variations[2] = "Ancestral";
                variations[3] = "Bojutsu";
                break;
            case "Kung Lao":
                variations[1] = "Hat Trick";
                variations[2] = "Tempest";
                variations[3] = "Buzz Saw";
                break;
            case "Predator":
                variations[1] = "Hish-Qu-Ten";
                variations[2] = "Warrior";
                variations[3] = "Hunter";
                break;
            case "Quan Chi":
                variations[1] = "Summoner";
                variations[2] = "Sorcerer";
                variations[3] = "Warlock";
                break;
            case "Raiden":
                variations[1] = "Master of Storms";
                variations[2] = "Thunder God";
                variations[3] = "Displacer";
                break;
            case "Reptile":
                variations[1] = "Noxious";
                variations[2] = "Deceptive";
                variations[3] = "Nimble";
                break;
            case "Scorpion":
                variations[1] = "Inferno";
                variations[2] = "Ninjutsu";
                variations[3] = "Hellfire";
                break;
            case "Shinnok":
                variations[1] = "Necromancer";
                variations[2] = "Impostor";
                variations[3] = "Bone Shaper";
                break;
            case "Sonya Blade":
                variations[1] = "Special Forces";
                variations[2] = "Covert Ops";
                variations[3] = "Demolition";
                break;
            case "Sub Zero":
                variations[1] = "Grandmaster";
                variations[2] = "Cryomancer";
                variations[3] = "Unbreakable";
                break;
            case "Takeda":
                variations[1] = "Ronin";
                variations[2] = "Shirai Ryu";
                variations[3] = "Lasher";
                break;
            case "Tanya":
                variations[1] = "Pyromancer";
                variations[2] = "Kobu Jutsu";
                variations[3] = "Dragon Naginata";
                break;
            case "Tremor":
                variations[1] = "Crystalline";
                variations[2] = "Aftershock";
                variations[3] = "Metallic";
                break;
            case "Triborg":
                variations[0] = "Cyber Sub Zero";
                variations[1] = "Smoke";
                variations[2] = "Sektor";
                variations[3] = "Cyrax";
                break;
        }
    }


}
