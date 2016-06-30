import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaConsoleApp {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException, IOException
	{
		JavaConsole jc=new JavaConsole();
		
		System.out.println("Please input username:");
		String username=sc.next();
		System.out.println("Please input password:");
		String password=sc.next();
		
		int index=0;
		if(username.equals("ora1")&&password.equals("ora1"))
		{
			while(true)
			{
				System.out.println("Please input your query:");
				sc.nextLine();
				String query=sc.nextLine();
				
				if(query.startsWith("update"))
				{
					
					DBUtility.DBUtility.runQuery(query);
					System.out.println("Update database successfully");
					
				}
				else if(query.startsWith("insert into"))
				{
					DBUtility.DBUtility.insert(query);
					System.out.println("insert database successfully");
				}
				else if(query.startsWith("select"))
				{
					index++;
				List<String> mylist = new ArrayList<String>();
				
				mylist=DBUtility.DBUtility.select(query);
				
				int col=DBUtility.DBUtility.columnnum(query);
				int row=mylist.size()/col;
				
				if(row<10)
				{
					System.out.println("Press 1 to see record in cosole, Press 2 to see record in file");
					
					int seerecord=sc.nextInt();
					
					if(seerecord==1)
					{
						System.out.println(jc.columnname(query));
						System.out.println(jc.printlist(mylist, col));
					}
					else if(seerecord==2)
					{
						String content=jc.printlist(mylist, col);
						jc.NewFile("Sql "+index);
						jc.addtoFile("Sql "+index, jc.columnname(query)+"\n");
						jc.addtoFile("Sql "+index, content);
						
						System.out.println("Your records are in 'Sql '"+index+".txt");
					}
					else
					{
						System.out.println("You input wrong text");
					}
					
				}
				else
				{
					System.out.println("Press 1 to see record in cosole, Press 2 to see record in file");
					
					int seerecord=sc.nextInt();
					
					if(seerecord==1)
					{
						System.out.println("Your records are more than 10 records.");
						System.out.println("The console can only display 10 records");
						System.out.println(jc.columnname(query));
						System.out.println(jc.printlistten(mylist, col));
						
						String content=jc.printlist(mylist, col);
						jc.NewFile("Sql "+index);
						jc.addtoFile("Sql "+index, jc.columnname(query)+"\n");
						jc.addtoFile("Sql "+index, content);
						
						System.out.println("Your records are in ''Sql "+index+"''.txt");
					}
					else if(seerecord==2)
					{
						String content=jc.printlist(mylist, col);
						jc.NewFile("Sql "+index);
						jc.addtoFile("Sql "+index, jc.columnname(query)+"\n");
						jc.addtoFile("Sql "+index, content);
						
						System.out.println("Your records are in 'Sql '"+index+".txt");
					}
					else
					{
						System.out.println("You input wrong text");
					}
				}
				}		
						
				
				
			}
		}
		else
		{
			System.out.println("Your username is wrong");
		}
		
	}

}
