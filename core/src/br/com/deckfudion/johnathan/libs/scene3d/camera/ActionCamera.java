package br.com.deckfudion.johnathan.libs.scene3d.camera;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.Pool;

abstract public class ActionCamera implements Pool.Poolable {

    protected PerspectiveCamera camera;

    private Pool<ActionCamera> pool;


    abstract public boolean act (float delta);


    public void restart () {
    }


    public PerspectiveCamera getCamera() {
        return camera;
    }

    public void setCamera(PerspectiveCamera camera) {
        this.camera = camera;

        if(camera != null) {
            if (pool != null) {
                pool.free(this);
                pool = null;
            }
        }
    }




    public void reset () {
        restart();
    }

    public Pool<ActionCamera> getPool () {
        return pool;
    }


    public void setPool (Pool pool) {
        this.pool = pool;
    }

    public String toString () {
        String name = getClass().getName();
        int dotIndex = name.lastIndexOf('.');
        if (dotIndex != -1) name = name.substring(dotIndex + 1);
        if (name.endsWith("ActionCamera")) name = name.substring(0, name.length() - 6);
        return name;
    }
}