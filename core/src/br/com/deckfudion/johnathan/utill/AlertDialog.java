package br.com.deckfudion.johnathan.utill;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.reflect.ClassReflection;
import com.badlogic.gdx.utils.reflect.ReflectionException;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AlertDialog implements ApiDialog {

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




    @Override
    public void showDialog(@NotNull Runnable runnable) {

    }

    @Override
    public void showDialogInput(@NotNull Value varl) {

        try {

            Method method = alertDialog.getDeclaredMethod("showDialogInput",Value.class);


            Object o =  method.invoke(apiDialog, varl);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isShow() {
        Object o = null;
        try {

            Method method = alertDialog.getDeclaredMethod("isShow");
             o =  method.invoke(apiDialog);



        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return Boolean.parseBoolean(String.valueOf(o));
    }

    public interface GetValue {
        public void value(boolean v);
    }

}
