package playmode;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Extra extends Application {
	Stage window;
		
	
	public void start(Stage arg0) {
		
	
			window=arg0;
			MediaPlayer extra = new MediaPlayer( new Media(getClass().getResource("/extra/extra.mp4").toExternalForm()));
	        MediaView video = new MediaView(extra);
	        video.setFitHeight(1200);
			video.setFitWidth(1200);
			Pane pane=new StackPane();
			pane.getChildren().add(video);
			Scene scene = new Scene(pane, 1200, 600);
			arg0.setResizable(false);
			arg0.setScene(scene);
		    arg0.setTitle("eerv'S BIZARRE ADVENTURE");
		    arg0.getIcons().add(new Image("/start_menu/dragon-head.png"));
		    arg0.show();
		    extra.play();
	}
	public static void main(String[] args) {
		launch(args);

	}
}