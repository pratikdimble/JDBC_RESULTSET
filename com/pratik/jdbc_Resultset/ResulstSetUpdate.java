package com.pratik.jdbc_Resultset;

//importing the packages
import java.sql.*;

public class ResulstSetUpdate {		//class starts

public static void main(String[] args)//main() function starts
{
	//declaring the resources
Connection con=null;
Statement st=null;
ResultSet rs=null;
	try 		//try block starts
	{
			//loading and registering the resources
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","2238");
		st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		String sql="Select * from emp10";
		rs=st.executeQuery(sql);
		
		System.out.println("\nData Before Updation");
		System.out.println("\n\tId\tName\tSalary");
		System.out.println("\t--------------------");					
		
			while(rs.next())		//DISPLAY RECORDS Before Updation
			{
				System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
			}
			System.out.print("\n\t--------------------");
				
				System.out.println("\n\tApplication is Paused, Update Database "); 
				System.in.read();
				rs.beforeFirst();
			
			System.out.println("\n\nData After Updation");
			System.out.println("\n\tId\tName\tSalary");
			System.out.println("\t--------------------");
			
				while(rs.next())	//DISPLAY RECORDS After Updation
				{
					rs.refreshRow();
					System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
				}
				System.out.print("\n\t--------------------");
			/*	
	        DatabaseMetaData dmd = con.getMetaData();
	        if (dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
	            System.out.println("Insensitive scrollable result sets are supported");
	        }
	        if (dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
	        	 System.out.println(" Sensitive scrollable result sets are supported");
	        }
	        if (!dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)
	            && !dmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
	        	 System.out.println(" Updatable result sets are not supported");
	        }
			//boolean b=Boolean.parsBboolean(rs.refreshRow());
	     // Get type of the result set
	        int type = rs.getType();
	    
	        if (type == ResultSet.TYPE_SCROLL_INSENSITIVE
	              || type == ResultSet.TYPE_SCROLL_SENSITIVE) {
	        	 System.out.println(" Result set is scrollable");
	        } else {
	        	 System.out.println(" Result set is not scrollable");
	        }
		*/
	} 	//		Try close
	catch (Exception e) 
	{
	e.printStackTrace();
	}
	finally
	{		//CLOSE THE RESOURCES
		try 
		{
			rs.close();
			st.close();
			con.close();
			
		} 
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
	}


System.out.print("\n\n----END OF PROGRAMME----by Pratik-----\n");

}			//MAIN() METHOD ENDS

}	//CLASS CLOSE
