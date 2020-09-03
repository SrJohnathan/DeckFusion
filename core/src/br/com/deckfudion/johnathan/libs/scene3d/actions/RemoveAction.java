

package br.com.deckfudion.johnathan.libs.scene3d.actions;


import br.com.deckfudion.johnathan.libs.scene3d.Action3d;

import br.com.deckfudion.johnathan.libs.scene3d.Actor3d;


/** Removes an action from an actor.
 * @author Nathan Sweet */
public class RemoveAction extends Action3d {
        private Actor3d targetActor;
        private Action3d action;

        @Override
        public boolean act (float delta) {
                (targetActor != null ? targetActor : getActor3d()).removeAction3d(action);
                return true;
        }

        public Actor3d getTargetActor () {
                return targetActor;
        }

        public void setTargetActor (Actor3d actor) {
                this.targetActor = actor;
        }

        public Action3d getAction () {
                return action;
        }

        public void setAction(Action3d action) {
                this.action = action;
        }

        @Override
        public void reset () {
                super.reset();
                targetActor = null;
                action = null;
        }
}