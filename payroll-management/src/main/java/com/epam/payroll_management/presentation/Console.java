package com.epam.payroll_management.presentation;

public class Console {
	public static void intro() {
		System.out.println
		("-----------------------Welcome to EPAM Payroll Management System------------------------");
		System.out.print("Press 1: To Create Employee \n"
				+ "Press 2: To Read Employee by Employee ID \n"
				+ "Press 3: To Update Employee by Employee ID \n"
				+ "Press 4: To Delete Employee by Employee ID \n"
				+ "Press 5: To Exit \n"
				+ "Input :");
	}
//	public static void main(String args[]){
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int command = 0 ; 
//		
//		while(command != 5 ) { 
//			intro();
//			command  = sc.nextInt() ;
//			switch(command) {
//				case 1 :{
//					System.out.print("Please Enter Employee id :");
//					int empid = sc.nextInt() ;
//					sc.nextLine();
//					System.out.print("Please Enter Employee name :");
//					String name = sc.nextLine();
//					System.out.print("Please Enter Employee Designation :");
//					String designation = sc.nextLine();
//					System.out.print("Please Enter Employee Department :");
//					String department = sc.nextLine();
//					System.out.print("Please Enter Employee Date of Joining (yyyy-mm-dd or NOW) :");
//					String dateOfJoining = sc.nextLine();
//					CreateEmployee.addEmployee(empid, name, designation, department, dateOfJoining);
//					break;
//				}
//				case 2 :{
//					System.out.print("Please Enter Employee id :");
//					int empid = sc.nextInt() ;
//					System.out.println(ReadEmployee.getEmployeeById(empid));
//					break;
//				}
//					
//				case 3 :{
//					System.out.print("Please Enter Employee id :");
//					int empid = sc.nextInt() ;
//					sc.nextLine();
//					System.out.print("Please Enter Employee name :");
//					String name = sc.nextLine();
//					System.out.print("Please Enter Employee Designation :");
//					String designation = sc.nextLine();
//					System.out.print("Please Enter Employee Department :");
//					String department = sc.nextLine();
//					System.out.println(UpdateEmployee.updateEmployeeById(empid, name, designation, department));
//					break;
//				}
//				case 4 :{
//					System.out.print("Please Enter Employee id :");
//					int emplid = sc.nextInt() ;
//					System.out.println(DeleteEmployee.deleteEmployeeById(emplid));
//					break;
//					
//				}
//				case 5: {
//					System.out.println("Thanks for Visiting !!!!!!!!!!!!!!!!");
//					break ;
//				}
//				default :{
//					System.out.println("Please enter the proper values and try again ");
//				}
//			}
//			DatabaseSummary.ShowDatabase();
//		}
//		sc.close();
//	}
}
