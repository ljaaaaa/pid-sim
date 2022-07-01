import java.util.ArrayList;

public class MyTime {
 
    private int time;
    public ArrayList<MyPoint> points;
    public Motor motor;

    public MyTime(Motor motor) {
        points = new ArrayList<>();
        time = 0;
        this.motor = motor;
    }   

    public void addPoint(int x, int y){
        points.add(new MyPoint(x, y));
    }

    public void passTime(){
        addPoint(time, (int)motor.getOutput());
    }
}