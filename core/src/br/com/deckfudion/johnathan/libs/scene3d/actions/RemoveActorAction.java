package br.com.deckfudion.johnathan.libs.scene3d.actions;


import br.com.deckfudion.johnathan.libs.scene3d.Action3d;

import br.com.deckfudion.johnathan.libs.scene3d.Actor3d;


/** Removes an actor from the stage.
 * @author Nathan Sweet */
public class RemoveActorAction extends Action3d {
        private Actor3d removeActor;
        private boolean removed;

        @Override
        public boolean act (float delta) {
                if (!removed) {
                        removed = true;
                        (removeActor != null ? removeActor : getActor3d()).remove();
                }
                return true;
        }

        @Override
        public void restart () {
                removed = false;
        }

        @Override
        public void reset () {
                super.reset();
                removeActor = null;
        }

        public Actor3d getRemoveActor () {
                return removeActor;
        }

        public void setRemoveActor (Actor3d removeActor) {
                this.removeActor = removeActor;
        }
}