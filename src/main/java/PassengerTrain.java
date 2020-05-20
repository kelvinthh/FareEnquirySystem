class PassengerTrain extends Train {
	protected int maxTicketNumber;
	public int getMaxTicketNumber(){
		return maxTicketNumber;
	}
	
	public PassengerTrain(String codeInput, String startTimeInput, Line lineInput, Station startInput, Station endInput, int maxTicketNumberInput){
		super(codeInput, startTimeInput, lineInput, startInput, endInput);
		code = codeInput;
		startTime = startTimeInput;
		line = lineInput;
		start = startInput;
		end = endInput;
		maxTicketNumber = maxTicketNumberInput;
	}
	
	public double calculateDistanceFare(Station fromInput, Station toInput){
		double distanceResult = fromInput.getDistance() - toInput.getDistance();
		if(distanceResult<0)
		{
			distanceResult = Math.abs(distanceResult);
		}
		distanceResult = distanceResult*0.4;
		return distanceResult;
	}
	
	public String toString(){
		return getCode()+" "+getStartTime()+" "+getStart().getName()+" -> "+getEnd().getName()+" Max. Number of Passenger Ticket per Order : "+getMaxTicketNumber();
	}
	
}