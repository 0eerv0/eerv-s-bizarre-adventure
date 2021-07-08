package main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import javafx.stage.Stage;
import javafx.util.Duration;
import playmode.Extra;
import playmode.Play;
import end.EndScreen;
import leaderboard.Leaderboard;

public class Game extends Application {
	Stage window;
	
	
	public void start(Stage arg0) throws Exception {
		window=arg0;
		Pane pane=new StackPane();
		Image img=new Image("/start_menu/start.png");  
		ImageView iv=new ImageView(img);
		iv.setFitHeight(600);
		iv.setFitWidth(1200);
		
		//Audio
        AudioClip ssound = new AudioClip(this.getClass().getResource("/start_menu/start.wav").toExternalForm());
        ssound.play();
        ssound.setCycleCount(MediaPlayer.INDEFINITE);
		
        //Button Zone
		
        Light.Distant light = new Light.Distant();
		 light.setAzimuth(45.0);
		 Lighting lighting = new Lighting();
		 lighting.setLight(light);
		 lighting.setSurfaceScale(2.0);
		 
		Button play=new Button("Play");
		Button leaderboard=new Button("Leaderboard");
		Button admin=new Button("Open when bored");
		
		play.setMaxWidth(190);
		leaderboard.setMaxWidth(190);
		admin.setMaxWidth(190);
		
		play.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");
		 leaderboard.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");
		 admin.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");
		play.setEffect(lighting);
		leaderboard.setEffect(lighting);
		admin.setEffect(lighting);
		
		
		 //Veprimet e butonave
		 play.setOnAction(new EventHandler<ActionEvent>(){

	
			public void handle(ActionEvent event) {
				
						(new Play()).view(arg0);
						ssound.stop();
					}
				
			}
			 
		 );
		 leaderboard.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {            
					try {
						(new Leaderboard()).start(arg0);
						ssound.stop();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}            
				                                      }				
				                                                   }
						 
					          );	
		
		admin.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event1){
				(new Extra()).start(arg0);
				ssound.stop();
			}
		});
		
	
		
		//VBox
	    VBox vb=new VBox();
	    vb.setSpacing(15);
		vb.getChildren().addAll(play,leaderboard,admin);
		vb.setAlignment(Pos.BOTTOM_LEFT);
		vb.setPadding(new Insets(50,20,50,50));
		pane.getChildren().add(iv);
		pane.getChildren().add(vb);
		       
       //Scene
		Scene scene = new Scene(pane, 1200, 600);
		arg0.setResizable(false);
		arg0.setScene(scene);
	    arg0.setTitle("eerv'S BIZARRE ADVENTURE");
	    arg0.getIcons().add(new Image("/start_menu/dragon-head.png"));
	    arg0.show();
		
	}
public static void main(String[] args) {
		launch(args);

	}
}
