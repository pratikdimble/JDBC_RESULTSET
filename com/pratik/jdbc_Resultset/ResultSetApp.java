package com.pratik.jdbc_Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSetApp //CLASS STARTS
{
	public static void main(String[] args) 	//MAIN() METHOD STARTS
	{
				//DECLARING THE RESOURCES
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;		
			try 		//Try starts
			{
					//LOAD AND REGISTER THE RESOURCES
				Class.forName("oracle.jdbc.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				String sql="select * from emp";
				rs=st.executeQuery(sql);
				
				System.out.println("\nData In Forward Direction");
				System.out.println("\n\tId\tName\tSalary");
				System.out.println("\t--------------------");					
				
					while(rs.next())		//DISPLAY RECORDS IN FORWARD DIRECTION
					{
						System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
					}
					System.out.print("\n\t--------------------");
					
					System.out.println("\n\nData In Backward Direction");
					System.out.println("\n\tId\tName\tSalary");
					System.out.println("\t--------------------");
					
						while(rs.previous())	//DISPLAY RECORDS IN BACKWARD DIRECTION
						{
							System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
						}
						System.out.print("\n\t--------------------");
						
						System.out.println("\n\nDisplay LAST Record");
						System.out.println("\n\tId\tName\tSalary");
						System.out.println("\t--------------------");
						rs.last();			//DISPLAY LAST RECORD  WHERE CURSOR POINTS			
						System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
						
						System.out.println("\n\nDisplay PREVIOUS Record");
						System.out.println("\n\tId\tName\tSalary");
						System.out.println("\t--------------------");
							rs.previous();				//DISPLAY PREVIOUS RECORD WHERE CURSOR POINTS
							System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
							
							System.out.println("\n\nDisplay FIRST Record");
							System.out.println("\n\tId\tName\tSalary");
							System.out.println("\t--------------------");
								rs.beforeFirst();				//CURSOR GOES TO BEFORE FIRST RECORD
								rs.next();			//NOW CURSOR AT FIRST RECORD FIRST COLUMN
								System.out.print("\n\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
							
								System.out.println("\n\nDisplay NEXT Record");
								System.out.println("\n\tId\tName\tSalary");
								System.out.println("\t--------------------");
									rs.next();								//DISPLAY NEXT RECORD
									System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
								
									System.out.println("\n\nDisplay LAST Record");
									System.out.println("\n\tId\tName\tSalary");
									System.out.println("\t--------------------");
										rs.afterLast();						//CURSOR GOES TO AFTER LAST RECORD
										rs.previous();	//CURSOR GOES TO LAST RECORD LAST COLUMN	DISPLAY LAST RECORD
										System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
										
										System.out.println("\n\nDisplay ABSOLUTE Record");
										System.out.println("\n\tId\tName\tSalary");
										System.out.println("\t--------------------");
											rs.absolute(1);								//DISPLAY ABSOLUTE RECORD
											System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
																						
											System.out.println("\n\nDisplay RELATIVE Record");
											System.out.println("\n\tId\tName\tSalary");
											System.out.println("\t--------------------");
												rs.relative(2);							//DISPLAY RELATIVE RECORD
												System.out.print("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));			
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
