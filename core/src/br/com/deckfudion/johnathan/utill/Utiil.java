package br.com.deckfudion.johnathan.utill;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Utiil {

    public static String encryptDecrypt(String inputString)
    {
        // Define XOR key
        // Any character value will work
        char xorKey = 'J';

        // Define String to store encrypted/decrypted String
        String outputString = "";

        // calculate length of input string
        int len = inputString.length();

        // perform XOR operation of key
        // with every caracter in string
        for (int i = 0; i < len; i++)
        {
            outputString = outputString +
                    Character.toString((char) (inputString.charAt(i) ^ xorKey));
        }


        return outputString;
    }



    public static void  toColorGlglClearColor(Color color){


    }







}

