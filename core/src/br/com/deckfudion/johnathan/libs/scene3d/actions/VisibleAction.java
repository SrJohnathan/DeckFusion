package br.com.deckfudion.johnathan.libs.scene3d.actions;


import br.com.deckfudion.johnathan.libs.scene3d.Action3d;


public class VisibleAction extends Action3d {
        private boolean visible;

        @Override
        public boolean act (float delta) {
                getActor3d().setVisible(visible);
                return true;
        }

        public boolean isVisible () {
                return visible;
        }

        public void setVisible (boolean visible) {
                this.visible = visible;
        }
}