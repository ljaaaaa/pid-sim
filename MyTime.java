import java.util.ArrayList;

public class MyTime {
 
    public int position;
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
        position += motor.getOutput();
        motor.updatePosition(position);
        addPoint(time, position);
        time++;
    }
}