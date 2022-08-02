import java.awt.Color;

public class Constants {
        //Screen sizes
        public static final int FRAME_WIDTH = 1000;
        public static final int FRAME_HEIGHT = 750+38;

        //Spacing between lines on grid
        public static final int SPACE = 10;

	//Target for car to reach in meters
	public static final int TARGET = 3;
	
        //Color
	public static class Colors {
        	public static final Color GREY_LOW = new Color(230, 230, 230);
		public static final Color GREY_MED = new Color(190, 190, 190);
       		public static final Color GREY_HIGH = new Color(150, 150, 150);
		public static final Color BLACK = new Color(45, 45, 45);
		public static final Color POINT = new Color(180, 0, 0);
        	public static final Color TARGET = new Color(0, 0, 255);
	}

        //PID constants
	public static class PID {
        	public static final double kP = 0.8;
        	public static final double kD = 0.0;
        	public static final double kI = 0.0;
	}
}
