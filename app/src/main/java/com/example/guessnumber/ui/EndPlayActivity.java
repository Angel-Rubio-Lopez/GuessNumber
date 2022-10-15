package com.example.guessnumber.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.data.Game;
import com.example.guessnumber.databinding.ActivityEndPlayBinding;

/**
 * <h1>Proyecto GuessNumber</h1>
 * Este proyecto consiste en lo siguiente:
 * Introducimos nuesto nombre de usuario y un numero de intentos predeterminado, y mediante un boton pasamos a la siguiente actividad de nuestro juego
 * En esta segunda actividad debemos, mediante un edittext introducir numeros hasta intentar adivinar el numero secreto
 * En caso de que acertemos antes de que se nos acaben los intentos, o gastemos todos los intentos pasaremos a la tercera y ultima pantalla
 * En esta se muestran mensajes informativos como tu nombre de usuario, si has ganado o perdido o el número secreto en el caso de que hayas perdido
 *
 * Esta activity recoge todos los datos y los muestra por pantalla segun si has ganado o has perdido
 *
 * @author Angel Rubio
 * @version 1.0
 */

public class EndPlayActivity extends AppCompatActivity {

    private ActivityEndPlayBinding binding;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       binding = ActivityEndPlayBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        game = bundle.getParcelable("game");

        EndGame();
    }

    protected void EndGame(){
        if (game.getWinOrLose() == 0){
            binding.tvWinOrLose.setText("Oh no " + game.getName() + " has perdido :( ");
            binding.tvNumberOfAttempts.setText(String.valueOf("Has hecho un total de " + game.getNumberOfAttempts() + " intentos"));
            binding.tvNumber.setText(String.valueOf("El número era el " + game.getRandomNumber()));
        } else{
            binding.tvWinOrLose.setText("Felicidades " + game.getName() + " has ganado :) ");
            binding.tvNumberOfAttempts.setText("Has hecho un total de " + game.getNumberOfAttempts() + " intentos");
        }
    }
}
