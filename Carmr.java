package Carmr;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

public class Carmr {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		int ch;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_mngmt_rental","root","Password");
		
		String sqlfordetails="Select * from mngmnt";
		
		do {
			System.out.println();
			System.out.println("To choose a option press number written along the functionality.");
			System.out.println("1. Car Management");
			System.out.println("2. Car Rental");
			System.out.println("3. Exit");
			
		ch=scanner.nextInt();
		scanner.nextLine();
		switch(ch) {
		case 1:
			
			int car_mngmt_input;
			do {
				System.out.println();
				System.out.println("Functions you can perform in Car Management");
				System.out.println("1. Add a new car.");
				System.out.println("2. View car details.");
				System.out.println("3. Update car information");
				System.out.println("4. Delete a car.");
				System.out.println("5. Exit.");
				car_mngmt_input=scanner.nextInt();
				scanner.nextLine();
				
				switch(car_mngmt_input) {
				case 1:
					System.out.println();
					System.out.println("Enter details of car like brand,model,year,rent per day in this order.");
					String model, make;
					int year,rent;
					System.out.print("Brand Name - ");
					make=scanner.nextLine();
					System.out.print("Model - ");
					model=scanner.nextLine();
					System.out.print("Year - ");
					year=scanner.nextInt();
					System.out.print("Rent Per Day - ");
					rent=scanner.nextInt();
					String sql = "INSERT INTO mngmnt (make, model, year, price_per_day) VALUES ('" + make + "', '" + model + "', " + year + ", " + rent + ")";
					try(Statement addcar = con.createStatement()){
						addcar.executeUpdate(sql);
						System.out.println("New car added");
					}
					catch (SQLException e) {
                        e.printStackTrace();
                    }
					break;
				case 2:
					
					try(Statement addcar = con.createStatement()){
						System.out.println();
						ResultSet result=addcar.executeQuery(sqlfordetails);
						System.out.println("Detail of all cars is here. ");
						while(result.next()) {
							System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
						}
						
					}
					catch (SQLException e) {
                        e.printStackTrace();
                    }
					break;
				case 3:
					
					try(Statement addcar = con.createStatement()){
						System.out.println();
						ResultSet result=addcar.executeQuery(sqlfordetails);
						System.out.println("Detail of all cars is here. ");
						while(result.next()) {
							System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
						}
						
					}
					catch (SQLException e) {
                        e.printStackTrace();
                    }
					
					break;
				case 4:
					
					try(Statement addcar = con.createStatement()){
						System.out.println();
						ResultSet result=addcar.executeQuery(sqlfordetails);
						System.out.println("Detail of all cars is here. ");
						while(result.next()) {
							System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
						}
						System.out.println("Input the car_id you want to delete.");
						int deleted_car_id=scanner.nextInt();
						scanner.nextLine();
						addcar.execute("Delete from mngmnt where car_id="+deleted_car_id);
						System.out.println("car_id - "+ deleted_car_id+" is deleted");
						
					}
					catch (SQLException e) {
                        e.printStackTrace();
                    }
					
					
					break;
					
				default:
					System.out.println("Invalid Input");
					break;
					
					}
			}while(car_mngmt_input!=5);
			break;
		case 2:
			int car_rental_input;
			do {
			System.out.println();
			System.out.println("Functions you can perform inn Car Rental");
			System.out.println("1. Display list of available car.");
			System.out.println("2. Display list of rented cars.");
			System.out.println("3. Rented out a selected car to a customer.");
			
			//System.out.println("5. Validate that the selected car is available for rent.");
			//System.out.println("6. Validate customer information.");
			System.out.println("4. Exit");
			car_rental_input=scanner.nextInt();
			switch(car_rental_input) {
			case 1:
				try(Statement addcar = con.createStatement()){
					System.out.println();
					ResultSet result=addcar.executeQuery("Select * from mngmnt where available_for_rent =1");
					System.out.println("Detail of all available cars is here. ");
					while(result.next()) {
						System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
					}
					
				}
				catch (SQLException e) {
                    e.printStackTrace();
                }
				
				break;
			case 2:
				try(Statement addcar = con.createStatement()){
					System.out.println();
					ResultSet result=addcar.executeQuery("Select * from rental_table where rental_date is null and return_date is null");
					System.out.println("Detail of all available cars is here. ");
					while(result.next()) {
						System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
					}
					
				}
				catch (SQLException e) {
                    e.printStackTrace();
                }
				
				break;
			case 3:
				try(Statement addcar = con.createStatement()){
					System.out.println();
					ResultSet result=addcar.executeQuery("Select * from mngmnt");
					System.out.println("Detail of all available cars is here. ");
					while(result.next()) {
						System.out.println("ID: " + result.getInt("car_id") + ", Make: " + result.getString("make") + ", Model: " + result.getString("model") + ", Year: " + result.getInt("year") + ", Rent Per Day: " + result.getInt("price_per_day"));
					}
					
				}
			
				System.out.print("Enter the car_id of required car -");
				int rented_car_id=scanner.nextInt();
				scanner.nextLine();
				try(Statement addcar=con.createStatement()){
					ResultSet result=addcar.executeQuery("Select * from mngmnt where car_id="+rented_car_id+" and available_for_rent=1");
					if(!result.next()) {
						System.out.println("This car is not available");
					}
					else {
						System.out.print("Enter customer name - ");
						String customer_name=scanner.nextLine();
						System.out.print("Enter customer mobile number");
						String Mobile_no;
						Mobile_no=scanner.nextLine();
						
						if(Mobile_no.length()==10) {
						LocalDate rentaldate=LocalDate.now();
						addcar.executeUpdate("Insert into rental_table (car_id,customer_name,customer_phone,rental_date)"+"Values("+rented_car_id+",'"+customer_name+"','"+Mobile_no+"','"+rentaldate.toString()+"')");
						addcar.executeUpdate("Update mngmnt set available_for_rent=0 where car_id="+rented_car_id);
						System.out.println("Car with is id "+rented_car_id+" is rented");
						}
						else {
							System.out.println("Mobile number is not valid.");
						}
						
					}
					
				}
				break;
			
			
			default:
				System.out.println("Invalid Input");
				break;
			
				
				
			}
			}while(car_rental_input!=5);
			break;
		case 3:
			System.out.println("Exited");
			break;
			
		default:
			System.out.println("Invalid Input");
			break;
		}
	}while(ch!=3); 
	scanner.close();
	
	}

}
