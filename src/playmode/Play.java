package playmode;

import java.util.ArrayList;

import eerv.Sprite;
import eerv.Shuriken;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import leaderboard.Leaderboard;
import main.Game;
import prof.Professor;
import end.EndScreen;

public class Play {
	Shuriken shuriken = new Shuriken();
	public  Professor professor = new Professor();

	/*public Rectangle2D getBoundary(){
        return new Rectangle2D(professor.getTranslateX(),professor.getTranslateY(),100,207);}
	public boolean intersects(Shuriken s)
    {
        return s.getBoundsInLocal().intersects( this.getBoundary() );
    }*/
	boolean shootReady = true;
	boolean phraseReady=true;
	public int points = 0;
	final static javafx.scene.image.Image ninja_0 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/mr_0.png").toString());
	final static javafx.scene.image.Image ninja_17 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/sho_l.png").toString());
	final static javafx.scene.image.Image ninja_18 = new javafx.scene.image.Image(
			Play.class.getResource("/Sprite/sho_r.png").toString());
	final static javafx.scene.image.Image prof_0 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/p_1.png").toString());
	final static javafx.scene.image.Image prof_2 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdl_0.png").toString());
	final static javafx.scene.image.Image prof_3 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdl_1.png").toString());
	final static javafx.scene.image.Image prof_4 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdr_0.png").toString());
	final static javafx.scene.image.Image prof_5 = new javafx.scene.image.Image(
			Play.class.getResource("/prof/pdr_1.png").toString());
	boolean right = false;
	boolean left = false;

	public int playerHP = 100;
	public int playercurrHP = playerHP;
	int plPoints = 0;

	public int profHP = 150;
	public int profcurrHP = profHP;
	int profPoints = 0;

	int countdown = 60;
	int currTime = countdown;
	int remMin = countdown / 60;
	int remSec = countdown % 60;

	public int initialEnergy = 110;
	public int currentEnergy = initialEnergy;

	public int profPhraseNumber = 0;
	private ArrayList<Shuriken> projectiles = new ArrayList<Shuriken>();

