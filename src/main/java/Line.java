class Line{
	private String name;
	private Station [] stops;
	private double passengerFarePerKm = 0;
	private double cargoFarePerKm = 0;
	private int expressTrainSurcharge = 0;
	public Line(String inputName, Station[] inputStops, double inputPassengerFarePerKm, double inputCargoFarePerKm, int inputExpressTrainSurcharge){
		name = inputName;
		stops = inputStops;
		passengerFarePerKm = inputPassengerFarePerKm;
		cargoFarePerKm = inputCargoFarePerKm;
		expressTrainSurcharge = inputExpressTrainSurcharge;
	}
	public String getName(){
		return name;
	}
	public Station[] getStops(){
		return stops;
	}
	public double getPassengerFarePerKm(){
		return passengerFarePerKm;
	}
	
	public double getCargoFarePerKm(){
		return cargoFarePerKm;
	}
	
	public int getExpressTrainSurcharge(){
		return expressTrainSurcharge;
	}
	
	public String toString(){ 
		return "Fares Summary :\nPassenger Per KM: HKD " + getPassengerFarePerKm() + "\nCargo Per KG Per KM: HKG " + getCargoFarePerKm() + "\nExpress Train Surchrage: HKD " + getExpressTrainSurcharge() + "\n";
	}
	
	public int calculateDistance(Station stop1, Station stop2){
		int distanceResult = stop1.getDistance() - stop2.getDistance();
		if(distanceResult<0)
		{
			distanceResult = Math.abs(distanceResult);
		}
		return distanceResult;
	}
}