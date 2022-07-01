import java.util.ArrayList;

public class MyTime {
 
    public ArrayList<MyPoint> points;

    public MyTime() {
        points = new ArrayList<>();

        for (int x = 0; x < 30; x++){
            addPoint(x, x*x);
        }
    }   

    public void addPoint(int x, int y){
        points.add(new MyPoint(x, y));
    }
}