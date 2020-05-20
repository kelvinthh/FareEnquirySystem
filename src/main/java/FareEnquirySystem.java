import java.io.*;
import java.util.*;
public class FareEnquirySystem {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int from_number, to_number, train_number;

		//Stations information
		Station [] stations = new Station[7];
		stations[0] = new Station("HongKong", 0);
		stations[1] = new Station("ShenZhen", 50);
		stations[2] = new Station("GuangZhou", 200);
		stations[3] = new Station("ZhengZhou", 700);
		stations[4] = new Station("WuChang", 1000);
		stations[5] = new Station("BeiJing", 2100);
		stations[6] = new Station("InnerMongolia", 2400);


		//Line information
		Line line = new Line("HongKong-WuChang-InnerMongolia", stations, 0.4, 0.01, 50);

		//Trains information
		Train trains[] = new Train[5];
		trains[0] = new CargoTrain("C001", "08:00", line, line.getStops()[1], line.getStops()[3], 100);
		trains[1] = new CargoTrain("C002", "12:00", line, line.getStops()[6], line.getStops()[3], 200);
		trains[2] = new PassengerTrain("P001", "10:00", line, line.getStops()[0], line.getStops()[6], 10);
		trains[3] = new PassengerTrain("P002", "18:00", line, line.getStops()[6], line.getStops()[0], 6);
		trains[4] = new ExpressPassengerTrain("X001", "14:30", line, line.getStops()[0], line.getStops()[6], 4);

		System.out.println("Fare Enquiry System");
		System.out.println("===================");
		System.out.println(line);

		//List of all trains - to be completed by you!
		System.out.println("All trains(s) running on this line.");
		for(int i=0; i<trains.length; i++){
			System.out.println(trains[i]);
		}
		//List all stations - to be completed by you!
		System.out.println("\nList of stations:");
		for(int i=0;i<stations.length;i++){
			System.out.println(i+". "+stations[i].getName());
		}

		try{
			
		
			System.out.print("\nPlease enter departure station number: >");
			from_number = sc.nextInt();
			System.out.print("Please enter arrival station number: >");
			to_number = sc.nextInt();
	
			// all other codes for the FareEnquirySystem are to be completed by you!
			if(from_number<stations.length&&to_number<stations.length)
			{
				System.out.println("Select the available train: ");
				for(int i=0;i<trains.length;i++){
					if(trains[i].isValidRoute(stations[from_number], stations[to_number]))
					{
						System.out.println(i+". "+trains[i]);
					}
				}
				train_number = sc.nextInt();
				if(trains[train_number].isValidRoute(stations[from_number], stations[to_number])&&train_number<trains.length&&train_number>=0)
				{
					if(trains[train_number] instanceof CargoTrain)
					{
						System.out.print("Please enter cargo weight(KG): ");
						int weight = sc.nextInt();
						CargoTrain [] Cargo = new CargoTrain[1];
						Cargo[0]=(CargoTrain)trains[train_number];
						if(weight>0&&weight<=Cargo[0].getMaxCargoWeight())
						{
							System.out.println("Result:\nFor "+weight+"KG cargo travelling from "+stations[from_number].getName()+" to "+stations[to_number].getName()+" on "+trains[train_number].getCode());
							System.out.println("Total Fare: HKD "+trains[train_number].calculateFare(stations[from_number], stations[to_number], weight));
						}
						else
						{
							System.out.println("Cargo weight exceeds the max Cargo weight per order.");
						}
					}
					if(trains[train_number] instanceof PassengerTrain||trains[train_number] instanceof ExpressPassengerTrain)
					{
						System.out.print("Please enter the number of passenger: ");
						int passenger = sc.nextInt();
						if(trains[train_number] instanceof PassengerTrain)
						{
							PassengerTrain [] Passenger = new PassengerTrain[1];
							Passenger[0]=(PassengerTrain)trains[train_number];
							if(passenger>0&&passenger<=Passenger[0].getMaxTicketNumber())
							{
								System.out.println("Result:\nFor "+passenger+" passenger(s) travelling from "+stations[from_number].getName()+" to "+stations[to_number].getName()+" on "+trains[train_number].getCode());
								System.out.println("Total Fare: HKD "+trains[train_number].calculateFare(stations[from_number], stations[to_number], passenger));
							}
							else
							{
								System.out.println("Number of passengers exceeds the max number of passenger tickets per order.");
							}
						}
						if(trains[train_number] instanceof ExpressPassengerTrain)
						{
							ExpressPassengerTrain [] ExpressPassenger = new ExpressPassengerTrain[1];
							ExpressPassenger[0]=(ExpressPassengerTrain)trains[train_number];
							if(passenger>0&&passenger<=ExpressPassenger[0].getMaxTicketNumber())
							{
								System.out.println("Result:\nFor "+passenger+" passenger(s) travelling from "+stations[from_number].getName()+" to "+stations[to_number].getName()+" on "+trains[train_number].getCode());
								System.out.println("Total Fare: HKD "+trains[train_number].calculateFare(stations[from_number], stations[to_number], passenger));
							}
							else
							{
								System.out.println("Number of passengers exceeds the max number of passenger tickets per order.");
							}
						}
					}
				}
				else
				{
					System.out.println("Invalid train.");
				}
			}
			else
			{
				System.out.println("Invalid station number");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid train.");
		}

		System.out.println("Bye Bye!\nPress any key to continue...");
		try{
			System.in.read();
			System.exit(0);
		}catch(Exception ee){
		}
	}
}
