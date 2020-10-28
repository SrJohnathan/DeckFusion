package br.com.deckfudion.johnathan.libs.scene3d.camera;


import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.Pool;

import br.com.deckfudion.johnathan.libs.scene3d.Action3d;
import br.com.deckfudion.johnathan.libs.scene3d.Actor3d;


/** Base class for an action that wraps another action.
 * @author Nathan Sweet */
abstract public class DelegateAction extends ActionCamera {
        protected ActionCamera actionc;


        public void setAction (ActionCamera action) {
                this.actionc = action;


        }

        public ActionCamera getAction () {
                return actionc;
        }

        abstract protected boolean delegate (float delta);

        @Override
        public final boolean act (float delta) {



                        Pool pool = getPool();


                        setPool(null); // Ensure this action can't be returned to the pool inside the delegate action.
                        try {
                                return delegate(delta);
                        } finally {
                                setPool(pool);
                        }


        }

        @Override
        public void restart () {
                if (actionc != null) actionc.restart();
        }

        @Override
        public void reset () {
                super.reset();
                actionc = null;
        }

        @Override
        public void setCamera(PerspectiveCamera camera) {
                if (actionc != null){
                        actionc.setCamera(camera);
                }
                super.setCamera(camera);
        }



        @Override
        public String toString () {
                return super.toString() + (actionc == null ? "" : "(" + actionc + ")");
        }
}