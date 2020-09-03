package br.com.deckfudion.johnathan.utill;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class AnimatedSprite extends Sprite {

	/** the {@link Animation} to display */
	private Animation animation;

	/** the current time of the {@link Animation} */
	private float time;

	/** if the animation is playing */
	private boolean playing = true;

	/** if the animation should be updated every time it's drawn */
	private boolean autoUpdate = true;

	/** if the size of the previous frame should be kept by the following frames */
	private boolean keepSize;

	/** if a frame should be centered in its previous one's center if it's smaller */
	private boolean centerFrames;



	/** creates a new {@link AnimatedSprite} with the given {@link Animation}
	 *  @param animation the {@link #animation} to use */
	public AnimatedSprite(Animation animation) {
		this(animation, false);
	}






	/** creates a new {@link AnimatedSprite} with the given {@link Animation}
	 *  @param animation the {@link #animation} to use
	 *  @param keepSize the {@link #keepSize} to use */
	public AnimatedSprite(Animation animation, boolean keepSize) {



		super((TextureRegion) animation.getKeyFrame(0));



		this.animation = animation;
		this.keepSize = keepSize;
	}

	/** updates the {@link AnimatedSprite} with the delta time fetched from {@link Graphics#getDeltaTime()  Gdx.graphics.getDeltaTime()} */
	public void update() {
		update(Gdx.graphics.getDeltaTime());
	}

	/** updates the {@link AnimatedSprite} with the given delta time */
	public void update(float delta) {
		if(playing) {
			setRegion((TextureRegion )  animation.getKeyFrame(time += delta));
			if(!keepSize)
				setSize(getRegionWidth(), getRegionHeight());
		}
	}

	/** {@link Sprite#draw(Batch) Draws} this {@code AnimatedSprite}. If {@link #autoUpdate} is true, {@link #update()} will be called before drawing. */
	@Override
	public void draw(Batch spriteBatch) {
		if(centerFrames && !keepSize) {
			float x = getX(), y = getY(), width = getWidth(), height = getHeight(), originX = getOriginX(), originY = getOriginY();

			if(autoUpdate)
				update();

			float differenceX = width - getRegionWidth(), differenceY = height - getRegionHeight();
			setOrigin(originX - differenceX / 2, originY - differenceY / 2);
			setBounds(x + differenceX / 2, y + differenceY / 2, width - differenceX, height - differenceY);

			super.draw(spriteBatch);

			setOrigin(originX, originY);
			setBounds(x, y, width, height);
			return;
		}

		if(autoUpdate)
			update();

		super.draw(spriteBatch);
	}

	/** flips all frames
	 *  @see #flipFrames(boolean, boolean, boolean) */
	public void flipFrames(boolean flipX, boolean flipY) {
		flipFrames(flipX, flipY, false);
	}

	/** flips all frames
	 *  @see #flipFrames(float, float, boolean, boolean, boolean) */
	public void flipFrames(boolean flipX, boolean flipY, boolean set) {
		flipFrames(0, animation.getFrameDuration(), flipX, flipY, set);
	}

	/** flips all frames
	 *  @see #flipFrames(float, float, boolean, boolean, boolean) */
	public void flipFrames(float startTime, float endTime, boolean flipX, boolean flipY) {
		flipFrames(startTime, endTime, flipX, flipY, false);
	}

	/** flips all frames from {@code startTime} to {@code endTime}
	 *  @param startTime the animation state time of the first frame to flip
	 *  @param endTime the animation state time of the last frame to flip
	 *  @param set if the frames should be set to {@code flipX} and {@code flipY} instead of actually flipping them */
	public void flipFrames(float startTime, float endTime, boolean flipX, boolean flipY, boolean set) {
		for(float t = startTime; t < endTime; t += animation.getAnimationDuration()) {
			TextureRegion frame = (TextureRegion ) animation.getKeyFrame(t);
			frame.flip(flipX && (set ? !frame.isFlipX() : true), flipY && (set ? !frame.isFlipY() : true));
		}
	}

	/** sets {@link #playing} to true */
	public AnimatedSprite play() {
		playing = true;

		return  this;
	}

	/** sets {@link #playing} to false */
	public void pause() {
		playing = false;
	}

	/** pauses and sets the {@link #time} to 0 */
	public void stop() {
		playing = false;
		time = 0;
	}

	/** @param time the {@link #time} to go to */
	public void setTime(float time) {
		this.time = time;
	}

	/** @return the current {@link #time} */
	public float getTime() {
		return time;
	}

	/** @return the {@link #animation} */
	public Animation getAnimation() {
		return animation;
	}

	/** @param animation the {@link #animation} to set */
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	/** @return if this {@link AnimatedSprite} is playing */
	public boolean isPlaying() {
		return playing;
	}

	/** @param playing if the {@link AnimatedSprite} should be playing */
	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	/** @return if the {@link #animation} has finished playing */
	public boolean isAnimationFinished() {
		return animation.isAnimationFinished(time);
	}

	/** @return the {@link #autoUpdate} */
	public boolean isAutoUpdate() {
		return autoUpdate;
	}

	/** @param autoUpdate the {@link #autoUpdate} to set */
	public void setAutoUpdate(boolean autoUpdate) {
		this.autoUpdate = autoUpdate;
	}

	/** @return the {{@link #keepSize} */
	public boolean isKeepSize() {
		return keepSize;
	}

	/** @param keepSize the {@link #keepSize} to set */
	public void setKeepSize(boolean keepSize) {
		this.keepSize = keepSize;
	}

	/** @return the {@link #centerFrames} */
	public boolean isCenterFrames() {
		return centerFrames;
	}

	/** @param centerFrames the {@link #centerFrames} to set */
	public void setCenterFrames(boolean centerFrames) {
		this.centerFrames = centerFrames;
	}



	public  static  class SpriteAniActor extends Actor{

	 private Sprite animatedSprite;

		public SpriteAniActor(Sprite animatedSprite) {

			this.animatedSprite = animatedSprite;



		}




		@Override
		public void draw(Batch batch, float parentAlpha) {

			animatedSprite.draw(batch,parentAlpha);

			//super.draw(batch, parentAlpha);
		}

		public SpriteAniActor spritePos(float x, float y){
			animatedSprite.setPosition(x, y);
			setBounds(animatedSprite.getX(), animatedSprite.getY(), animatedSprite.getWidth(), animatedSprite.getHeight());


			return this;
		}


		public Sprite getAnimatedSprite() {
			return animatedSprite;
		}

		public AnimatedSprite getAnimated() {
			return (AnimatedSprite)  animatedSprite;
		}

		@Override
		public void act(float delta) {
			super.act(delta);
			animatedSprite.setPosition(this.getX(), this.getY());
			animatedSprite.setOrigin(this.getOriginX(), this.getOriginY());
			animatedSprite.setRotation(this.getRotation());
			animatedSprite.setScale(this.getScaleX(), this.getScaleY());

		}
	}
}