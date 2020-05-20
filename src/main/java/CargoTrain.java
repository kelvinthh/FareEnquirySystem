class CargoTrain extends Train {
	private int maxCargoWeight = 0;
	public CargoTrain(String codeInput, String startTimeInput, Line lineInput, Station startInput, Station endInput, int maxCargoWeightIntput){
		super(codeInput, startTimeInput, lineInput, startInput, endInput);
		code = codeInput;
		startTime = startTimeInput;
		line = lineInput;
		start = startInput;
		end = endInput;
		maxCargoWeight = maxCargoWeightIntput;
	}
	
	public int getMaxCargoWeight(){
		return maxCargoWeight;
	}
	
	public int calculateDistance(Station fromInput, Station toInput){
		int distanceResult = fromInput.getDistance() - toInput.getDistance();
		if(distanceResult<0)
		{
			distanceResult = Math.abs(distanceResult);
		}
		return distanceResult;
	}
	
	public double calculateDistanceFare(Station fromInput, Station toInput){
		return calculateDistance(fromInput, toInput)*0.01;
	}
	
	public String toString(){
		return getCode()+" "+getStartTime()+" "+getStart().getName()+" -> "+getEnd().getName()+" Max. Cargo Weight per Order : "+getMaxCargoWeight()+" KG";
	}
	
}