package br.com.deckfudion.johnathan.libs.scene3d.camera;


import com.badlogic.gdx.math.Vector3;

import br.com.deckfudion.johnathan.libs.scene3d.Camera3d;
import br.com.deckfudion.johnathan.libs.scene3d.actions.TemporalAction;


public class RotateToAction extends TemporalCamera {
	private  float rotateYaw, rotatePitch, rotateRoll;
	private  float rotateLastPercent;
	private  float rotatePercentDelta;


	@Override
	protected void begin () {
		if(getCamera() != null){

		}
	}


	public  void rotateBy(float yaw, float pitch, float roll){
		rotateLastPercent = 0;
		rotateYaw = yaw;
		rotatePitch = pitch;
		rotateRoll = roll;

	//	rotateCompleted = false;
	}


	@Override
	protected void update (float percent) {



		rotatePercentDelta = percent - rotateLastPercent;
		getCamera().rotate(Vector3.Y, rotateYaw * rotatePercentDelta);
		getCamera().rotate(Vector3.X, rotatePitch * rotatePercentDelta);
		getCamera().rotate(Vector3.Z, rotateRoll * rotatePercentDelta);
		rotateLastPercent = percent;

	}


}