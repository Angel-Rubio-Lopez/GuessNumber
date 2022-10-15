package com.example.guessnumber.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.guessnumber.R;
import com.example.guessnumber.data.Game;
import com.example.guessnumber.databinding.ActivityConfigBinding;

/**
 * <h1>Proyecto GuessNumber</h1>
 * Este proyecto consiste en lo siguiente:
 * Introducimos nuesto nombre de usuario y un numero de intentos predeterminado, y mediante un boton pasamos a la siguiente actividad de nuestro juego
 * En esta segunda actividad debemos, mediante un edittext introducir numeros hasta intentar adivinar el numero secreto
 * En caso de que acertemos antes de que se nos acaben los intentos, o gastemos todos los intentos pasaremos a la tercera y ultima pantalla
 * En esta se muestran mensajes informativos como tu nombre de usuario, si has ganado o perdido o el número secreto en el caso de que hayas perdido
 *
 * Esta activity recoge el nombre del usuario y el numero maximo de intentos mediante dos edittext y un boton
 *
 * @author Angel Rubio
 * @version 1.0
 */

public class ConfigActivity extends AppCompatActivity {

    private ActivityConfigBinding binding;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfigBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btStart.setOnClickListener(view -> sendData());
    }

    //region aboutUs

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionAboutUs:
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //endregion

    public void sendData(View view) {
        sendData();
    }

    public void sendData() {
        if (TextUtils.isEmpty((binding.etName.getText().toString())) || (TextUtils.isEmpty((binding.etAttempts.getText().toString()))) || Integer.parseInt(binding.etAttempts.getText().toString()) == 0)
            return;
        else
            game = new Game(binding.etName.getText().toString(), Integer.parseInt(binding.etAttempts.getText().toString()));

        Bundle bundle = new Bundle();

        bundle.putParcelable("game", game);

        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);

    }
}