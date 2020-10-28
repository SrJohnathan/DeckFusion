package br.com.deckfudion.johnathan.libs.scene3d.camera;



public class RepeatAction extends DelegateAction {
        static public final int FOREVER = -1;

        private int repeatCount , executedCount;
        private boolean finished;
         private ActionCamera actionCamera;


        @Override
        public void setAction(ActionCamera action) {
                actionCamera = action;
                super.setAction(action);
        }

        @Override
        protected boolean delegate (float delta) {



                if (executedCount == repeatCount) return true;





                if (actionCamera.act(delta)) {
                        if (finished) return true;
                        if (repeatCount > 0) executedCount++;
                        if (executedCount == repeatCount) return true;
                        if (actionCamera != null) actionCamera.restart();
                }
                return false;
        }

        public void finish () {
                finished = true;
        }

        @Override
        public void restart () {
                super.restart();
                executedCount = 0;
                finished = false;
        }

        public void setCount (int count) {
                this.repeatCount = count;
        }

        public int getCount () {
                return repeatCount;
        }
}