package br.com.deckfudion.johnathan;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

public class AndroidLauncher extends AppCompatActivity implements AndroidFragmentApplication.Callbacks {

    public static AndroidLauncher context;
    private Fragment gameFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        context = this;

        gameFrag = getSupportFragmentManager().findFragmentByTag("frag");

        if (gameFrag == null) {

            gameFrag = new GameFrag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.window, gameFrag, "frag");
            ft.commit();
        }


    }

    @TargetApi(19)
    private void hideVirtualButtons() {
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }


    @Override
    public void exit() {

    }
    @Override
    protected void onStart() {
        super.onStart();
        hideVirtualButtons();
        gameFrag = getSupportFragmentManager().findFragmentByTag("frag");

        if (gameFrag == null) {

            gameFrag = new GameFrag();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.window, gameFrag, "frag");
            ft.commit();
        }
    }


    public  native void init();



}
