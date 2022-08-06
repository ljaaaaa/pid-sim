public class Car {	
	//Amount of time until next update, 't step'
	public double t;

	//Speed in m/s
	public double v;

	//Current position
	public double s;

	//Acceleration controlled by PID
	public double a;

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
		//Default physics values
        	t = 0.1;
		v = 0.0;
		s = 0.0;
		a = 0.0;
	
		//Default PID values
		kP = 0.9;
		kI = 0.02;
		kD = 0.4;

		target = 5;
		lastError = target - s;
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

	//Reset variables for new points
	public void reset(){
		s = 0;
		totalError = 0;
		lastError = target - s;
	}
}
