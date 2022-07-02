public class Motor {
    //Currect position
    double position;
    double target;

    long lastTime;
    double lastError;

    //!!! - Motor output = P*error + D*(slope at that point) + I*(total error over time)

    public Motor(){
        target = Constants.TARGET;
        lastError = 0;
        lastTime = System.currentTimeMillis();
    }

    public double getOutputPD(){
        double error = target - getPosition();
        double timeChange = System.currentTimeMillis() - lastTime;

        if (timeChange <= 0){
            timeChange = 1;
        }

        double errorRate = (error - lastError)/ timeChange;
        double output = Constants.kP * error + Constants.kD * errorRate;

        lastError = error;
        lastTime = System.currentTimeMillis();
                
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