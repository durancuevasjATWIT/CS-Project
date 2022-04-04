package application;
	
import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application
{
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
		
		
		int level = 1;	
		int numberOfEnemies = 10;
		Enemy[] enemy = new Enemy[numberOfEnemies];
		
		for (int i = 0; i < numberOfEnemies ; i++)
		{
			enemy[i].setIsAlive();
			enemy[i].spawnLocation();
		}
		
		if(numberOfEnemies == 0)
		{
			for (int i = 0; i < numberOfEnemies ; i++)
			{
				enemy[i].update(level);
			}			
		}		
		
	}

}
