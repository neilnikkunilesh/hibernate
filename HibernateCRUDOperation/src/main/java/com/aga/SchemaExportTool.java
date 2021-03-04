package com.aga;

import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaValidator;

public class SchemaExportTool {
	
	public static void main(String args[]) {
		Configuration conf= new Configuration().configure("hibernate.cfg.xml");
		SchemaExport se = new SchemaExport(conf); //Create a schema exporter for the given configuration
		se.setFormat(true); //Should we format the sql strings?
		se.setDelimiter(";"); // Set the end of statement delimiter
		se.setOutputFile("ddlscript.sql"); //For generate a export script file, this is the file which will be written
		se.create(true, true);//Run the schema creation script.
		//se.drop(true, true);
		//first argument is to print the DDL to the console,
		// and second is to export the script to the database
		List list = se.getExceptions();// Returns a List of all Exceptions which accorred during the export.
		System.out.println(list);
		//to perform the validation
		SchemaValidator sv = new SchemaValidator(conf);
		sv.validate();//perform the validations
		
	}
}
