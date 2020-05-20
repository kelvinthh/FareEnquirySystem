abstract class Train {

	protected String code;
	protected String startTime;
	protected Line line;
	protected Station start;
	protected Station end;
	public Train(String codeInput, String startTimeInput, Line lineInput, Station startInput, Station endInput){
		code = codeInput;
		startTime = startTimeInput;
		line = lineInput;
		start = startInput;
		end = endInput;
	}
	public String getCode(){
		return code;
	}
	
	public String getStartTime(){
		return startTime;
	}
	
	public Line getLine(){
		return line;
	}
	
	public Station getStart(){
		return start;
	}
	
	public Station getEnd(){
		return end;
	}
	
	public abstract double calculateDistanceFare(Station from, Station to);
	
	public boolean isValidRoute(Station from, Station to){
		int startID = 0;
		int endID = 0;
		int fromID = 0;
		int toID = 0;
		boolean fromCheck = false;
		boolean toCheck = false;
		Station[] tempStation = line.getStops();
		for(int i=0;i<tempStation.length;i++){
			if(start.getName().equals(tempStation[i].getName()))
			{
				startID = i;
			}
			if(end.getName().equals(tempStation[i].getName()))
			{
				endID = i;
			}
		}
		for(int i=0;i<tempStation.length;i++){
			if(from.getName().equals(tempStation[i].getName()))
			{
				fromID = i;
			}
			if(to.getName().equals(tempStation[i].getName()))
			{
				toID = i;
			}
		}
		//Clockwise Line
		if(startID<endID)
		{
			if(fromID<toID)
			{
				for(int i=startID;i<=endID;i++){
					if(from.getName().equals(tempStation[i].getName()))
					{
						fromCheck = true;
					}
					if(to.getName().equals(tempStation[i].getName()))
					{
						toCheck = true;
					}
				}
			}
		}
		//Non Clockwise Line
		if(startID>endID)
		{
			if(fromID>toID)
			{
				for(int i=startID;i>=endID;i--){
					if(from.getName().equals(tempStation[i].getName()))
					{
						fromCheck = true;
					}
					if(to.getName().equals(tempStation[i].getName()))
					{
						toCheck = true;
					}
				}

			}
		}
		
		boolean finalCheck = false;
		if(toCheck==true&&fromCheck==true)
		{
			finalCheck = true;
		}
		return finalCheck;
	}
	public double calculateFare(Station fromInput, Station toInput, int quantityInput){
		return calculateDistanceFare(fromInput, toInput)*quantityInput;
	}
	public String toString(){
		return getCode()+" "+getStartTime()+" "+getStart().getName()+" -> "+getEnd().getName();
	}
}