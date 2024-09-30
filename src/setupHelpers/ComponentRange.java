package setupHelpers;

public class ComponentRange {
	private final double min;
	private final double max;
	public ComponentRange(final double min, 
						  final double max) {
		this.min = min;
		this.max = max;
	}
	
	public double getMin() {
		return min;
	}
	public double getMax() {
		return max;
	}
}
