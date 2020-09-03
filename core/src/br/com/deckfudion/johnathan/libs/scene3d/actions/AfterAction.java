package br.com.deckfudion.johnathan.libs.scene3d.actions;



import br.com.deckfudion.johnathan.libs.scene3d.Action3d;
import br.com.deckfudion.johnathan.libs.scene3d.Actor3d;

import com.badlogic.gdx.utils.Array;


public class AfterAction extends DelegateAction {
        private Array<Action3d> waitForActions = new Array<Action3d>(false, 4);

        @Override
        public void setActor3d(Actor3d actor3d) {
             if (actor3d != null) waitForActions.addAll(actor3d.getActions3d());
             super.setActor3d(actor3d);
        }

        @Override
        public void restart () {
                super.restart();
                waitForActions.clear();
        }

        @Override
        protected boolean delegate (float delta) {
                Array<Action3d> currentActions = getActor3d().getActions3d();
                if (currentActions.size == 1) waitForActions.clear();
                for (int i = waitForActions.size - 1; i >= 0; i--) {
                        Action3d action = waitForActions.get(i);
                        int index = currentActions.indexOf(action, true);
                        if (index == -1) waitForActions.removeIndex(i);
                }
                if (waitForActions.size > 0) return false;
                return action.act(delta);
        }
}