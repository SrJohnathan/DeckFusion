package br.com.deckfudion.johnathan;

import android.content.DialogInterface;

import org.jetbrains.annotations.NotNull;

import br.com.deckfudion.johnathan.utill.ApiDialog;
import br.com.deckfudion.johnathan.utill.Value;

public class AlertDialog implements ApiDialog {

    @Override
    public void dispose() {

    }

    @Override
    public void showDialog(@NotNull final Runnable runnable) {

        if (AndroidLauncher.context != null){
            System.out.println("NOT NULL");

            AndroidLauncher.context.runOnUiThread(new Runnable() {
                @Override
                public void run() {


                    new android.app.AlertDialog.Builder(AndroidLauncher.context)
                            .setTitle("Erro ao carregar")
                            .setMessage("Make sure the game folder is in the user's personal folder")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    runnable.run();
                                }
                            })
                            .create().show();
                }
            });


        }








    }

    @Override
    public void showDialogInput(@NotNull Value varl) {

    }


    @Override
    public boolean isShow() {
        return false;
    }
}
