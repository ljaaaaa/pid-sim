import java.awt.Color;

public class Constants {
    //Screen sizes
    public static final int FRAME_WIDTH = 900;
    public static final int FRAME_HEIGHT = 550+38;

    //Grid size
    public static final int GRID_WIDTH = 800;
    public static final int GRID_HEIGHT = 500;

    //Spacing between lines on grid
    public static final int SPACE = 10;

    //Extra space before starting grid
    public static final int EXTRA = 25;

    //Color
    public static final Color GREY = new Color(220, 220, 220);
    public static final Color POINT_COLOR = new Color(255, 0, 0);
    public static final Color TARGET_COLOR = new Color(0, 0, 255);

    //PID
    public static final double TARGET = 20;
    public static final double kP = 1.9;
    public static final double kD = 0.0;
    public static final double kI = 0.0;
}