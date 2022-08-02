public class Car {
	public double t; //Amount of time until next update, 't step'
	public double v; //Speed in m/s
	public double s; //Current position

	public double a; //Acceleration, controlled by PID

        public Car(){
        	t = 0.1; //Updated 10 times a second
		v = 1.0; //Speed 1 m/s
		s = 0.0; //Starting position is 0
        
		a = 0.0; //Accelerating initially set to 0
	}

	//Passes time t
	public void move(){
			
	}
}
