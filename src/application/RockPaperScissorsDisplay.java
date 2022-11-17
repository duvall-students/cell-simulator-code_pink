package application;

import java.awt.Point;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class RockPaperScissorsDisplay extends Application {

	/* 
	 * GUI settings
	 */
	private final int MILLISECOND_DELAY = 15;	// speed of animation
	private final int EXTRA_VERTICAL = 100; 	// GUI area allowance when making the scene width
	private final int EXTRA_HORIZONTAL = 150; 	// GUI area allowance when making the scene width
	private final int BLOCK_SIZE = 25;     		// size of each cell in pixels
	private final int INITIAL_NUM_OF_ROWS = 18; // initial number of rows
	private final int INITIAL_NUM_OF_COLS = 18; // initial number of rows

	private Scene myScene;						// the container for the GUI
	private boolean paused = false;	
	private Button pauseButton;

	private Rectangle[][] mirrorModel;	// the Rectangle objects that will get updated and drawn.  It is 
	// called "mirror" maze because there is one entry per square in 
	// the maze.

	/*
	 * Maze color settings
	 */
	private Color[] color  = new Color[] {
			Color.rgb(0,0,0),		// edge cell color
			Color.RED,				// rock cell color
			Color.WHITE,			// paper cell color
			Color.BLUE		// scissors cell color
	};  		// the color of each of the states  

	RockPaperScissors rps;
	RockPaperScissorsDisplay rpsDisplay;
	RockPaperScissorsController rpsController = new RockPaperScissorsController(rpsDisplay);

	//private Rectangle [][] mirrorModel;

	// Start of JavaFX Application
	public void start(Stage stage) {
		//rpsController = new RockPaperScissorsController(this);

		// Initializing the gui
		myScene = setupScene();
		stage.setScene(myScene);
		stage.setTitle("RockPaperScissors");
		stage.show();

		// Makes the animation happen.  Will call "step" method repeatedly.
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(MILLISECOND_DELAY));
		Timeline animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();	
	}

	private Group setupModel(){
		Group drawing = new Group();
		Rectangle[][] mirrorModel = new Rectangle[(rpsController.getRows())][(rpsController.getColumns())];
		for(int i = 0; i< (rpsController.getRows()); i++){
			for(int j =0; j < (rpsController.getColumns()); j++){
				Rectangle rect = new Rectangle(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);
				rect.setFill(color[rpsController.getCellState(new Point(i,j))]);
				mirrorModel[i][j] = rect;
				drawing.getChildren().add(rect);
			}	
		}
		
		return drawing;
	}
	
	// Create the scene - Controls and Simulation areas
	private Scene setupScene () {
		// Make three container 
		Group modelDrawing = setupModel();
		VBox userInputDimensions = setUpDimensionsTextField();
		HBox controls = setupControlButtons();

		VBox root = new VBox();
		root.setAlignment(Pos.TOP_CENTER);
		root.setSpacing(10);
		root.setPadding(new Insets(10, 10, 10, 10));
		root.getChildren().addAll(modelDrawing,controls);
		
		Scene scene = new Scene(root, (rpsController.getColumns())*BLOCK_SIZE+ EXTRA_HORIZONTAL, 
				(rpsController.getRows())*BLOCK_SIZE + EXTRA_VERTICAL, Color.ANTIQUEWHITE);

		return scene;
	}

	private VBox setUpDimensionsTextField() {
		// Set up user input area
		VBox dimensions = new VBox();
		dimensions.setAlignment(Pos.TOP_CENTER);

		TextField userInputArea = new TextField();
		dimensions.getChildren().add(userInputArea);
		return dimensions;
	}

	private HBox setupControlButtons(){
		// Make the controls part
		HBox controls = new HBox();
		controls.setAlignment(Pos.BASELINE_CENTER);
		controls.setSpacing(10);

		Button newSimulationButton = new Button("New Simulation");
		newSimulationButton.setOnAction(value ->  {
			// rpsController.newSimulation();
		});
		controls.getChildren().add(newSimulationButton);

		pauseButton = new Button("Pause");
		pauseButton.setOnAction(value ->  {
			// rpsController();
		});
		controls.getChildren().add(pauseButton);

		Button stepButton = new Button("Step");
		stepButton.setOnAction(value ->  {
			// rpsController.doOneStep(MILLISECOND_DELAY);
		});
		controls.getChildren().add(stepButton);
		return controls;
	}
	/*
	 * resets all the rectangle colors according to the 
	 * current state of that rectangle in the maze.  This 
	 * method assumes the display maze matches the model maze
	 */
	/* public void redraw(){
		for(int i = 0; i< mirrorMaze.length; i++){
			for(int j =0; j < mirrorMaze[i].length; j++){
				mirrorMaze[i][j].setFill(color[mazeController.getCellState(new Point(i,j))]);
			}
		}
	} */
	
	/*
	 * Toggle the pause button
	 */
	public void pressPause(){
		this.paused = !this.paused;
		if(this.paused){
			pauseButton.setText("Resume");
		}
		else{
			pauseButton.setText("Pause");
		}
	}

	/*
	 * Pause the animation (regardless of current state of pause button)
	 */
	public void pauseIt(){
		this.paused = true;
		pauseButton.setText("Resume");
	}
	/*
	 * Does a step in the search only if not paused.
	 */
	public void step(double elapsedTime){
		if(!paused) {
			// rpsController.doOneStep(elapsedTime);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
