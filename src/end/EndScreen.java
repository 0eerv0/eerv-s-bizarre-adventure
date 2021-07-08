package end;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import leaderboard.Leaderboard;
import main.Game;
import playmode.Play;

public class EndScreen extends Application {
Timeline timeline;

	public void start(Stage arg0) throws Exception {

		Image backgroundImage=new Image("/end/end.jpg");
	    ImageView view=new ImageView(backgroundImage);
	    view.setFitHeight(600);
	    view.setFitWidth(1200);
	    Pane pane=new Pane();
	    pane.getChildren().add(view);
	    Scene scene = new Scene(pane, 1200, 600);
		arg0.setResizable(false);
		arg0.setScene(scene);
	    arg0.show();
	    
	    Button back=new Button("Back");
	    back.setMinWidth(120);	
	    back.setTranslateX  (30); 
	    back.setTranslateY (20);
	    back.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");

	    Button Leaderboard=new Button("Leaderboard");
	    Leaderboard.setMinWidth(120);	
	    Leaderboard.setTranslateX  (30); 
	    Leaderboard.setTranslateY (70);
	    Leaderboard.setStyle("-fx-background-color: linear-gradient(#660000,#be1d00);-fx-background-radius: 30;-fx-background-insets: 0; -fx-text-fill: white;");

	    
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
	    		
	        //Veprimet i butonit Leaderboard
	        Leaderboard.setOnAction(new EventHandler<ActionEvent>(){
	    	public void handle(ActionEvent event) {            
	    		try {
	    			(new Leaderboard()).start(arg0);
	    		} catch (Exception e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}         
	    	                                      }				
	    	                                                   }
	    			 
	    		          );
	     pane.getChildren().clear();        
	     pane.getChildren().add(view);
	     pane.getChildren().add(back);
	     pane.getChildren().add(Leaderboard); 
	     scene.setOnKeyPressed (null);
	     
	       
			
	   String path = System.getProperty("user.dir") + "\\src\\history.txt";
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	        LocalDateTime now = LocalDateTime.now();  
	        String text = dtf.format(now) + "        " + "Professor" +"\n";
	        try {
	            timeline.stop();
	            FileWriter fw = new FileWriter(path, true);
	            fw.write(text);
	            fw.close();
	        }
	        catch(IOException e) {
	        }
}

}
