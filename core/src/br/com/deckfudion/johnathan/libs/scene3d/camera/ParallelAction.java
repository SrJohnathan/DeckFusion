package br.com.deckfudion.johnathan.libs.scene3d.camera;





import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

/** Executes a number of actions at the same time.
 * @author Nathan Sweet */
public class ParallelAction extends ActionCamera {
        Array<ActionCamera> actions = new Array<ActionCamera>(4);
        private boolean complete;

        public ParallelAction() {
        }

        public ParallelAction(ActionCamera action1) {
                addAction(action1);
        }

        public ParallelAction(ActionCamera action1, ActionCamera action2) {
                addAction(action1);
                addAction(action2);
        }

        public ParallelAction(ActionCamera action1, ActionCamera action2, ActionCamera action3) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
        }

        public ParallelAction(ActionCamera action1, ActionCamera action2, ActionCamera action3, ActionCamera action4) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
                addAction(action4);
        }

        public ParallelAction(ActionCamera action1, ActionCamera action2, ActionCamera action3, ActionCamera action4, ActionCamera action5) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
                addAction(action4);
                addAction(action5);
        }

        @Override
        public boolean act (float delta) {
                if (complete) return true;
                complete = true;
                Pool pool = getPool();
                setPool(null); // Ensure this action can't be returned to the pool while executing.
                try {
                        Array<ActionCamera> actions = this.actions;
                        for (int i = 0, n = actions.size; i < n && getCamera() != null; i++) {
                                if (!actions.get(i).act(delta)) complete = false;
                                if (getCamera() == null) return true; // This action was removed.
                        }
                        return complete;
                } finally {
                        setPool(pool);
                }
        }

        @Override
        public void restart () {
                complete = false;
                Array<ActionCamera> actions = this.actions;
                for (int i = 0, n = actions.size; i < n; i++)
                        actions.get(i).restart();
        }

        @Override
        public void reset () {
                super.reset();
                actions.clear();
        }

        public void addAction (ActionCamera action) {
                actions.add(action);
                if (getCamera() != null)
                	action.setCamera(getCamera());
        }

        @Override
        public void setCamera(PerspectiveCamera camera) {
                for (int i = 0, n = actions.size; i < n; i++) {
                        actions.get(i).setCamera(camera);
                        super.setCamera(camera);
                }
        }

        

        public Array<ActionCamera> getActions () {
                return actions;
        }

        @Override
        public String toString () {
                StringBuilder buffer = new StringBuilder(64);
                buffer.append(super.toString());
                buffer.append('(');
                Array<ActionCamera> actions = this.actions;
                for (int i = 0, n = actions.size; i < n; i++) {
                        if (i > 0) buffer.append(", ");
                        buffer.append(actions.get(i));
                }
                buffer.append(')');
                return buffer.toString();
        }
}