package br.com.deckfudion.johnathan.libs.scene3d.actions;


public class TimeScaleAction extends DelegateAction {
        private float scale;

        @Override
        protected boolean delegate (float delta) {
                if (action == null) return true;
                return action.act(delta * scale);
        }

        public float getScale () {
                return scale;
        }

        public void setScale (float scale) {
                this.scale = scale;
        }
}