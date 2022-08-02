public class Car {
	public double t; //Amount of time until next update, 't step'
	public double v; //Speed in m/s
	public double s; //Current position
	public double a; //Acceleration, controlled by PID

	public double lastError;
	public double totalError;

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
                a = getAccelerationPD();
	}
	
	//Get new acceleration using PID
	public double getAccelerationPID(){
		double error = Constants.TARGET - s;
		double errorRate = (error - lastError) / t;
		
		if(Math.abs(error) < 1){
			totalError += error * t;
		}

		double output = (Constants.PID.kP * error) + (Constants.PID.kI * totalError) + (Constants.PID.kD * errorRate);
		lastError = error;

		return output;
	}

	//Get new acceleration with P
	public double getAccelerationP(){
		double error = Constants.TARGET - s;

    		return Constants.PID.kP * error;
	}

	//Get new acceleration with P and D
	public double getAccelerationPD(){
		double error = Constants.TARGET - s;
    		double errorRate = (error - lastError)/ t;
    		double output = Constants.PID.kP * error + Constants.PID.kD * errorRate;

		lastError = error;

		return output;
	}
}
