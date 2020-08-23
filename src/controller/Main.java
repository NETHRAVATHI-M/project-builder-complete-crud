package controller;

import java.util.Scanner;

import dao.CrudDAO;
import dao.UserDAO;
import model.Skill;
import model.User;

public class Main {
	public static void main(String[] args) {
		User u = new User();
		Skill s = new Skill();
		CrudDAO dao1 = new CrudDAO();
		Scanner sc = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		int choice =1;
		boolean flag = true;
		while(flag) {
			System.out.println("1: signup 2. login");
		switch(choice) {
		case 1:	System.out.println("enter email");
				String email = sc.next();
				System.out.println("enter password");
				String password = sc.next();
				User user = new User(email, password);
				int success = dao.signUp(user);
				if(success==1) {
					System.out.println("success");
					
				}
				else {
					System.out.println("check your email and password");
				}
				break;
		case 2:System.out.println("please provide your credentials");
			String email1 = sc.next();
			String password1 = sc.next();
			User u1 = new User(email1, password1);
			boolean status = dao.loginUser(u1);
			boolean flag1 =true;
			
			if(status) {
				System.out.println("1.add 2.delete,3 update 4.dispaly");
				int choice1 = sc.nextInt();
				while(flag1) {
				switch(choice1) {
				case 1: 
					System.out.println("add skills");
					System.out.println("enter id");
					int id = sc.nextInt();
					System.out.println("enter Name");
					String name = sc.next();
					Skill skill = new Skill(id, name);
					dao1.addSkill(skill);
					break;
				case 2:
					System.out.println("delete by id");
					System.out.println("entet id");
					int id1 = sc.nextInt();
					dao1.delete(id1);
					break;
				case 3:System.out.println("update the skill");
						System.out.println("entet id");
						int id2 = sc.nextInt();
						System.out.println("enter skill");
						String name1 = sc.next();
						Skill skill3 = new Skill(id2, name1);
						dao1.update(skill3);
						break;
				case 4:System.out.println("display");
						dao1.display();
						break;
				case 5: flag=false;
						break;
				default: System.out.println("wrong choice");
						}
					}
				}
				break;
		case 3: flag = false;
				break;
		default: System.out.println("wrong choice");
			
			
		
		}
		
		}
		
	}
}
