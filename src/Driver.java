import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Driver extends Application implements EventHandler<ActionEvent>{

	static ArrayList<TvProgram> n = new ArrayList<>();

	Button b,b2;
	TextField tf,tf1,tf2,tf3;
	String kind = "";
	String type = "";
	BorderPane bp;
	static int counter;

	public static void main(String[] args) throws FileNotFoundException {

		File f = new File("programs.txt");
		Scanner input = new Scanner(f);
		if(f.exists())
		{
			while(input.hasNext()) {
				String s = input.nextLine();
				String [] t = s.split(":");
				if(t[0].equals("Movie")) {
					String[] t2 = t[1].split(",");

					if(t2.length==5) {
						n.add(new Movie(t2[0], Integer.parseInt(t2[1]), t2[2], t2[3], t2[4]));
					}

				}

				else if (t[0].equals("Sport")) {
					String [] to = t[1].split(",");
					if(to.length==5)
					{
						n.add(new Sport(to[0],Integer.parseInt(to[1]), to[2], to[3], to[4]));
					}


				}
			}




			Collections.sort(n);

		}
		input.close();

		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		bp = new BorderPane();


		GridPane pane = new GridPane();
		pane.add(new Label("Title = "), 0, 0);
		pane.add(new Label("year = "), 0, 1);
		pane.add(new Label("country = "), 0, 2);
		pane.add(new Label("language = "), 0, 3);

		tf = new TextField();
		pane.add(tf, 1, 0);

		tf1 = new TextField();
		pane.add(tf1, 1, 1);

		tf2= new TextField();
		pane.add(tf2, 1, 2);

		tf3 = new TextField();
		pane.add(tf3, 1, 3);
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);

		bp.setCenter(pane);

		HBox hb = new HBox();

		b = new Button("prev");
		b.setOnAction(this);

		b2 = new Button("next");
		b2.setOnAction(this);

		kind = n.get(0) instanceof Sport?"Sport":"Movie";
		type = n.get(0) instanceof Sport?(((Sport) n.get(0)).getType()):(((Movie) n.get(0)).getType());
		String status = ("TV Program Info:  " + kind + " (" + type + ")");



		tf.setText(n.get(0).getTitle());
		tf1.setText(n.get(0).getYear()+"");
		tf2.setText(n.get(0).getCountry());
		tf3.setText(n.get(0).getLanguage());
		bp.setTop(new Label(status));

		hb.getChildren().addAll(b,b2);
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(10);

		bp.setBottom(hb);

		Scene s = new Scene(bp,300,200);
		primaryStage.setTitle("Comp233: program navigtor");
		primaryStage.setScene(s);
		primaryStage.show();


	}

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource()==b) {

			if(counter==0)

				counter=4;

			else
				counter--;

			kind = n.get(0) instanceof Sport?"Sport":"Movie";
			type = n.get(0) instanceof Sport?(((Sport) n.get(0)).getType()):(((Movie) n.get(0)).getType());
			String status1=("TV Program Info:  " + kind + " (" + type + ")");


			tf.setText(n.get(counter).getTitle());
			tf1.setText(n.get(counter).getYear()+"");
			tf2.setText(n.get(counter).getCountry());
			tf3.setText(n.get(counter).getLanguage());
			bp.setTop(new Label(status1));


		}
		else
			if(counter<4)
				counter++;
			else
				counter=0;

		kind = n.get(0) instanceof Sport?"Sport":"Movie";
		type = n.get(0) instanceof Sport?(((Sport) n.get(0)).getType()):(((Movie) n.get(0)).getType());
		String status2=("TV Program Info:  " + kind + " (" + type + ")");


		tf.setText(n.get(counter).getTitle());
		tf1.setText(n.get(counter).getYear()+"");
		tf2.setText(n.get(counter).getCountry());
		tf3.setText(n.get(counter).getLanguage());
		bp.setTop(new Label(status2));




	}
}
