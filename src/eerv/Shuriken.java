package eerv;

import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import playmode.Play;
import prof.Professor;

public class Shuriken extends ImageView {

	final static javafx.scene.image.Image ninja_18 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/sho_r.png").toString());
	final static javafx.scene.image.Image ninja_19 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/shu_0.png").toString());
	final static javafx.scene.image.Image ninja_20 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/shu_1.png").toString());
	final static javafx.scene.image.Image ninja_21 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/shu_2.png").toString());
Professor professor;
public boolean visible;
	boolean set = false;
	public Shuriken() {
		super(ninja_19);
		visible = true;
		
	}
	
	public boolean isShown() {
		return visible;
	}
	public void setShown(boolean visible) {
		this.visible = visible;
	}
	AnimationTimer shoot_right = new AnimationTimer() {
		int step = 50, k = 0;
		boolean shootReady = true;
		int counter = 0;
		public void handle(long now) {
		
			if (getTranslateX() <= 570) {
				setTranslateX(getTranslateX() + 10);
			}
			else {
				set = true;
				shoot_right.stop();
			}
			k += 5;
			if (k == step) {
				store2();
			} else if (k == step * 2) {
				release11();
			} else if (k == step *2.5 ) {
				release13();
				k=0;
			}
		}
	};
	AnimationTimer shoot_left = new AnimationTimer() {
		int step = 50, k = 0;
		public void handle(long now) {
		
			if (getTranslateX() <= 570) {
				setTranslateX(getTranslateX() -10);
			}
			else {
				set = true;
			}
			k += 5;
			if (k == step) {
				store2();
			} else if (k == step * 2) {
				release11();
			} else if (k == step *2.5 ) {
				release13();
				k=0;
			}
		}
	};
	public boolean isSet() {
		return set;
	}
	public void set(boolean set) {
		this.set = set;
	}
	private void store2() {
		this.setImage(ninja_21);
	}
	private void release11() {
		this.setImage(ninja_19);
	}
	private void release13() {
		this.setImage(ninja_20);
	}
	public void shoot_right() {
		shoot_right.start();
	}
	public void shoot_left() {
		shoot_left.start();
	}
    }