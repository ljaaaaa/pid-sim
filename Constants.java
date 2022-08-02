import java.awt.Color;

public class Constants {
        //Screen sizes
        public static final int FRAME_WIDTH = 1000;
        public static final int FRAME_HEIGHT = 750+38;

        //Spacing between lines on grid
        public static final int SPACE = 30;

	//Extra space before starting grid
	public static final int EXTRA = 25;

	//GraphPanel sizes
        public static final int GRID_WIDTH = FRAME_WIDTH-EXTRA;
        public static final int GRID_HEIGHT = (int)(FRAME_HEIGHT/2.5);

	//CarPanel sizes
	public static final int CAR_WIDTH = FRAME_WIDTH-EXTRA;
        public static final int CAR_HEIGHT = FRAME_HEIGHT-GRID_HEIGHT;

        //Color
        public static final Color GREY = new Color(230, 230, 230);
	public static final Color GREY2 = new Color(185, 185, 185);
        public static final Color POINT_COLOR = new Color(255, 0, 0);
        public static final Color TARGET_COLOR = new Color(0, 0, 255);

        //PID
        public static final double TARGET = 1;
        public static final double kP = 1.8;
        public static final double kD = 0.1;
        public static final double kI = 0.0;

        //Amount of time that passes each time Motor.getOutput() is run
        public static final double PASS_TIME = 1;
}
