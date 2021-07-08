package prof;

import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import playmode.Play;

public class Professor extends ImageView {

	final static javafx.scene.image.Image prof_0 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/p_1.png").toString());
	final static javafx.scene.image.Image prof_1 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/p_0.png").toString());
	final static javafx.scene.image.Image prof_2 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdl_0.png").toString());
	final static javafx.scene.image.Image prof_3 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdl_1.png").toString());
	final static javafx.scene.image.Image prof_4 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdr_0.png").toString());
	final static javafx.scene.image.Image prof_5 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdr_1.png").toString());
	final static javafx.scene.image.Image prof_6 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_0.png").toString());
	final static javafx.scene.image.Image prof_7 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_1.png").toString());
	final static javafx.scene.image.Image prof_8 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_2.png").toString());
	final static javafx.scene.image.Image prof_9 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_3.png").toString());
	final static javafx.scene.image.Image prof_10 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_4.png").toString());
	final static javafx.scene.image.Image prof_11 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_5.png").toString());
	final static javafx.scene.image.Image prof_12 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pr_6.png").toString());
	final static javafx.scene.image.Image prof_13 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pl_0.png").toString());
	final static javafx.scene.image.Image prof_14 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pl_1.png").toString());
	final static javafx.scene.image.Image prof_15 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pl_2.png").toString());
	final static javafx.scene.image.Image prof_16 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pl_3.png").toString());
	final static javafx.scene.image.Image prof_17 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pl_4.png").toString());
	
	
	public Professor() {
		super(prof_0);
	}
	
	public AnimationTimer prof_turn_r = new AnimationTimer() {
		double k = 0, step = 50;

		@Override
		public void handle(long now) {
			if (getTranslateX() <= 570)
				setTranslateX(getTranslateX() + 3);
			k += 5;
			if (k == step) {
				prof_store();
			} else if (k == step * 0.25) {
				prof_release1();
			} else if (k == step * 0.5) {
				prof_release2();
			} else if (k == step * 1) {
				prof_release3();
			} else if (k == step * 1.25) {
				prof_release4();
			} else if (k == step * 1.5) {
				prof_release5();
			} else if (k == step * 2) {
				prof_release6();
				k = 0;
			}
		}

	};

	private void prof_store() {
		this.setImage(prof_12);
	}

	private void prof_release1() {
		this.setImage(prof_0);
	}

	private void prof_release2() {
		this.setImage(prof_6);
	}

	private void prof_release3() {
		this.setImage(prof_7);
	}

	private void prof_release4() {
		this.setImage(prof_8);
	}

	private void prof_release5() {
		this.setImage(prof_9);
	}

	private void prof_release6() {
		this.setImage(prof_10);
	}

	public AnimationTimer prof_turn_l = new AnimationTimer() {
		double k = 0, step = 50;

		@Override
		public void handle(long now) {
			if (getTranslateX() >= -570)
				setTranslateX(getTranslateX() - 3);
			k += 5;
			if (k == step) {
				prof_store1();
			} else if (k == step * 1.25) {
				prof_release8();
			} else if (k == step * 1.5) {
				prof_release9();
			} else if (k == step * 1.75) {
				prof_release10();
			} else if (k == step * 2) {
				prof_release11();
				k = 0;
			} else if (k == step * 2.25) {
				prof_release12();
				k = 0;
			}

		}
	};

	private void prof_store1() {
		this.setImage(prof_17);
	}

	private void prof_release8() {
		this.setImage(prof_0);
	}

	private void prof_release9() {
		this.setImage(prof_13);
	}

	private void prof_release10() {
		this.setImage(prof_14);
	}

	private void prof_release11() {
		this.setImage(prof_15);
	}

	private void prof_release12() {
		this.setImage(prof_16);
	}

	void moveLeft() {
		prof_turn_l.start();
	}

	void stopLeft() {
		prof_turn_l.stop();
	}

	void moveRight() {
		prof_turn_r.start();
	}

	void stopRight() {
		prof_turn_r.stop();
	}
	


	/*
	 * void shoot() { prof_shoot.start(); }
	 * 
	 * void shoot() { prof_shoot.stop(); }
	 * 
	 * void prof_dodgeLeft() { prof_dodge_l.start(); }
	 * 
	 * void stopDown() { turn_d.stop(); }
	 */
}