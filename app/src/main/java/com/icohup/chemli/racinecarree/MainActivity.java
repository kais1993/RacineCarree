package com.icohup.chemli.racinecarree;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Props
    private Button bouton ;
    private EditText champsValeur ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Récupération du bouton de la vue
        bouton = (Button)findViewById(R.id.button);
        bouton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        champsValeur = (EditText)findViewById(R.id.number);
        //variable relatif au toast à afficher en cas d'erreur
        Context context = getApplicationContext();
        CharSequence text = null ;

        int duration = Toast.LENGTH_SHORT;
        try {
            int valeur = Integer.parseInt(champsValeur.getText().toString());
            boolean valide = ((valeur <5)||(valeur > 100)) ? false : true ;
            if(!valide) {
                text = "Veuillez saisir un entier entre 5 et 100 ! ";
                Toast.makeText(context, text, duration).show();

            }
            else {
                //Obtention du racine carre
                text = this.racineCarre(valeur);
                Toast.makeText(context, text, duration).show();
                //Affichage du La racine dans le Log de type info
                Log.i("Excecution: ", " La valeur de la racine carree est " + text);
            }
        }
        catch (Exception e){

             //cas de sasie d'une valeur non entière
            text = "Veuillez saisir un entier ! ";
            Toast.makeText(context, text, duration).show();

        }

    }

    private String racineCarre(int valeur){

        double racine = Math.sqrt(valeur);
        NumberFormat formatter = new DecimalFormat("#0.000");
        return formatter.format(racine) ;
    }
}
