public class Motor {
        //Currect position
        private double position;
        private double target; //Same as Constants.TARGET

        private double lastError;

        //Motor output = P*error + D*(slope at that point) + I*(total error over time)

        public Motor(){
                target = Constants.TARGET;
                lastError = 0;
        }

	public double getOutput(){
		return getOutputP();
	}

	//Get P and D output
        private double getOutputPD(){
                double error = target - getPosition();
                double timeChange = Constants.PASS_TIME;

                double errorRate = (error - lastError)/ timeChange;
                double output = Constants.kP * error + Constants.kD * errorRate;

                lastError = error;
                        
                return output;
        }
        
	//Get P output
        private double getOutputP(){
                double error = target - getPosition();
                double output = Constants.kP * error;
                return output;
        }

	//Setter for position
        public double getPosition(){
                return position;
        }

	//Getter for position
        public void updatePosition(double position){
                this.position = position;
        }
}
