import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DBUtility.DBUtility;

public class JavaConsole {
	
	
	
	public String columnname(String query) throws SQLException
	{
		
		ResultSet rs;
		String content="";
		rs=DBUtility.getResultSet(query);
		ResultSetMetaData rsmd = rs.getMetaData();
		int col=DBUtility.columnnum(query);
		
		for(int i=1; i<=col;i++)
		{
			content+=rsmd.getColumnLabel(i)+"   ";
		}
		content+="\n";
		for(int i=0; i<col;i++)
		{
			content+="----------";
		}
		return content;
	}
	
	public String printlist(List<String> mylist, int col)
	{
		String content="";      
		int i=1;
		for(String d:mylist) {	
            
            if((i%col)==0)
            {
            	content+=d+"   "+"\n";
            }
            else
            {
            	content+=d+"   ";
            }
            i++;
            
        }
		return content;
		
	}
	
	public String printlistten(List<String> mylist, int col)
	{
		String content="";      
		int i=1;
		for(String d:mylist) {
			    
            if((i%col)==0)
            {
            	content+=d+"   "+"\n";
            }
            else
            {
            	content+=d+"   ";
            }
            if(i==10*col)
            {
            	break;
            }
            i++;
            
        }
		return content;
		
	}
	
	 public void NewFile(String filename){
		 
		 File file = new File(filename+".txt");
		 try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public void addtoFile(String filename, String content) throws IOException
	 {
		 FileWriter fwr = new FileWriter(filename+".txt",true );
			BufferedWriter bwr = new BufferedWriter(fwr);
			bwr.write(content);
			 bwr.newLine();
			 bwr.flush();
	 }
	 

}
