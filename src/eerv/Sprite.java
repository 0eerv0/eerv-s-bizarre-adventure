package eerv;
import javafx.animation.AnimationTimer;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import playmode.Play;

public class Sprite extends ImageView {

	final static javafx.scene.image.Image ninja_0 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_0.png").toString());
	final static javafx.scene.image.Image ninja_1 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_1.png").toString());
	final static javafx.scene.image.Image ninja_2 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_2.png").toString());
	final static javafx.scene.image.Image ninja_3 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_3.png").toString());
	final static javafx.scene.image.Image ninja_4 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_4.png").toString());
	final static javafx.scene.image.Image ninja_5 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_5.png").toString());
	final static javafx.scene.image.Image ninja_6 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/ml_1.png").toString());
	final static javafx.scene.image.Image ninja_7 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/ml_2.png").toString());
	final static javafx.scene.image.Image ninja_8 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/ml_3.png").toString());
	final static javafx.scene.image.Image ninja_9 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/ml_4.png").toString());
	final static javafx.scene.image.Image ninja_10 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/ml_5.png").toString());
	final static javafx.scene.image.Image ninja_11 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jr_0.png").toString());
	final static javafx.scene.image.Image ninja_12 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jr_1.png").toString());
	final static javafx.scene.image.Image ninja_13 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jr_2.png").toString());
	final static javafx.scene.image.Image ninja_14 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jl_0.png").toString());
	final static javafx.scene.image.Image ninja_15 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jl_1.png").toString());
	final static javafx.scene.image.Image ninja_16 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/jl_2.png").toString());
	final static javafx.scene.image.Image ninja_17 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/sho_l.png").toString());
	final static javafx.scene.image.Image ninja_18 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/sho_r.png").toString());
	boolean left=true;
	
		public Sprite() {
			super(ninja_0);
			moveDown();
			
		}
		AnimationTimer turn_r = new AnimationTimer() {
			double k = 0, step = 50;

			@Override
			public void handle(long now) {
				if (getTranslateX() <= 570)
					setTranslateX(getTranslateX() + 3);
				k += 5;
				if (k == step) {
					store();
				} else if (k == step * 1.25) {
					release1();
				} else if (k == step * 1.5) {
					release2();
				} else if (k == step * 1.75) {
					release3();
				} else if (k == step * 2) {
					release4();
					k = 0;
				}
			}
		};

		private void store() {
			this.setImage(ninja_5);
		}

		private void release1() {
			this.setImage(ninja_0);
		}

		private void release2() {
			this.setImage(ninja_1);
		}

		private void release3() {
			this.setImage(ninja_2);
		}

		private void release4() {
			this.setImage(ninja_3);
		}

		AnimationTimer turn_l = new AnimationTimer() {
			double k = 0, step = 50;

			@Override
			public void handle(long now) {
				if (getTranslateX() >= -570)
					setTranslateX(getTranslateX() - 3);
				k += 5;
				if (k == step) {
					store1();
				} else if (k == step * 1.25) {
					release6();
				} else if (k == step * 1.5) {
					release7();
				} else if (k == step * 1.75) {
					release8();
				} else if (k == step * 2) {
					release9();
					k = 0;
				}

			}
		};

		private void store1() {
			this.setImage(ninja_10);
		}

		private void release6() {
			this.setImage(ninja_0);
		}

		private void release7() {
			this.setImage(ninja_6);
		}

		private void release8() {
			this.setImage(ninja_7);
		}

		private void release9() {
			this.setImage(ninja_8);
		}

		AnimationTimer turn_u = new AnimationTimer() {
			public void handle(long now) {
				if (getTranslateY() >= -100) {
					setTranslateY(getTranslateY() - 20);
					release12();
				} else
					turn_u.stop();
			}
		};

		private void release12() {
			this.setImage(ninja_12);
		}

		AnimationTimer turn_d = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (getTranslateY() <= 175)
					setTranslateY(getTranslateY() + 20);
			}
		};

		public void moveLeft() {
			turn_l.start();
		}

		public void stopLeft() {
			turn_l.stop();
		}

		public void moveRight() {
			turn_r.start();
		}

		public void stopRight() {
			turn_r.stop();
		}

		public void moveUp() {
			turn_u.start();
		}

		public void stopUp() {
			turn_u.stop();
		}

		void moveDown() {
			turn_d.start();
		}

		void stopDown() {
			turn_d.stop();
		}
	}