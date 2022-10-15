package com.example.guessnumber.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.guessnumber.data.Game;
import com.example.guessnumber.databinding.ActivityPlayBinding;

import java.util.Random;

/**
 * <h1>Proyecto GuessNumber</h1>
 * Este proyecto consiste en lo siguiente:
 * Introducimos nuesto nombre de usuario y un numero de intentos predeterminado, y mediante un boton pasamos a la siguiente actividad de nuestro juego
 * En esta segunda actividad debemos, mediante un edittext introducir numeros hasta intentar adivinar el numero secreto
 * En caso de que acertemos antes de que se nos acaben los intentos, o gastemos todos los intentos pasaremos a la tercera y ultima pantalla
 * En esta se muestran mensajes informativos como tu nombre de usuario, si has ganado o perdido o el número secreto en el caso de que hayas perdido
 *
 * Esta activity es la principal del juego, en ella debemos intentar adivinar el numero secreto, en el numero de intentos que pusimos en la activity anterior
 * contamos con un edittext para poner el numero, un textview para informarte si el numero secreto es mayor o menor que el introducido, un boton para comprobar
 * y otro boton para reiniciar
 *
 * @author Angel Rubio
 * @version 1.0
 */

public class PlayActivity extends AppCompatActivity {

    private ActivityPlayBinding binding;
    private Game game;
    private int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btPlay.setOnClickListener(view -> Play());
        binding.btRetry.setOnClickListener(view -> Delete());

        Bundle bundle = getIntent().getExtras();
        game = bundle.getParcelable("game");

        GetRandomNumber();

        binding.btRetry.setEnabled(false);

        //Toast.makeText(this, String.valueOf(randomNumber), Toast.LENGTH_SHORT).show();
    }

    protected void Play(){
        if (TextUtils.isEmpty((binding.etNumber.getText().toString())))
            return;
        else
            PlayMethod();
    }

    protected void PlayMethod() {
        if (game.getAttempts() <= game.getNumberOfAttempts()) {
            game.setRandomNumber(randomNumber);
            game.setWinOrLose(0);
            EndActivity();
        }
        if (Integer.parseInt(binding.etNumber.getText().toString()) > randomNumber) {
            game.Increment();
            binding.tvHighOrLow.setText("El numero buscado es menor");
            binding.btPlay.setEnabled(false);
            binding.btRetry.setEnabled(true);

        } else if (Integer.parseInt(binding.etNumber.getText().toString()) < randomNumber) {
            game.Increment();
            binding.tvHighOrLow.setText("El numero buscado es mayor");
            binding.btPlay.setEnabled(false);
            binding.btRetry.setEnabled(true);
        } else {
            game.setWinOrLose(1);
            EndActivity();
        }
    }

    protected void EndActivity() {
        Bundle bundle = new Bundle();

        bundle.putParcelable("game", game);

        Intent intent = new Intent(this, EndPlayActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }

    protected void Delete() {
        binding.etNumber.setText("");
        binding.tvHighOrLow.setText("");
        binding.btRetry.setEnabled(false);
        binding.btPlay.setEnabled(true);
    }

    protected void GetRandomNumber() {
        int min = 0;
        int max = 100;
        randomNumber = new Random().nextInt((max - min) + 1) + min;
    }
}
