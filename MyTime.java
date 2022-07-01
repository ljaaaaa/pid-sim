import java.util.ArrayList;

public class MyTime {
 
    private double time;
    public ArrayList<MyPoint> points;
    public Motor motor;

    public MyTime(Motor motor) {
        points = new ArrayList<>();
        this.motor = motor;
        time = 0;
        addPoint(0, 0);
    }   

    public void addPoint(double x, double y){
        points.add(new MyPoint(x, y));
    }

    public void passTime(double add){
        motor.updatePosition(motor.getPosition() + motor.getOutput());

        time += add;

        //Round time
        time = Math.round(time * 100.0) / 100.0;
        
        addPoint(time, motor.getPosition());
    }
}