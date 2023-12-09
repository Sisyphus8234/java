package addition;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;
@Deprecated
public class UseJavafx extends Application {
    public static List<Argument> list = new ArrayList();
    public static class Argument {
        public double x, y, width, height,lineWidth;
        public Color color;

        public Argument(double x, double y, double width, double height,double lineWidth,Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.lineWidth=lineWidth;
            this.color=color;
        }
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.initStyle(StageStyle.TRANSPARENT); // 设置窗口样式为透明

        Pane root = new Pane();
        Scene scene = new Scene(root, Color.TRANSPARENT); // 设置场景背景为透明
        primaryStage.setScene(scene);

        for (Argument u : list) {
            Rectangle redBox1 = new Rectangle(u.x, u.y, u.width, u.height);
            redBox1.setFill(Color.TRANSPARENT);
            redBox1.setStroke(Color.RED);
            redBox1.setStrokeWidth(2);
            root.getChildren().addAll(redBox1);
        }


        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }




    public static void myStart1() {
//        launch();
        Application.launch(UseJavafx.class);
    }

    public static void myStop() {
        Platform.exit();


    }


    public static void drawBox(List<Argument> argumentList){
        list=argumentList;
        Thread thread=new Thread(){
            @Override
            public void run() {
                UseJavafx.myStart1();
            }
        };
        thread.start();
    }
}

