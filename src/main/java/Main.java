import java.awt.Color;
import java.sql.SQLException;

import util.PrintUtil;

public class Main {
	
	public static void main(String [] args) throws Exception{
		if(args.length == 0) {
			Main.inValidMessage();
			return;
		}
		
		
		try {
			switch(args[0]){
				case "m2c1":
					com.pluralsight.corejdbc.m2c1.Main.main(null);
					break;
				case "m3c1":
					com.pluralsight.corejdbc.m3c1.Main.main(null);
					break;
				case "m3c2":
					com.pluralsight.corejdbc.m3c2.Main.main(null);
					break;
				case "m3c3":
					String[] myargs_m3c3 = null;
					if(args.length == 2) {
						myargs_m3c3 = new String[1];
						myargs_m3c3[0] = args[1];
					}
					com.pluralsight.corejdbc.m3c3.Main.main(myargs_m3c3);
					break;
				case "m3c4":
					com.pluralsight.corejdbc.m3c4.Main.main(null);
					break;
				case "m3c5":
					com.pluralsight.corejdbc.m3c5.Main.main(null);
					break;
				default:
					inValidMessage();
					
			}
		}catch (Exception ex){
			System.out.println(ex.getMessage());
    		if(ex instanceof SQLException || ex.getCause() instanceof SQLException) {
    			printSQLException((SQLException)ex);
    		}else {
        		PrintUtil.colorPrint("An exception was thrown:",Color.orange, true);
        		PrintUtil.colorPrint(ex.getMessage(),Color.orange, true);
    		}
		}
	}
	public static void printSQLException(SQLException sqlEx) {
		PrintUtil.colorPrint("A SQLException was thrown:",Color.orange, true);
		PrintUtil.colorPrint(sqlEx.getMessage(),Color.orange, true);
		PrintUtil.colorPrint("SQLState: " + sqlEx.getSQLState(), Color.orange, true);
		PrintUtil.colorPrint("VendorError: " + sqlEx.getErrorCode(), Color.orange, true);

	}
	public static void inValidMessage() {
		System.out.println("You must specifiy which a valid demo to run. For example:");
		PrintUtil.colorPrint("java -cp target/corejdbc.jar Main ", Color.blue, false);
		PrintUtil.colorPrint("m2c1", Color.orange, true);
	}

}