	public void view(Stage primaryStage) {
		Pane pane = new StackPane();
		Text vs = new Text("eerv                 vs               CODESSOR");
		vs.setFont(Font.font("Aclonica", FontWeight.BOLD, 50));
		vs.setFill(Color.WHITE);
		vs.setStroke(Color.BLACK);
		vs.setTranslateX(0);
		vs.setTranslateY(-280);

		// Audio
		AudioClip sound = new AudioClip(this.getClass().getResource("/play/play.wav").toExternalForm());
		sound.play();
		sound.setCycleCount(MediaPlayer.INDEFINITE);
		
		AudioClip oof = new AudioClip(this.getClass().getResource("/play/oof.mp3").toExternalForm());
		AudioClip omae = new AudioClip(this.getClass().getResource("/play/OmaeWa.mp3").toExternalForm());
		AudioClip nani = new AudioClip(this.getClass().getResource("/play/Nani.mp3").toExternalForm());
		// Sprite

		// ----eerv
		Sprite player = new Sprite();
		player.setTranslateX(-500);
		player.setTranslateY(140);

		// ----Professor
		Professor professor = new Professor();
		professor.setTranslateX(390);
		professor.setTranslateY(175);
/*Rectangle prof= new Rectangle(100,207);
prof.setTranslateX(professor.getTranslateX());
prof.setTranslateY(professor.getTranslateY());
pane.getChildren().add(prof);*/

		
		Rectangle showProfPhraseBackground = new Rectangle(250, 30);
		showProfPhraseBackground.setTranslateX(professor.getTranslateX() - 20);
		showProfPhraseBackground.setTranslateY(professor.getTranslateY() - 120);
		showProfPhraseBackground.setFill(Color.WHITE);
		showProfPhraseBackground.setArcWidth(10);
		showProfPhraseBackground.setArcHeight(10);
		pane.getChildren().add(showProfPhraseBackground);

		Text showProfPhrase = new Text(professor.getTranslateX(), professor.getTranslateY(), "");
		showProfPhrase.setTranslateX(professor.getTranslateX() - 20);
		showProfPhrase.setTranslateY(professor.getTranslateY() - 120);
		showProfPhrase.setFill(Color.BLACK);
		showProfPhrase.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		showProfPhrase.setStyle("-fx-background-radius:10; -fx-background-color:#9CD777;");
		pane.getChildren().add(showProfPhrase);

		// Background
		Image img2 = new Image("/play/source.gif");
		BackgroundImage img = new BackgroundImage(img2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
		BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background b = new Background(img);
		pane.setBackground(b);

		// pane.getChildren().add(iv);
		pane.getChildren().addAll(player);
		pane.getChildren().add(professor);
		pane.getChildren().add(vs);

		// Time

		Text showTime = new Text(1260, 30, "Remaining time " + remMin + ":" + remSec);
		showTime.setFill(Color.WHITE);
		showTime.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
		showTime.setStroke(Color.BLACK);
		pane.getChildren().add(showTime);

		showTime.setTranslateX(-55);
		showTime.setTranslateY(-200);

		// eerv's hp
		Rectangle HPfull = new Rectangle(1150, 50, 100, 30);
		HPfull.setFill(Color.FORESTGREEN);
		HPfull.setArcWidth(10);
		HPfull.setArcHeight(10);
		pane.getChildren().add(HPfull);
		HPfull.setTranslateX(-500);
		HPfull.setTranslateY(-200);

		Rectangle HPelapsed = new Rectangle(1150, 50, 1, 30);
		HPelapsed.setFill(Color.DARKRED);
		HPelapsed.setArcHeight(10);
		HPelapsed.setArcHeight(10);
		pane.getChildren().add(HPelapsed);
		HPelapsed.setTranslateX(-500);
		HPelapsed.setTranslateY(-200);

		Text showHP = new Text(1260, 70, "HP:" + playercurrHP);
		showHP.setFill(Color.WHITE);
		showHP.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		pane.getChildren().add(showHP);
		showHP.setTranslateX(-500);
		showHP.setTranslateY(-200);

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
			
			if(countdown==3){
				sound.stop();
				oof.stop();
				omae.play();
				
			countdown = countdown - 1;}
			else if (countdown==1){
				sound.stop();
				oof.stop();
				nani.play();
				countdown = countdown - 1;
			}

			else if (countdown > 0)
				countdown = countdown - 1;
			else {

				try {
					(new EndScreen()).start(primaryStage);
					sound.stop();
					oof.stop();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			remMin = countdown / 60;
			remSec = countdown % 60;

			if (currTime > 0)
				if (currTime % 5 == 0) {

					playercurrHP = playercurrHP - 2;
					if (playercurrHP < 0) {
						playercurrHP = 0;
						try {
							(new EndScreen()).start(primaryStage);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					profPhraseNumber = profPhraseNumber + 1;
					if (profPhraseNumber == 6)
						profPhraseNumber = 1;
					if (profPhraseNumber == 1)
						showProfPhrase.setText("System.out.println(You Lose)");
					oof.play();
					oof.stop();
					if (profPhraseNumber == 2)
						showProfPhrase.setText("import java.Yougonna.Fail;");
					
					if (profPhraseNumber == 3)
						showProfPhrase.setText("max can get:60.2");
					oof.play();
					if (profPhraseNumber == 4)
						showProfPhrase.setText("patheticChild.setStyle()");
					if (profPhraseNumber == 5)
						showProfPhrase.setText("boolean mercy=false");
					oof.play();
					if (profPhraseNumber == 6)
						showProfPhrase.setText("error 404: 30 pike bonus not found");
					if (profPhraseNumber == 7)
						showProfPhrase.setText("KU JAN MODULEET?!?!?!?!");
					oof.play();
					if (profPhraseNumber == 8)
						showProfPhrase.setText("YOU CALL THIS A PROJECT?!?!?!");
					if (profPhraseNumber == 9)
						showProfPhrase.setText("LOL");
					oof.play();
					if (profPhraseNumber == 10)
						showProfPhrase.setText("boolean pushim=false");
					}

					showProfPhrase.setTranslateX(professor.getTranslateX() - 20);
					showProfPhrase.setTranslateY(professor.getTranslateY() - 120);
					showProfPhraseBackground.setTranslateX((professor.getTranslateX() - 20));
					showProfPhraseBackground.setTranslateY(professor.getTranslateY() - 120);
					

					showHP.setText("HP: " + playercurrHP);

				/* else {
					showProfPhrase.setText("");
					showProfPhraseBackground.setWidth(0);
				}*/
			showTime.setText("Remaining time " + remMin + ":" + remSec);
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();

		// Professor's HP
		Rectangle ProfHPfull = new Rectangle(1150, 50, 100, 30);
		ProfHPfull.setFill(Color.FORESTGREEN);
		ProfHPfull.setArcWidth(10);
		ProfHPfull.setArcHeight(10);
		pane.getChildren().add(ProfHPfull);
		ProfHPfull.setTranslateX(500);
		ProfHPfull.setTranslateY(-200);

		Rectangle ProfHPelapsed = new Rectangle(1150, 50, 1, 30);
		ProfHPelapsed.setFill(Color.DARKRED);
		ProfHPelapsed.setArcHeight(10);
		ProfHPelapsed.setArcHeight(10);
		pane.getChildren().add(ProfHPelapsed);
		ProfHPelapsed.setTranslateX(500);
		ProfHPelapsed.setTranslateY(-200);

		Text ProfshowHP = new Text(1260, 70, "HP:" + profcurrHP);
		ProfshowHP.setFill(Color.WHITE);
		ProfshowHP.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		pane.getChildren().add(ProfshowHP);
		ProfshowHP.setTranslateX(500);
		ProfshowHP.setTranslateY(-200);

		Rectangle sprite = new Rectangle();
		sprite.setX(player.getX());
		sprite.setY(player.getY());
		sprite.setFill(Color.WHITE);
		sprite.setTranslateX(player.getTranslateX());
		sprite.setTranslateY(player.getTranslateY());
		pane.getChildren().add(sprite);
		// Scene
		Scene scene = new Scene(pane, 1200, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("eerv'S BIZARRE ADVENTURE");

		// Timeline

		Timeline t = new Timeline();
		t.setCycleCount(Timeline.INDEFINITE);

		AnimationTimer timer = new AnimationTimer() {
			int counter = 0;

			public void handle(long now) {
				if (counter < 40) {
					counter++;
				} else {
					counter = 0;
					shootReady = true;
				}

			}
		};
		AnimationTimer timer2 = new AnimationTimer() {
			int counter = 0;

			public void handle(long now) {
				if (counter < 40) {
					counter++;
				} else {
					counter = 0;
					phraseReady = true;
				}

			}
		};
		timer.start();
		timer2.start();

		// Keyboard action
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case D:
					left = true;
					player.moveRight();
					break;
				case A:
					left = false;
					player.moveLeft();
					break;
				case W:
					player.moveUp();
					break;
				case SPACE:
					
					if (left == true) {
						player.setImage(ninja_18);
						if (shootReady) {
							shootReady = false;
							createShurikenRight(new Shuriken(), pane, player);
							if (shuriken.intersects(professor.getBoundsInLocal())){
					            ProfshowHP.setText("HP: " + profcurrHP);
								profcurrHP=profHP-5;
								//pane.getChildren().remove(shuriken);
							}
						}
					} else {
						player.setImage(ninja_17);
						if (shootReady) {
							shootReady = false;
							createShurikenLeft(new Shuriken(), pane, player);
							if (shuriken.intersects(professor.getBoundsInLocal())){
					            ProfshowHP.setText("HP: " + profcurrHP);
								profcurrHP=profHP-5;}
						}pane.getChildren().remove(shuriken);
					}
					break;
				case DOWN:
					// dodge
					if (right) {
						professor.setImage(prof_4);
						professor.setImage(prof_5);

					} else {
						professor.setImage(prof_2);
						professor.setImage(prof_3);
					}

					break;
				case LEFT:
					right = false;
					professor.prof_turn_l.start();
					break;
				case RIGHT:
					right = true;
					professor.prof_turn_r.start();
					break;
				}
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
				case A:
					player.stopLeft();
					break;
				case D:
					player.stopRight();
					break;
				case W:
					player.stopUp();
					break;
				case SPACE:
					player.setImage(ninja_0);
				case UP:

					break;
				case DOWN:
					professor.setImage(prof_0);
					break;
				case LEFT:
					professor.prof_turn_l.stop();
					break;
				case RIGHT:
					professor.prof_turn_r.stop();
					break;
				case ENTER:

					break;
				}
			}
		});

		AnimationTimer timer1 = new AnimationTimer() {
			public void handle(long now) {
				ObservableList<Node> p = pane.getChildren();
				try {
					for (Node i : p) {
						if (i instanceof Shuriken) {
							if (((Shuriken) i).isSet()) {
								p.remove(i);
							}
						}
					}
				} catch (Exception e) {

				}

			}
		};
		timer1.start();

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void createShurikenRight(Shuriken shuriken, Pane pane, Sprite player) {
		shuriken.setTranslateX(player.getTranslateX() + 55);
		shuriken.setTranslateY(player.getTranslateY() - 65);
		pane.getChildren().add(shuriken);
		shuriken.shoot_right();

		if (shuriken.getTranslateX()==professor.getTranslateX()){
			pane.getChildren().remove(shuriken);
			
		}
	}
	

	public void createShurikenLeft(Shuriken shuriken, Pane pane, Sprite player) {
		shuriken.setTranslateX(player.getTranslateX() - 55);
		shuriken.setTranslateY(player.getTranslateY() - 65);
		pane.getChildren().add(shuriken);
		shuriken.shoot_left();
	}

	}

