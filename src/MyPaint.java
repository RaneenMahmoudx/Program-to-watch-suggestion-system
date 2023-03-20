
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class MyPaint extends Application {

	Color c = Color.BLACK;
	double sx, sy, ex, ey;
	boolean start = false;
	Circle cs = new Circle();
	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		BorderPane bp = new BorderPane();

		Pane p = new Pane();
		p.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		bp.setCenter(p);

		VBox main = new VBox();
		VBox colorBox = new VBox();

		RadioButton brb = new RadioButton("Black");
		RadioButton rrb = new RadioButton("Red");
		RadioButton grb = new RadioButton("Green");
		RadioButton wrb = new RadioButton("White");

		RadioButton lrb = new RadioButton("Eraser");
		brb.setSelected(true);
		ToggleGroup tg = new ToggleGroup();
		brb.setToggleGroup(tg);
		rrb.setToggleGroup(tg);
		grb.setToggleGroup(tg);
		wrb.setToggleGroup(tg);
		lrb.setToggleGroup(tg);
		colorBox.setSpacing(15);
		colorBox.getChildren().addAll(new Label("Color"), brb, rrb, grb, wrb, lrb);
		main.getChildren().add(colorBox);

		brb.setOnAction(e -> this.c = Color.BLACK);
		rrb.setOnAction(e -> this.c = Color.RED);
		grb.setOnAction(e -> this.c = Color.GREEN);
		wrb.setOnAction(e -> this.c = Color.WHITE);
		lrb.setOnAction(e -> this.c = Color.LIGHTGRAY);
		
		VBox shapeBox = new VBox();
		RadioButton dsrb = new RadioButton("Dot");
		RadioButton csrb = new RadioButton("Circle");
		RadioButton rsrb = new RadioButton("Rectangle");
		ToggleGroup stg = new ToggleGroup();
		dsrb.setToggleGroup(stg);
		dsrb.setSelected(true);
		csrb.setToggleGroup(stg);
		rsrb.setToggleGroup(stg);
		shapeBox.getChildren().addAll(new Label("Shape"), dsrb, csrb, rsrb);
		main.getChildren().add(shapeBox);
		main.setSpacing(30);
		shapeBox.setSpacing(15);
		Button clear = new Button("Clear");
		bp.setBottom(clear);
		bp.setAlignment(clear, Pos.CENTER);
		clear.setOnAction(e -> p.getChildren().clear());
		bp.setLeft(main);
		Scene s = new Scene(bp, 500, 500);
		stage.setScene(s);
		stage.show();

		p.setOnMousePressed(e -> {
			sx = e.getX();
			sy = e.getY();
			start = true;
			cs = new Circle(sx,sy,5);
			cs.setStroke(c);
			cs.setFill(Color.TRANSPARENT);
			p.getChildren().add(cs);
		});

//		p.setOnMouseReleased(e -> {
//			ex = e.getX();
//			ey = e.getY();
//			start = false;
//			System.out.println("end");
//
//			if (csrb.isSelected()) {
//				Point2D sp = new Point2D(sx, sy);
//				Point2D ep = new Point2D(ex, ey);
//				double r = sp.distance(ep);
//				Circle cs = new Circle(sx, sy, r);
//				
//				p.getChildren().add(cs);
//			}
//		});

		p.setOnMouseDragged(e -> {
			if (dsrb.isSelected()) {
				Circle c = new Circle(e.getX(), e.getY(), 3);
				c.setFill(this.c);
				p.getChildren().add(c);
			}
			
			if(csrb.isSelected()){
				ex = e.getX();
				ey = e.getY();
				Point2D sp = new Point2D(sx, sy);
				Point2D ep = new Point2D(ex, ey);
				double r = sp.distance(ep);
				cs.setRadius(r);
			}
		});

		p.setOnDragExited(e -> {
			System.out.println(e.getX() + " , " + e.getY());
		});

	}

}
