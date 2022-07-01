import java.util.ArrayList;

public class MyTime {
 
    private double time;
    public ArrayList<MyPoint> points;
    public Motor motor;

    public MyTime(Motor motor) {
        points = new ArrayList<>();
        this.motor = motor;
        time = 1;
        addPoint(0, 0);
    }   

    public void addPoint(int x, int y){
        points.add(new MyPoint(x, y));
    }

    public void passTime(double add){
        motor.updatePosition(motor.getPosition() + motor.getOutput());
        addPoint((int)time, (int)motor.getPosition());
        this.time+=add;
    }
}