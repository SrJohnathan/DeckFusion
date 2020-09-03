package br.com.deckfudion.johnathan.libs.scene3d.actions;


import br.com.deckfudion.johnathan.libs.scene3d.Action3d;
import com.badlogic.gdx.utils.Pool;

/** Executes a number of actions one at a time.
 * @author Nathan Sweet */
public class SequenceAction extends ParallelAction {
        private int index;

        public SequenceAction () {
        }

        public SequenceAction (Action3d action1) {
                addAction(action1);
        }

        public SequenceAction (Action3d action1, Action3d action2) {
                addAction(action1);
                addAction(action2);
        }

        public SequenceAction (Action3d action1, Action3d action2, Action3d action3) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
        }

        public SequenceAction (Action3d action1, Action3d action2, Action3d action3, Action3d action4) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
                addAction(action4);
        }

        public SequenceAction (Action3d action1, Action3d action2, Action3d action3, Action3d action4, Action3d action5) {
                addAction(action1);
                addAction(action2);
                addAction(action3);
                addAction(action4);
                addAction(action5);
        }

        @Override
        public boolean act (float delta) {
                if (index >= actions.size) return true;
                Pool pool = getPool();
                setPool(null); // Ensure this action can't be returned to the pool while executings.
                try {
                        if (actions.get(index).act(delta)) {
                                if (getActor3d() == null) return true; // This action was removed.
                                index++;
                            return index >= actions.size;
                        }
                        return false;
                } finally {
                        setPool(pool);
                }
        }

        @Override
        public void restart () {
                super.restart();
                index = 0;
        }
}