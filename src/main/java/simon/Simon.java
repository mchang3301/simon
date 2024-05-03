package simon;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

// mvn exec:java -Dexec.mainClass=simon.Simon

public class Simon extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(final Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1920, 1080, Color.WHITE);
        Group subnode = new Group();
        subnode.setTranslateX(100);
        subnode.setTranslateY(100);
        root.getChildren().add(subnode);

        var rect = new Rectangle(50, 50, Color.BLUE);
        rect.setTranslateX(50);
        rect.setTranslateY(50);
        subnode.getChildren().add(rect);



        subnode.getChildren().add(text);

        Circle circle = new Circle(70, 20, 20);
        subnode.getChildren().add(circle);

        circle.setOnMouseClicked(evt -> {
            rect.setX(90);
        });

        Button btn = new Button(20, 30);


        primaryStage.setScene(scene);
        primaryStage.show();


    }

 


}