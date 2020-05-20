class ExpressPassengerTrain extends PassengerTrain {
	public ExpressPassengerTrain(String codeInput, String startTimeInput, Line lineInput, Station startInput, Station endInput, int maxTicketNumberInput){
		super(codeInput, startTimeInput, lineInput, startInput, endInput, maxTicketNumberInput);
		code = codeInput;
		startTime = startTimeInput;
		line = lineInput;
		start = startInput;
		end = endInput;
		maxTicketNumber = maxTicketNumberInput;
	}
	
	public double calculateFare(Station fromInput, Station toInput, int quantityInput){
		return (calculateDistanceFare(fromInput, toInput)*quantityInput)+50;
	}
	
	public String toString(){
		return getCode()+" "+getStartTime()+" "+getStart().getName()+" -> "+getEnd().getName()+" Max. Number of Passenger Ticket per Order : "+getMaxTicketNumber()+" Express Train Surcharge Required!";
	}
}