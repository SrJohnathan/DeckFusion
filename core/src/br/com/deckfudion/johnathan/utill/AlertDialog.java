package br.com.deckfudion.johnathan.utill;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AlertDialog {

    String className = "";
    private Class<? extends ApiDialog> alertDialog;
    private ApiDialog apiDialog;

    public AlertDialog() {


        if (Gdx.app.getType() == Application.ApplicationType.Android) {

            className = "br.com.deckfudion.johnathan.AlertDialog";

        } else if (Gdx.app.getType() == Application.ApplicationType.Desktop) {

            className = "br.com.deckfudion.johnathan.desktop.AlertDialog";
        }


        try {
            alertDialog = ClassReflection.forName(className);

            apiDialog = alertDialog.newInstance();
        } catch (ReflectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }


    public void showDialog(final GetValue getValue) {


        try {

            Method method = alertDialog.getDeclaredMethod("showDialog",Runnable.class);


             Object o =  method.invoke(apiDialog, new Runnable() {
                 @Override
                 public void run() {
                     getValue.value(false);
                 }
             });

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


    public interface GetValue {
        public void value(boolean v);
    }

}
