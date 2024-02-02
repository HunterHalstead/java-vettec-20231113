package com.skillstorm;

import java.io.IOException;
import java.sql.SQLException;

public class Problem39 {
	
	// Exceptions
	static int m1() throws Exception{
		Throwable t = null;
		   try {
			   
		      throw new IOException();
		   }
		   catch (IOException e){
			   t = e;
		       throw new SQLException();
		   }
//		   catch(SQLException e){
//		       throw new InstantiationException();
//		   }
		   finally {
			   CloneNotSupportedException ce = new CloneNotSupportedException();
			   ce.addSuppressed(t);
			   throw ce;
//		      throw new CloneNotSupportedException(); // this is not a RuntimeException.
		   }
		}
	
	public static void main(String[] args) {
		try {
			m1();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			System.out.println(e.getSuppressed().getClass());
			System.out.println(e.getSuppressed().length);
			System.out.println(e.getCause());
		}
	}

}
