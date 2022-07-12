public class Motor {
    //Currect position
    double position;
    double target;

    double lastError;

    //Motor output = P*error + D*(slope at that point) + I*(total error over time)

    public Motor(){
        target = Constants.TARGET;
        lastError = 0;
    }

    public double getOutputPD(){
        double error = target - getPosition();
        double timeChange = Constants.PASS_TIME;

        double errorRate = (error - lastError)/ timeChange;
        double output = Constants.kP * error + Constants.kD * errorRate;

        lastError = error;
                
        return output;
    }

    
    public double getOutputP(){
        double error = target - getPosition();
        double output = Constants.kP * error;
        return output;
    }

    public double getPosition(){
        return position;
    }

    public void updatePosition(double position){
        this.position = position;
    }
}
