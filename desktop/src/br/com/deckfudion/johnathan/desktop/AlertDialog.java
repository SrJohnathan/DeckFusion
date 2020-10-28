package br.com.deckfudion.johnathan.desktop;

import com.badlogic.gdx.Gdx;

import org.jetbrains.annotations.NotNull;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import br.com.deckfudion.johnathan.utill.ApiDialog;
import br.com.deckfudion.johnathan.utill.Value;

public class AlertDialog implements ApiDialog {

    private JFrame jf;
    private boolean show = false;

    public AlertDialog() {

        jf = new JFrame();
        jf.setAlwaysOnTop(true);
        jf.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }


    @Override
    public void dispose() {
        jf.dispose();

    }

    @Override
    public void showDialog(Runnable runnable) {

        int d = JOptionPane.showConfirmDialog(jf,
                "Make sure the game folder is in the user's personal folder",
                "Erro ao carragar",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (d == 0) {
            runnable.run();
        } else {
            runnable.run();
        }


    }


    @Override
    public void showDialogInput(@NotNull Value varl) {


        if (!show) {
            show = true;

            new Thread(() -> {

                String d = JOptionPane.showInputDialog(jf, "Username");

                if (d != null && !d.isEmpty()) {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    Gdx.app.postRunnable(() -> {
                        varl.content(d);
                    });


                    show = false;
                } else {

                    show = false;
                    showDialogInput(varl);

                }


            }).start();

        }
    }


    @Override
    public boolean isShow() {
        return show;
    }
}
