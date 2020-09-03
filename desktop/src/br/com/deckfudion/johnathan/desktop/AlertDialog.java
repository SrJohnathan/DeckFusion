package br.com.deckfudion.johnathan.desktop;

import javax.swing.JOptionPane;

import br.com.deckfudion.johnathan.utill.ApiDialog;

public class AlertDialog implements ApiDialog {


    public AlertDialog() {
    }



    @Override
    public void dispose() {

    }

    @Override
    public void showDialog(Runnable runnable) {

        int d =    JOptionPane.showConfirmDialog(null,
                "Make sure the game folder is in the user's personal folder",
                "Erro ao carragar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if(d == 0){
            runnable.run();
        }else {
            runnable.run();
        }


    }
}
