package application;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class Main extends Application{
	BorderPane BP = new BorderPane();
	VBox VB = new VBox();
	Label sign = new Label("Sign In");
	TextField email = new TextField("Email Address");
	TextField password = new TextField("Password");
	Button sBtn = new Button("Sign In");
	HBox HB = new HBox();
	Hyperlink forgot = new Hyperlink("Forgot Tomi?");	// implementing my name into the work
	Hyperlink help = new Hyperlink("Help");
	Dialog<String> wrong = new Dialog<String>();
	Dialog<String> right = new Dialog<String>();
	boolean correct = false;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		//stylizing the elements
		sign.setFont(new Font("Calibri", 30));
		email.setFont(new Font("Calibri", 15));
		email.setMaxWidth(300);
		password.setFont(new Font("Calibri", 15));
		password.setMaxWidth(300);
		sBtn.setFont(new Font("Calibri", 15));
		sBtn.setStyle("-fx-background-color: blue");
		forgot.setFont(new Font("Calibri", 12));
		help.setFont(new Font("Calibri", 12));
		wrong.setTitle("Wrong Info");
		wrong.setContentText("“User Name or Password is incorrect");
		right.setTitle("Right");
		right.setContentText("“You are successfully login");
		
		HB.setSpacing(175);
		HB.getChildren().addAll(forgot, help);
		HB.setMaxWidth(300);
		
		//putting elements into the vbox
		VB.setSpacing(20);
		VB.getChildren().addAll(sign, email, password, sBtn, HB);
		VB.setAlignment(Pos.CENTER);
		
		//putting elements into the borderpane
		BP.setCenter(VB);
		
		//event handling
		sBtn.setOnAction(new trySignIn());
		forgot.setOnAction(new silly());
		help.setOnAction(new silly());
		
		Scene scene = new Scene(BP,400,400);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Question 1!");
		primaryStage.show();
	}
	
	// when they press the signin button
	class trySignIn implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(!correct) {
				wrong.show();
			} else {
				right.show();
			}
			//
		}
	}
	
	// when they press the forgot tomi button or help button
		class silly implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent e) {
				try {
					Image image = new Image(new FileInputStream("blehhhhh.jpg"));
					ImageView IV = new ImageView(image);
					BorderPane BB = new BorderPane();
					BB.setCenter(IV);
					Scene sc = new Scene(BB);
					Stage stg = new Stage();
					stg.setScene(sc);
					stg.show();
					
				} catch (FileNotFoundException e1) {
					System.out.println("oops");
				}  
			}
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
