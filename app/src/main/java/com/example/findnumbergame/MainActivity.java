package com.example.findnumbergame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtGuess;
    private TextView lblOutput;
    private TextView lblOutputResult;
    private TextView lblOutputResultWin;
    private TextView lblOutputResultLos;
    private int theNumber;
    private int numberOfTries;
    TreeSet<Integer> numberOfTriesResult = new TreeSet<>();

    public void newGame() {
        theNumber = (int) (Math.random() * 100 + 1);
        numberOfTries = 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtGuess = findViewById(R.id.txtGuess);

        lblOutput = findViewById(R.id.lblOutput);
        lblOutputResult = findViewById(R.id.lblOutputResult);
        lblOutputResultWin = findViewById(R.id.lblOutputResultWin);
        lblOutputResultLos = findViewById(R.id.lblOutputResultLos);
        Button btnResult = findViewById(R.id.btnGuess);
        btnResult.setOnClickListener(this);

        newGame();
    }

    @Override
    public void onClick(View view) {
        lblOutputResultWin.setVisibility(View.INVISIBLE);
        lblOutputResultLos.setVisibility(View.INVISIBLE);

        String guessText = txtGuess.getText().toString();
        String message = "";
        try {
            int guess = Integer.parseInt(guessText);

            if (guess > 100 || guess < 1)
                message = "Введите число между 1 и 100 \n Совершено попыток: " + numberOfTries;
            else if (guess < theNumber) {
                ++numberOfTries;
                message = guess + " Слишком мало. Попробуй еще.\n Совершено попыток: " + numberOfTries;
            }
            else if (guess > theNumber) {
                ++numberOfTries;
                message = guess + " Слишком много. Попробуй еще.\n Совершено попыток: " + numberOfTries;
            }
            else {
                message = guess +
                        " В самый раз. Потребовалось " + numberOfTries + " попыток!";
                Toast.makeText(MainActivity.this, message,
                        Toast.LENGTH_LONG).show();

                numberOfTriesResult.add(numberOfTries);
                lblOutputResult.setText("Лучший результат: " + numberOfTriesResult.first() + " попыток");

                if (numberOfTries < 8) {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    int gameWon = sharedPreferences.getInt("gameWon", 0) + 1;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("gameWon", gameWon);
                    editor.apply();

                    lblOutputResultWin.setVisibility(View.VISIBLE);
                    lblOutputResultWin.setText("Всего выйгранных игр: " + sharedPreferences.getInt("gameWon", 0));
                    newGame();
                } else {
                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                    int gameWon = sharedPreferences.getInt("gameLos", 0) + 1;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("gameLos", gameWon);
                    editor.apply();

                    lblOutputResultLos.setVisibility(View.VISIBLE);
                    lblOutputResultLos.setText("Всего проигранных игр: " + sharedPreferences.getInt("gameLos", 0));
                    newGame();
                }

            }
        } catch (Exception e) {
            message = "Введите число между 1 и 100 \n Совершено попыток: " + numberOfTries;
        } finally {
            lblOutput.setText(message);
            txtGuess.requestFocus();
            txtGuess.selectAll();
        }
    }
}
