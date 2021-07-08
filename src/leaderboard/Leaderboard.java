package leaderboard;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.Game;
import playmode.Play;

public class Leaderboard extends Application {
	
	@Override
	public void start(Stage arg0) throws Exception {
		Pane pane=new Pane();
		Image backgroundImage=new Image("/leaderboard/leaderboard.png");  
    ImageView backgroundImageView=new ImageView(backgroundImage);
    backgroundImageView.setFitHeight(600);
    backgroundImageView.setFitWidth(1200);
      pane.getChildren().add(backgroundImageView);
    Button back=new Button("Back");
    back.setMinWidth(120);	
    back.setTranslateX  (30); 
    back.setTranslateY (20);
    back.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");
pane.getChildren().add(back);
back.setOnAction(new EventHandler<ActionEvent>(){
	public void handle(ActionEvent event) {            
		try {
			(new Game()).start(arg0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}          
	                                      }				
	                                                   }
			 
		          );
		
    File file = new File(System.getProperty("user.dir") + "\\src\\history.txt");
    String allHistory="    Date                             Professor";
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		String line;
		while ((line = br.readLine()) != null) {
			allHistory=allHistory + "\n" + line;
		}
                    
                         Text history= new Text (50,400,allHistory); 
                         history.setFill(Color.WHITE);   history.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
                         history.setStyle("-fx-background-radius:10; -fx-background-color:#660000;");
                         pane.getChildren().add(history);
   
	} catch (IOException e) {
		e.printStackTrace();
	}

	Scene scene = new Scene(pane, 1200, 600);
	arg0.setResizable(false);
	arg0.setScene(scene);
    arg0.setTitle("eerv'S BIZARRE ADVENTURE");
   
    arg0.show();
	}
	public static void main(String[] args) {
		launch(args);

	}
    }
