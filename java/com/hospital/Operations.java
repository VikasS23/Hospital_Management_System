package com.hospital;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Entity.Doctor;
import Entity.Fees;
import Entity.HibernateUtil;
import Entity.Medicine_Detail;
import Entity.Patient;
import Entity.Speciality;

import java.util.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Operations {
	public static void main(String[] args) {
		try {
			
		System.out.println("Welcome to hospital management Enter any Number to continue");
		
		
		Scanner first = new Scanner(System.in);
		int exit = first.nextInt() ;
		
		while(exit!=0) {
			System.out.println(" Enter 1 : Add a new Doctor \n"
					         + " Enter 2 : Update Doctor Detail \n"
					         + " Enter 3 : Delete  Doctor Detail \n"
					         + " Enter 4 : Get All Doctor Detail \n"
					         + " Enter 5 : Update Speciality \n"
					         + " Enter 6 : Get All Doctor Speciality Detail \n"
					         + " Enter 7 : Update Fees Detail \n"
					         + " Enter 8 : Get All Fees Detail \n"
					         + " Enter 9 : Add Medicine Detail \n"
					         + " Enter 10 : Update Medicine Detail \n" 
					         + " Enter 11 : Delete Medicine Detail \n"
					         + " Enter 12 : Get All Medicine Detail \n"
					         + " Enter 13 : Add Patient Detail \n"

                              + " Enter 14 : Update Patient Detail\n"

                              + " Enter 15 : Delete Patient Detail \n"
                              + " Enter 16 : Get All Patient Detail \n"





					         

					         
					        
					        );
			int x = first.nextInt() ;
			
			switch(x) {
			case 1:
			try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter DoctorId : ");
			String DoctorId = sc.nextLine();
			System.out.println("Enter Doctorname : ");
			String DoctorName = sc.nextLine();
			System.out.println("Enter Gender ");
			String Gender = sc.nextLine();
			System.out.println("Enter Email ");
			String Email= sc.nextLine();
			System.out.println("Enter Phone no. ");
			String Phone = sc.nextLine();
			System.out.println("Enter Address ");
			String Address = sc.nextLine();
			System.out.println("Doctor Speciality");
			String Speciality = sc.nextLine();
			System.out.println("Enter Doctor Fees");
			String Fees = sc.nextLine();
			
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
	        Doctor Person1= new Doctor(DoctorId,DoctorName,Gender,Email,Phone,Address); 
			session.save(Person1);
			
			 
			
			
			//Membership Portion
			
			Speciality membership1 = new Speciality(DoctorId, Person1, Speciality);
			
			List<Speciality> memberships = new ArrayList<Speciality>(); 
			memberships.add(membership1);
			Person1.setSpeciality(memberships);
			
			session.save(membership1);
			System.out.println(membership1); 
			
			//Fees Detail portion
	         Fees Fees1 = new Fees(DoctorId,
			  Person1,Fees);
			
			List<Fees> fees = new ArrayList<Fees>(); 
			fees.add(Fees1);
			Person1.setfees(fees);
			
			session.save(Fees1);
			System.out.println(fees); 
			
			transaction.commit();
			System.out.println("you Doctor Detail is saved  ======================================================================>\n   ");
			
			break;
			
		
			
			}
		catch(Exception e) {
			
			System.out.println(" Id is already taken ======================================================================>\n  ");
			break;
		}
		
			
			
	
		case 2:
			
			        // JDBC URL, username, and password of MySQL server
			        String jdbcUrl = "jdbc:mysql://localhost:3306/hospital";
			        String username = "root";
			        String password = "Shukla@227405";

			        // JDBC variables for opening, closing, and managing connection
			        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
			            // Take user input for update values
			        	 Scanner scanner = new Scanner(System.in);
			        	System.out.println("Enter PersonId : ");
						String DoctorId = scanner.nextLine();
			           
			            System.out.println("Enter new  name : ");
						String DoctorName = scanner.nextLine();
						System.out.println("Enter Gender ");
						String Gender = scanner.nextLine();
						System.out.println("Enter new Email ");
						String Email= scanner.nextLine();
						System.out.println("Enter new Phone no. ");
						String Phone = scanner.nextLine();
						System.out.println("Enter new Address ");
						String Address = scanner.nextLine();
						
			            // Add more input prompts for other columns as needed

			            // SQL update statement with placeholders
			            String updateQuery = "UPDATE Doctor SET DoctorName=?, Gender=? , Email=?, Phone=? ,Address=? WHERE DoctorId=?";

			            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			                // Set values for the placeholders
			                preparedStatement.setString(1, DoctorName);
			                preparedStatement.setString(2, Gender);
			                preparedStatement.setString(3, Email);
			                preparedStatement.setString(4, Phone);
			                preparedStatement.setString(5, Address);
			                // Set the condition value for the WHERE clause
			                preparedStatement.setString(6, DoctorId);

			                // Execute the update statement
			                int rowsAffected = preparedStatement.executeUpdate();

			                System.out.println("Updated Sucessfully  ======================================================================> \n ");
			                break;
			            }
			        } catch (Exception e) {
			            System.out.println("Invalid Id ======================================================================>\\n  ");
			            break;
			        }
			    
			

		case 3:
			

		        // JDBC variables for opening, closing, and managing connection
		        try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/hospital", "root","Shukla@227405")) {
		            // Take user input for the condition value
		            Scanner val = new Scanner(System.in);
		            System.out.print("Enter Doctor Id ");
		            
		            String conditionValue = val.nextLine();

		            // SQL delete statement with a placeholder for the condition
		            String membership = "DELETE FROM Speciality WHERE DoctorId = ?";
		            String feesdetail = "DELETE FROM fees WHERE DoctorId = ?";
		            String Persondetail = "DELETE FROM Doctor WHERE DoctorId = ?";
		            

		            try (PreparedStatement preparedStatement = connection.prepareStatement(membership);
		            		PreparedStatement Statement = connection.prepareStatement(feesdetail);
		            		PreparedStatement PStatement = connection.prepareStatement(Persondetail);
		            		)
		            		
		            		
		            		 {
		                // Set the value for the condition placeholder
		                preparedStatement.setString(1, conditionValue);
		                Statement.setString(1, conditionValue);
		                PStatement.setString(1, conditionValue);
		                

		                // Execute the delete statement
		                 preparedStatement.executeUpdate();
		                 Statement.executeUpdate();
		                  PStatement.executeUpdate();
		        

		                System.out.println("Deleted successfully  ======================================================================>\n   " );
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println("Invalid Id ======================================================================>\n  ");
		            break;
		        }
		
			
		
		
		case 5:
	       
	        // JDBC variables for opening, closing, and managing connection
	        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
	            // Take user input for update values
	        	 Scanner scanner = new Scanner(System.in);
	        	System.out.println("Enter DoctorId : ");
				String DoctorId = scanner.nextLine();
	           
	            System.out.println("Enter new Speciality : ");
				String Speciality = scanner.nextLine();
								
	            // SQL update statement with placeholders
	            String updateQuery = "UPDATE speciality SET speciality=? WHERE DoctorId=?";

	            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
	                // Set values for the placeholders
	                preparedStatement.setString(1, Speciality);

	          
	               
	                // Set the condition value for the WHERE clause
	                preparedStatement.setString(2, DoctorId);

	                // Execute the update statement
	                 preparedStatement.executeUpdate();

	                System.out.println("Updated Sucessfully  ======================================================================> \n ");
	                break;
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid Id ======================================================================>\\n  ");
	            break;
	        }
	        case 7:
	        	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
		            // Take user input for update values
		        	 Scanner scanner = new Scanner(System.in);
		        	System.out.println("Enter DoctorId : ");
					String DoctorId = scanner.nextLine();
		           
		            System.out.println("Enter new  Fees : ");
					String Fees = scanner.nextLine();
					
					
		            // SQL update statement with placeholders
		            String updateQuery = "UPDATE Fees SET Fees=? WHERE DoctorId=?";

		            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
		                // Set values for the placeholders
		                preparedStatement.setString(1, Fees);
		      
		               
		                // Set the condition value for the WHERE clause
		                preparedStatement.setString(2, DoctorId);

		                // Execute the update statement
		                int rowsAffected = preparedStatement.executeUpdate();

		                System.out.println("Updated Sucessfully  ======================================================================> \n ");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println("Invalid Id ======================================================================>\\n  ");
		            break;
		        }
	       
	        case 4:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery("Select * from Doctor");
	 	        	while(resultSet.next()) {
	 	        		String id = resultSet.getString("DoctorId");
	 	        		String name = resultSet.getString("DoctorName");
	 	        		String Gender = resultSet.getString("Gender");
	 	        		String Phone = resultSet.getString("Phone");
	 	        		String Email = resultSet.getString("Email");
	 	        		String Address = resultSet.getString("Address");
	 	        		
	 	        		System.out.println("========================================\n"+"Doctor id :     "+ id + "\nDoctor Name :   " + name +"\nGender :        "+ Gender +"\nPhone no. :     "+ Phone+"\nGmail :         " + Email+"\nAddress :       "+Address +"\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 6:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery(" Select p.DoctorName,m.SpecialityId,m.speciality from Doctor p INNER JOIN Speciality m on p.DoctorId =m.SpecialityId;");
	 	        	while(resultSet.next()) {
	 	        		
	 	        		String id = resultSet.getString("m.SpecialityId");
	 	        		String name = resultSet.getString("p.DoctorName");
	 	        		String Speciality = resultSet.getString("m.Speciality");
	 	        		
	 	        		
	 	        		System.out.println("========================================\n"+"Speciality id :      "+ id +"\nDoctor Name :        "+ name + "\nSpeciality :         " + Speciality +"\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        case 8:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
	 	            // Take user input for update values
	 	        	Statement statement = connection.createStatement();
	 	        	ResultSet resultSet = statement.executeQuery(" Select p.DoctorName,f.FeesId,f.Fees from Doctor p INNER JOIN Fees f on p.DoctorId =f.FeesId;");
	 	        	while(resultSet.next()) {
	 	        		
	 	        		String id = resultSet.getString("F.FeesId");
	 	        		String name = resultSet.getString("p.DoctorName");
	 	        		String Fees = resultSet.getString("f.Fees");
	 	        		
	 	        		
	 	        		System.out.println("========================================\n"+"Fees id :          "+ id +"\nPerson Name :      "+ name + "\nFoctor Fees :      " + Fees + "\n========================================\n" );
	 	        	}
	 	        	resultSet.close();
	 	        	statement.close();
	 	        	connection.close();
	 	        	break;
	 	        	
	 	        	
	 	               
	 	            }catch(Exception e){
	 	            	System.out.println(" invalid id");
	 	            	break;
	 	            	
	 	            }
	        	 
	        case 9 :
	        	

				try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter MedicineId : ");
					String MedicineId = sc.nextLine();
					Scanner pc = new Scanner(System.in);
					System.out.println("Enter your Medicine name : ");
					String MedicineName = pc.nextLine();

					System.out.println("Enter your Medicine Use : ");
					String MedicineUse = pc.nextLine();

					SessionFactory factory = HibernateUtil.getSessionFactory();
					Session session = factory.openSession();
					Transaction transaction = session.beginTransaction();
					Medicine_Detail Med1 = new Medicine_Detail(MedicineId, MedicineName, MedicineUse); 
					session.save(Med1);

					transaction.commit();
					
					System.out.println("your Medicine Detail is Added sucessfully  ======================================================================>\n  ");

					break;
				} catch (Exception e) {

					System.out.println(e + "Id is already taken ======================================================================>\\n  ");
					break;
				}
				
	        case 10 :
	        	 // JDBC variables for opening, closing, and managing connection
		        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Shukla@227405")) {
		            // Take user input for update values
		        	 Scanner sca = new Scanner(System.in);
		        	System.out.println("Enter MedicineId : ");
					String MedicineId = sca.nextLine();
		           
		            System.out.println("Enter new  Medicinename : ");
					String MedicineName = sca.nextLine();
					System.out.println("Enter Medicine Use ");
					String MedicineUse= sca.nextLine();
					

		            // SQL update statement with placeholders
		            String updateQuery = "UPDATE Medicine_Detail SET MedicineName=?, MedicineUse=? WHERE MedicineId=?";

		            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
		                // Set values for the placeholders
		                preparedStatement.setString(1, MedicineName);
		                preparedStatement.setString(2, MedicineUse);
		          
		                
		                // Set the condition value for the WHERE clause
		                preparedStatement.setString(3, MedicineId);

		                // Execute the update statement
		                preparedStatement.executeUpdate();

		                System.out.println("Updated Sucessfully  ======================================================================>\n ");
		                break;
		            }
		        } catch (Exception e) {
		            System.out.println("Invalid Id ======================================================================>\\n   ");
		            break;
		        }
	        case 11:
	        	 try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/hospital", "root","Shukla@227405")) {
	 	            // Take user input for the condition value
	 	            Scanner val = new Scanner(System.in);
	 	            System.out.print("Enter Medicine Id ");
	 	            String conditionValue = val.nextLine();

	 	            // SQL delete statement with a placeholder for the condition
	 	            String equipment = "DELETE FROM Medicine_Detail WHERE MedicineId = ?";
	 	           

	 	            try (PreparedStatement preparedStatement = connection.prepareStatement(equipment);
	 	            		
	 	            		)
	 	            		
	 	            		
	 	            		 {
	 	                // Set the value for the condition placeholder
	 	                preparedStatement.setString(1, conditionValue);
	 	                

	 	                // Execute the delete statement
	 	                int rowsAffected = preparedStatement.executeUpdate();
	 	                

	 	                System.out.println("Deleted successfully ======================================================================>\n  " );
	 	                break;
	 	            }
	 	        } catch (Exception e) {
	 	            System.out.println("invalid id ======================================================================>\\n  ");	            break;
	 	        }
	        	 
	        case 12 : 
	        	
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
		 	            // Take user input for update values
		 	        	Statement statement = connection.createStatement();
		 	        	ResultSet resultSet = statement.executeQuery("Select * from Medicine_Detail");
		 	        	while(resultSet.next()) {
		 	        		String id = resultSet.getString("MedicineId");
		 	        		String name = resultSet.getString("MedicineName");
		 	        		String Use = resultSet.getString("MedicineUse");
		 	        		System.out.println("==============================\n"+"Medicine id :     "+ id + "\nMedicine Name :   " + name +"\nMedicine Use :    "+ Use +"\n==============================\n" );
		 	        	}
		 	        	resultSet.close();
		 	        	statement.close();
		 	        	connection.close();
		 	        	break;
		 	        	
		 	        	
		 	               
		 	            }catch(Exception e){
		 	            	System.out.println(" invalid id");
		 	            	break;
		 	            	
		 	            }
	        	 
	        case 13 :
	        	try {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter PatientId : ");
					int PatientId = sc.nextInt();
					Scanner pc = new Scanner(System.in);
					System.out.println("Enter your Patient name : ");
					String PatientName = pc.nextLine();

					System.out.println("Enter Patient Phone no. : ");
					String Phoneno = pc.nextLine();

					SessionFactory factory = HibernateUtil.getSessionFactory();
					Session session = factory.openSession();
					Transaction transaction = session.beginTransaction();
					Patient patient1 = new Patient(PatientId, PatientName, Phoneno); 
					session.save(patient1);

					transaction.commit();
					
					System.out.println("your Patient Detail is Added sucessfully  ======================================================================>\n  ");

					break;
				} catch (Exception e) {

					System.out.println(e + "Id is already taken ======================================================================>\\n  ");
					break;
				}
	        	
	        case 14:
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Shukla@227405")) {
			            // Take user input for update values
			        	 Scanner sca = new Scanner(System.in);
			        	System.out.println("Enter PatientId : ");
						String PatientId = sca.nextLine();
			           
			            System.out.println("Enter new  Patientname : ");
						String PatientName = sca.nextLine();
						System.out.println("Enter Phone Number ");
						String Phoneno= sca.nextLine();
						

			            // SQL update statement with placeholders
			            String updateQuery = "UPDATE Patient SET PatientName=?, Phoneno=? WHERE PatientId=?";

			            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
			                // Set values for the placeholders
			                preparedStatement.setString(1, PatientName);
			                preparedStatement.setString(2, Phoneno);
			          
			                
			                // Set the condition value for the WHERE clause
			                preparedStatement.setString(3, PatientId);

			                // Execute the update statement
			                preparedStatement.executeUpdate();

			                System.out.println("Updated Sucessfully  ======================================================================>\n ");
			                break;
			            }
			        } catch (Exception e) {
			            System.out.println("Invalid Id ======================================================================>\\n   ");
			            break;
			        }
	        case 15:
	        	 try (Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/hospital", "root","Shukla@227405")) {
	 	            // Take user input for the condition value
	 	            Scanner val = new Scanner(System.in);
	 	            System.out.print("Enter Patient Id ");
	 	            String conditionValue = val.nextLine();

	 	            // SQL delete statement with a placeholder for the condition
	 	            String equipment = "DELETE FROM Patient WHERE PatientId = ?";
	 	           

	 	            try (PreparedStatement preparedStatement = connection.prepareStatement(equipment);
	 	            		
	 	            		)
	 	            		
	 	            		
	 	            		 {
	 	                // Set the value for the condition placeholder
	 	                preparedStatement.setString(1, conditionValue);
	 	                

	 	                // Execute the delete statement
	 	                int rowsAffected = preparedStatement.executeUpdate();
	 	                

	 	                System.out.println("Deleted successfully ======================================================================>\n  " );
	 	                break;
	 	            }
	 	        } catch (Exception e) {
	 	            System.out.println("invalid id ======================================================================>\\n  ");	            break;
	 	        }
	        	 
	        case 16 : 
	        	
	        	 try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root",  "Shukla@227405")) {
		 	            // Take user input for update values
		 	        	Statement statement = connection.createStatement();
		 	        	ResultSet resultSet = statement.executeQuery("Select * from Patient");
		 	        	while(resultSet.next()) {
		 	        		String id = resultSet.getString("PatientId");
		 	        		String name = resultSet.getString("PatientName");
		 	        		String phoneno = resultSet.getString("Phoneno");
		 	        		System.out.println("==============================\n"+"Patient id :     "+ id + "\nPatient Name :   " + name +"\nPhone Number :    "+ phoneno +"\n==============================\n" );
		 	        	}
		 	        	resultSet.close();
		 	        	statement.close();
		 	        	connection.close();
		 	        	break;
		 	        	
		 	        	
		 	               
		 	            }catch(Exception e){
		 	            	System.out.println(" invalid id");
		 	            	break;
		 	            	
		 	            }
	        	 

				
	        	
		      
	 		
	
		
			
	}
		}
	
	}catch (Exception e) {
		System.out.println("Please Enter a valid Number");
		
		}
	}
	 
		
		
	
}