package com.example.guessnumber.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * <h1>Proyecto GuessNumber</h1>
 * Este proyecto consiste en lo siguiente:
 * Introducimos nuesto nombre de usuario y un numero de intentos predeterminado, y mediante un boton pasamos a la siguiente actividad de nuestro juego
 * En esta segunda actividad debemos, mediante un edittext introducir numeros hasta intentar adivinar el numero secreto
 * En caso de que acertemos antes de que se nos acaben los intentos, o gastemos todos los intentos pasaremos a la tercera y ultima pantalla
 * En esta se muestran mensajes informativos como tu nombre de usuario, si has ganado o perdido o el número secreto en el caso de que hayas perdido
 *
 * Clase POJO de nuestro proyecto
 *
 * @author Angel Rubio
 * @version 1.0
 */

public class Game implements Serializable, Parcelable {

    private String name;
    private int attempts;
    private int randomNumber;
    private int numberOfAttempts;
    private int winOrLose;

    public Game() {
    }

    public Game(String name, int attempts) {
        this.name = name;
        this.attempts = attempts;
        this.numberOfAttempts = 1;
        this.winOrLose = 0;
    }

    public void Increment(){
        this.numberOfAttempts++;
    }

    //region Getters y Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getWinOrLose() {
        return winOrLose;
    }

    public void setWinOrLose(int winOrLose) {
        this.winOrLose = winOrLose;
    }

    //endregion

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", attempts=" + attempts +
                ", number=" + randomNumber +
                ", numberOfAttempts=" + numberOfAttempts +
                ", winOrLose='" + winOrLose + '\'' +
                '}';
    }

    //region PARCELABLE Y SERIALIZABLE

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(attempts);
        parcel.writeInt(randomNumber);
        parcel.writeInt(numberOfAttempts);
        parcel.writeInt(winOrLose);
    }

    protected Game(Parcel in) {
        name = in.readString();
        attempts = in.readInt();
        randomNumber = in.readInt();
        numberOfAttempts = in.readInt();
        winOrLose = in.readInt();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    //endregion
}
