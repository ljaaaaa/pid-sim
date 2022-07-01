public class Motor {
   
    //Target position
    int target = 20;

    //Currect position
    int current;

    //Motor output = P*error + D*(slope at that point) + I*(total error over time)

    public Motor(){

    }

    public double getMotorOutput(double target){
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