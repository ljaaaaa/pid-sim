public class Car {
	//Physics variables
	public double t; //Amount of time until next update, 't step'
	public double v; //Speed in m/s
	public double s; //Current position
	public double a; //Acceleration, controlled by PID

	//PID values
	public double kP;
	public double kI;
	public double kD;

	//Error variables
	public double lastError;
	public double totalError;

	//Target to reach
	public double target;

        public Car(){
        	t = 0.1; //Updated 10 times a second
		v = 0.0; //Speed 1 m/s
		s = 0.0; //Starting position is 0 
		a = 0.0; //Accelerating initially set to 0
		
		lastError = Constants.TARGET - s; //Set last error
	}

	//Pass time t
	public void passTime(){
		//Update position s
                s += (v * t) + (1/2) * a * (t*t);

                //Update speed v
                v = v + a * t;

		//Update acceleration using PID
                a = getAccelerationPID();
	}
	
	//Get new acceleration using PID
	public double getAccelerationPID(){
		double error = target - s;
		double errorRate = (error - lastError) / t;
		
		if(Math.abs(error) < 1){
			totalError += error * t;
		}

		double output = (kP * error) + (kI * totalError) + (kD * errorRate);
		lastError = error;

		return output;
	}
}
