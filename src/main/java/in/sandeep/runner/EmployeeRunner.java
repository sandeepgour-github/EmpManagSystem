package in.sandeep.runner;

import java.util.Scanner;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import in.sandeep.model.Employee;
import in.sandeep.service.EmployeeService;

@Component
public class EmployeeRunner implements CommandLineRunner{

	private EmployeeService service;
	public EmployeeRunner(EmployeeService service) {
		this.service=service;
	}
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Select an operation:");
			System.out.println("1. Create Employee\n2. View All Employee\n3.Find Employee By Id\n4.Update Employee\n5.Delete Employee\n6.Exit");
			choice=sc.nextInt();
			switch(choice){
			case 1:
				   System.out.println("Enter emp id:");
				   int id=sc.nextInt();
				   sc.nextLine();
				   System.out.println("Enter emp name:");
				   String name=sc.nextLine();
				   System.out.println("Enter emp salary:");
				   double sal=sc.nextDouble();
				   System.out.println("Enter empno:");
				   int depno=sc.nextInt();
				   Employee emp=new Employee(id,name,sal,depno);
			       int ans=service.insertEmployee(emp);
			       if(ans==1) {
			    	   System.out.println("employee created!");
			       }else {
			    	   System.out.println("error in db");
			       }
			       break;
			case 2:
				   List<Employee> list=service.findAllEmployees();
				   if(list.isEmpty()) {
				       System.out.println("no records in db");
				   }else {
					   System.out.println("All Employee list:");
					   for(Employee e:list) {
						   System.out.println(e);
					   }
				   }
				break;
			case 3:
				   System.out.println("Find Emp By Id:");
				   int empid=sc.nextInt();
 
				   Employee empl=service.findById(empid);
				   if(empl==null) {
					   System.out.println("emp id does not exist");
				   }else {
					   System.out.println(empl);
				   }
				   break;
			case 4:
				  System.out.println("Enter empId to update:");
				  int eid=sc.nextInt();
				  if(service.findById(eid)==null) {
					  System.out.println("id don't exist");
				  }else {
					   
					   System.out.println("Enter emp name:");
					   sc.nextLine();
					   String n=sc.nextLine();
					   System.out.println("Enter emp salary:");
					   double s=sc.nextDouble();
					   System.out.println("Enter department no:");
					   int d=sc.nextInt();
					   Employee e=new Employee();
					   e.setEname(n);
					   e.setSal(s);
					   e.setDepno(d);
				       int a=service.updateEmployee(eid,e);
				       if(a==1) {
				    	   System.out.println("Employee Updated!");
				       }else {
				    	   System.out.println("error in db");
				       }     
				  }
				  break;
				 case 5:
					   System.out.println("Enter empId to be Deleted:");
					   int count=service.deleteEmployee(sc.nextInt());
					   if(count==1) 
						   System.out.println("emp record deleted");
				       else 
					       System.out.println("emp id does not exist");
					   break;
				 case 6:
					   System.out.println("Thank you 😊");
					   break;
				 default:
					   System.out.println("Wrong choice 🤨");
			}
		}while(choice!=6);
	}

}
