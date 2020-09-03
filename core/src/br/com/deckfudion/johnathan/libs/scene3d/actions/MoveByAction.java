package br.com.deckfudion.johnathan.libs.scene3d.actions;


/** Moves an actor to a relative position.
 * @author Nathan Sweet */
public class MoveByAction extends RelativeTemporalAction {
        private float amountX, amountY, amountZ;

        @Override
        protected void updateRelative (float percentDelta) {
                getActor3d().translate(amountX * percentDelta, amountY * percentDelta, amountZ * percentDelta);
        }

        public void setAmount (float x, float y, float z) {
                amountX = x;
                amountY = y;
                amountZ = z;
        }

        public float getAmountX () {
                return amountX;
        }

        public void setAmountX (float x) {
                amountX = x;
        }

        public float getAmountY () {
                return amountY;
        }

        public void setAmountY (float y) {
                amountY = y;
        }
        
        public float getAmountZ () {
            return amountZ;
        }

        public void setAmountZ (float z) {
            amountZ = z;
        }
}