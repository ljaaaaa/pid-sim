public class Motor {
    //Currect position
    int current;
    int target;

    /*
    Motor output = P*error + D*(slope at that point) + I*(total error over time)
    */

    public Motor(){
        target = Constants.TARGET;
    }

    public double getOutput(){
        double error = target - getPosition();
        
        return Constants.kP * error;
    }

    public int getPosition(){
        return current;
    }

    public void updatePosition(int current){
        this.current = current;
    }
}