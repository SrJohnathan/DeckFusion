package br.com.deckfudion.johnathan.libs.scene3d.camera;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pools;

import br.com.deckfudion.johnathan.libs.scene3d.Actor3d;



public class Actions {

    static public <T extends ActionCamera> T action3d(Class<T> type) {
        Pool<T> pool = Pools.get(type);
        T action = pool.obtain();
        action.setPool(pool);
        return action;
    }




    public static CameraMoveCircular moveCircular(float radios, CameraMoveCircular.MethodCircle direction, boolean moveZ, float duration
            , float degrees, Interpolation interpolation) {
        return moveEllipse(null, radios, radios, direction, moveZ, duration, degrees, interpolation);
    }

    public static CameraMoveCircular moveCircularActor(Actor3d actor3d, float radios, CameraMoveCircular.MethodCircle direction, boolean moveZ, float duration
            , float degrees, Interpolation interpolation) {
        return moveEllipse(actor3d, radios, radios, direction, moveZ, duration, degrees, interpolation);
    }

    public static CameraMoveCircular moveCircular(float radios, CameraMoveCircular.MethodCircle direction, boolean moveZ, float duration
            , float degrees) {
        return moveEllipse(null, radios, radios, direction, moveZ, duration, degrees, Interpolation.linear);
    }

    public static CameraMoveCircular moveCircularActor(Actor3d actor3d, float radios, CameraMoveCircular.MethodCircle direction, boolean moveZ, float duration
            , float degrees) {
        return moveEllipse(actor3d, radios, radios, direction, moveZ, duration, degrees, Interpolation.linear);
    }

    public static CameraMoveCircular moveEllipse(Actor3d actor3d, float radios1, float radios2, CameraMoveCircular.MethodCircle direction, boolean moveZ, float duration
            , float degrees, Interpolation interpolation) {
        CameraMoveCircular moveCircular = action3d(CameraMoveCircular.class);
        moveCircular.movz(moveZ);
        moveCircular.setactor(actor3d);
        moveCircular.setR(radios1, radios2);
        moveCircular.setDuration(duration);
        moveCircular.setDirection(direction);
        moveCircular.setInterpolation(interpolation);
        moveCircular.setDegress( degrees);
        return moveCircular;

    }

    static public ParallelAction parallel(ActionCamera action1) {
        ParallelAction action = action3d(ParallelAction.class);
        action.addAction(action1);
        return action;
    }

    static public ParallelAction parallel(ActionCamera action1, ActionCamera action2) {
        ParallelAction action = action3d(ParallelAction.class);
        action.addAction(action1);
        action.addAction(action2);
        return action;
    }

    static public ParallelAction parallel(ActionCamera action1, ActionCamera action2, ActionCamera action3) {
        ParallelAction action = action3d(ParallelAction.class);
        action.addAction(action1);
        action.addAction(action2);
        action.addAction(action3);
        return action;
    }

    static public ParallelAction parallel(ActionCamera action1, ActionCamera action2, ActionCamera action3, ActionCamera action4) {
        ParallelAction action = action3d(ParallelAction.class);
        action.addAction(action1);
        action.addAction(action2);
        action.addAction(action3);
        action.addAction(action4);
        return action;
    }

    static public ParallelAction parallel(ActionCamera action1, ActionCamera action2, ActionCamera action3, ActionCamera action4, ActionCamera action5) {
        ParallelAction action = action3d(ParallelAction.class);
        action.addAction(action1);
        action.addAction(action2);
        action.addAction(action3);
        action.addAction(action4);
        action.addAction(action5);
        return action;
    }

    static public ParallelAction parallel(ActionCamera... actions) {
        ParallelAction action = action3d(ParallelAction.class);
        for (int i = 0, n = actions.length; i < n; i++)
            action.addAction(actions[i]);
        return action;
    }

    static public ParallelAction parallel() {
        return action3d(ParallelAction.class);
    }

    static public RepeatAction repeat(int count, ActionCamera repeatedAction) {
        RepeatAction action = action3d(RepeatAction.class);
        action.setCount(count);
        action.setAction(repeatedAction);
        return action;
    }

    static public RepeatAction forever(ActionCamera repeatedAction) {
        RepeatAction action = action3d(RepeatAction.class);
        action.setCount(RepeatAction.FOREVER);
        action.setAction(repeatedAction);
        return action;
    }

    static public RotateToAction rotateTo(float yaw, float pitch, float roll , float duration) {
        RotateToAction action = action3d(RotateToAction.class);
        action.setDuration(duration);
        action.rotateBy(yaw, pitch, roll);
        return action;
    }
}
