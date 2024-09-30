package calculationAlgorithms.nestedThreadIteration;

import calculationAlgorithms.Iteration1;

public class ThreadIteration1 extends Thread {
	private final double a;
    
    public ThreadIteration1(final double a) {
    	this.a = a;
    }
	         
	@Override
	public void run() {
		this.secondThreadLevel();
		//this.findCombinationsForComponents();
	}
	
	private void secondThreadLevel() {
		for (double b = CalculationProperties.getMins()[1]; b <= CalculationProperties.getMaxes()[1]; b++) {
			final ThreadIteration2 iteration = new ThreadIteration2(
					this.a, b);
			
			final Thread thread = new Thread(iteration);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
		
	private void findCombinationsForComponents() {
		double s0 = this.a*CalculationProperties.getDoubleWeights()[0];
		
		double c0 = this.a*CalculationProperties.getCharges()[0];
		
		if (CalculationProperties.getWeights().size() == 2) {
			for (double b = CalculationProperties.getMins()[1]; b <= CalculationProperties.getMaxes()[1]; b++) {
				final double currentSum = s0 + b*CalculationProperties.getDoubleWeights()[1];
				final double totalCharge = c0 + b*CalculationProperties.getDoubleWeights()[1];
	
				if (totalCharge == CalculationProperties.getCharge() 
						&& (currentSum >= CalculationProperties.getTargetSum() - CalculationProperties.getRange()  
						&& currentSum <= CalculationProperties.getTargetSum() + CalculationProperties.getRange())) {
					
					final String solution = currentSum + "\n"
							+ totalCharge  + "\n"
							+ "(" + CalculationProperties.getSymbols()[0] + ")" + String.valueOf((int)this.a) + " + "
							+ "(" + CalculationProperties.getSymbols()[1] + ")" + String.valueOf((int)b)
							+ "\n" 
							+ Iteration1.SOLUTION_SEPARATION_LINE
							+ "\n";
					
					CalculationProperties.getSolutionsList().add(solution);
					System.out.println(solution);
				}
			}
			
		} else {
			for (double b = CalculationProperties.getMins()[1]; b <= CalculationProperties.getMaxes()[1]; b++) {
				final ThreadIteration2 iteration = new ThreadIteration2(
						this.a, b);
				
				final Thread thread = new Thread(iteration);
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
