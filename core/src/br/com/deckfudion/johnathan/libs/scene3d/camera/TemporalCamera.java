package br.com.deckfudion.johnathan.libs.scene3d.camera;




import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.Pool;

import br.com.deckfudion.johnathan.libs.scene3d.Action3d;


abstract public class TemporalCamera extends ActionCamera{
        private float duration, time;
        private Interpolation interpolation;
        private boolean reverse, began, complete;

        public TemporalCamera() {
        }

        public TemporalCamera(float duration) {
                this.duration = duration;
        }

        public TemporalCamera(float duration, Interpolation interpolation) {
                this.duration = duration;
                this.interpolation = interpolation;
        }

        @Override
        public boolean act (float delta) {
                if (complete) return true;
                Pool pool = getPool();
                setPool(null); // Ensure this action can't be returned to the pool while executing.
                try {
                        if (!began) {
                                begin();
                                began = true;
                        }
                        time += delta;
                        complete = time >= duration;
                        float percent;
                        if (complete)
                                percent = 1;
                        else {
                                percent = time / duration;
                                if (interpolation != null) percent = interpolation.apply(percent);
                        }
                        update(reverse ? 1 - percent : percent);
                        if (complete) end();
                        return complete;
                } finally {
                        setPool(pool);
                }
        }


        protected void begin () {
        }

        protected void end () {
        }


        abstract protected void update (float percent);


        public void finish () {
                time = duration;
        }

        @Override
        public void restart () {
                time = 0;
                began = false;
                complete = false;
        }

        @Override
        public void reset () {
                super.reset();
                reverse = false;
                interpolation = null;
        }

        public float getTime () {
                return time;
        }

        public void setTime (float time) {
                this.time = time;
        }

        public float getDuration () {
                return duration;
        }


        public void setDuration (float duration) {
                this.duration = duration;
        }

        public Interpolation getInterpolation () {
                return interpolation;
        }

        public void setInterpolation (Interpolation interpolation) {
                this.interpolation = interpolation;
        }

        public boolean isReverse () {
                return reverse;
        }

        public void setReverse (boolean reverse) {
                this.reverse = reverse;
        }
}
