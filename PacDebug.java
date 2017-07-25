package sample;

import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PacDebug extends Application{

	final int WIDTH = 800;
	final int HEIGHT = 600;
	int ClientWidth = WIDTH;
	int ClientHeight = HEIGHT;

	int cx = 0;
	int cy = 0;
	int dx = 2;
	int dy = 0;

	double origin_x = WIDTH-100;
	double origin_y = HEIGHT/2;

//	ArrayList<Line> line = new ArrayList<Line>();
	final Canvas canvas = new Canvas(WIDTH,HEIGHT);
	Group root = new Group();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("PacDebug");
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT);
		stage.initStyle(StageStyle.UTILITY); // クローズボックスのみの構成
		stage.centerOnScreen(); // 画面中央に配置
		stage.setResizable(false); //画面サイズ変更不可能

		canvas.setOnKeyPressed(event -> onKeyPressed(event));
		canvas.setFocusTraversable(true);

		root.getChildren().add(canvas);

		stage.setScene(new Scene(root));
		stage.show();

		ClientHeight = (int) stage.getScene().getHeight();
		ClientWidth = (int) stage.getScene().getWidth();
		cx = ClientWidth / 2;
		cy = ClientHeight / 2;

		Timer timer = new Timer();
		class GameTask extends TimerTask {
			@Override
			public void run(){
				cx += dx;
				cy += dy;

			}
		}

		GameTask task = new GameTask();
		stage.setOnCloseRequest(event -> {
			if(task != null)task.cancel();
			if(timer != null)timer.cancel();
		});

		timer.schedule(task, 1000, 100);
		Toolkit.getDefaultToolkit().beep();

		Init();
		Draw();
	}

	void onKeyPressed(KeyEvent event) {
		if(event.getCode()==KeyCode.UP ){ dx = 0; dy = -2;}
		if(event.getCode()==KeyCode.DOWN ){ dx = 0; dy = 2;}
		if(event.getCode()==KeyCode.RIGHT ){ dx = 2; dy = 0;}
		if(event.getCode()==KeyCode.LEFT ){ dx = -2; dy = 0;}
	}
	public void Init(){
		Line under_line = new Line(WIDTH,200 + HEIGHT/2,0,200 + HEIGHT/2);
		under_line.setStroke(Color.GRAY);
		under_line.setStrokeWidth(3);
		root.getChildren().add(under_line);

		Line over_line = new Line(WIDTH,-200 + HEIGHT/2,0,-200 + HEIGHT/2);
		over_line.setStroke(Color.GRAY);
		over_line.setStrokeWidth(3);
		root.getChildren().add(over_line);

		Line left_line = new Line(origin_x - 600,200 + origin_y,origin_x - 600,-200 + origin_y);
		left_line.setStroke(Color.GRAY);
		left_line.setStrokeWidth(3);
		root.getChildren().add(left_line);

		Circle arm = new Circle(origin_x,origin_y,200, Color.DARKGRAY);
		root.getChildren().add(arm);
	}
	public void Draw(){
		Hitohude b1 = new Hitohude(Color.BLUE);
		b1.Move(-15, 425);
		b1.Move(-15, 455);
		b1.Move( 20, 455);
		b1.Move( 20, 425);
		b1.Move( 25, 425);
		b1.Move( 25, 375);
		b1.Move(-20, 375);
		b1.Move(-20, 425);
		b1.Move( 20, 425);

		Hitohude b2 = new Hitohude(Color.BLUE);
		b2.Move( -15, 365);
		b2.Move( -20, 365);
		b2.Move( -20, 345);
		b2.Move( -15, 345);

		Hitohude b3 = new Hitohude(Color.BLUE);
		b3.Move( -5, 365);
		b3.Move( 0, 365);
		b3.Move( 0, 345);
		b3.Move( -5, 345);

		Hitohude b4 = new Hitohude(Color.BLUE);
		b4.Move( 10, 365);
		b4.Move( 5, 365);
		b4.Move( 5, 345);
		b4.Move( 10, 345);

		Hitohude b5 = new Hitohude(Color.BLUE);
		b5.Move( 20, 365);
		b5.Move( 25, 365);
		b5.Move( 25, 345);
		b5.Move( 20, 345);

//*****************************************************
		Hitohude y1 = new Hitohude(Color.YELLOW);
		y1.Move( -10, 455);
		y1.Move( -10, 445);
		y1.Move(  15, 445);
		y1.Move(  15, 455);

		Hitohude y2 = new Hitohude(Color.YELLOW);
		y2.Move( -10, 440);
		y2.Move( -10, 430);
		y2.Move(  -5, 430);
		y2.Move(  -5, 440);
		y2.Move( -10, 440);

		Hitohude y3 = new Hitohude(Color.YELLOW);
		y3.Move( 10, 440);
		y3.Move( 10, 430);
		y3.Move( 15, 430);
		y3.Move( 15, 440);
		y3.Move( 10, 440);

		Hitohude y4 = new Hitohude(Color.YELLOW);
		y4.Move( -15, 375);
		y4.Move( -15, 360);
		y4.Move(  -5, 360);
		y4.Move(  -5, 375);

		Hitohude y5 = new Hitohude(Color.YELLOW);
		y5.Move( 10, 375);
		y5.Move( 10, 360);
		y5.Move( 20, 360);
		y5.Move( 20, 375);
//*****************************************************
		Hitohude r1 = new Hitohude(Color.RED);
		r1.Move( -20, 420);
		r1.Move( -35, 420);
		r1.Move( -35, 405);
		r1.Move( -20, 405);

		Hitohude r2 = new Hitohude(Color.RED);
		r2.Move( 25, 420);
		r2.Move( 40, 420);
		r2.Move( 40, 405);
		r2.Move( 25, 405);

		Hitohude r3 = new Hitohude(Color.RED);
		r3.Move( -35, 405);
		r3.Move( -35, 375);
		r3.Move( -25, 375);
		r3.Move( -25, 405);

		Hitohude r4 = new Hitohude(Color.RED);
		r4.Move( 40, 405);
		r4.Move( 40, 375);
		r4.Move( 30, 375);
		r4.Move( 30, 405);

		Hitohude r5 = new Hitohude(Color.RED);
		r5.Move( -35, 375);
		r5.Move( -35, 360);
		r5.Move( -30, 360);
		r5.Move( -30, 375);

		Hitohude r6 = new Hitohude(Color.RED);
		r6.Move( 40, 375);
		r6.Move( 40, 360);
		r6.Move( 35, 360);
		r6.Move( 35, 375);

		Hitohude r7 = new Hitohude(Color.RED);
		r7.Move( -15, 340);
		r7.Move( -15, 355);
		r7.Move(  -5, 355);
		r7.Move(  -5, 340);
		r7.Move(  -0, 340);
		r7.Move(  -0, 335);
		r7.Move( -20, 335);
		r7.Move( -20, 340);
		r7.Move(  -5, 340);

		Hitohude r8 = new Hitohude(Color.RED);
		r8.Move( 10, 340);
		r8.Move( 10, 355);
		r8.Move( 20, 355);
		r8.Move( 20, 340);
		r8.Move( 25, 340);
		r8.Move( 25, 335);
		r8.Move(  5, 335);
		r8.Move(  5, 340);
		r8.Move( 20, 340);
	}
	public class Hitohude{
		ArrayList<Point> dot = new ArrayList<Point>();
		Point now_dot = new Point();
		Point past_dot = new Point();
		boolean first_call = true;
		Color color;
		public Hitohude(Color c){
			color = c;
		}
		public void Move(int x,int y){
			past_dot.x = now_dot.x;
			past_dot.y = now_dot.y;
			now_dot.setLocation(-y + origin_x,-x + origin_y);
			// 画面外に描写でエラー吐かせる
			if(now_dot.x < 0 || WIDTH < now_dot.x || now_dot.y < 0 || HEIGHT < now_dot.y){
			    Text    t       = new Text(
			    		100,
			    		50,
			    		"エラーしてますよ"
			    );
//			    t.setFont(new Font(20));
			    t.setFill(Color.RED);
			    t.setWrappingWidth( 700.0 );
			    t.setUnderline( true );
			    root.getChildren().add( t );

			}
			// 初めの点では描写を行わない
			if(first_call == true){
				first_call = false;
				return;
			}
			Line line = new Line(past_dot.x,past_dot.y,now_dot.x,now_dot.y);
			line.setStroke(color);
			line.setStrokeWidth(1);

			root.getChildren().add(line);

//	        GraphicsContext gc = canvas.getGraphicsContext2D();
//			gc.setFill(Color.BLUE);
//			gc.fillRect(now_dot.x,now_dot.y,20,20);

		}
	}

	public static void main(String[] args) {
	  	launch(args);
	}

}
