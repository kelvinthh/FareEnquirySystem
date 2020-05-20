class Station{
	private String name;
	private int distance = 0;
	public Station(String inputName, int inputDistance){
		name = inputName;
		distance = inputDistance;
	}
	public String getName(){
		return name;
	}
	public int getDistance(){
		return distance;
	}
}