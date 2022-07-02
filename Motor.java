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

    public double getOutput(){
        double error = target - getPosition();
        double errorRate = (error - lastError)/ (System.currentTimeMillis() - lastTime);

        if (errorRate <= 0){
            errorRate = 1;
        }

        double output = Constants.kP * error + Constants.kD * errorRate;

        System.out.println("---");
        System.out.println(error - lastError);
        System.out.println(System.currentTimeMillis());
        System.out.println(lastTime);
        System.out.println(System.currentTimeMillis() - lastTime);
        System.out.println(errorRate); //<- issue with this
        System.out.println("---");
        lastError = error;
        lastTime = System.currentTimeMillis();
        
        
        return output;
    }

    /*
    public double getOutput(){
        double error = target - getPosition();
        double output = Constants.kP * error;
        return output;
    }
    */

    public double getPosition(){
        return position;
    }

    public void updatePosition(double position){
        this.position = position;
    }
}