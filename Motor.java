public class Motor {
    //Currect position
    double position;
    double target;

    double lastTime;
    double lastError;

    //!!! - Motor output = P*error + D*(slope at that point) + I*(total error over time)

    public Motor(){
        target = Constants.TARGET;
        lastError = 0;
        lastTime = System.currentTimeMillis();
    }

    public double getOutput(){
        System.out.println("++" + position);
        double error = target - getPosition();
        double errorRate = (error - lastError)/ (System.currentTimeMillis() - lastTime);
        double output = Constants.kP * error + Constants.kD * errorRate;

        System.out.println(error);

        lastError = error;
        lastTime = System.currentTimeMillis();
        return output;

    }

    public double getPosition(){
        return position;
    }

    public void updatePosition(double position){
        this.position = position;
    }
}