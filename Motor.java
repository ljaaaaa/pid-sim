public class Motor {
    //Currect position
    double position;
    double target;

    /*
    Motor output = P*error + D*(slope at that point) + I*(total error over time)
    */

    public Motor(){
        target = Constants.TARGET;
    }

    public double getOutput(){
        double error = target - getPosition();
        
        System.out.println(getPosition());
        return Constants.kP * error;
    }

    public double getPosition(){
        return position;
    }

    public void updatePosition(double position){
        this.position = position;
    }
}