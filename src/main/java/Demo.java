import java.awt.Color;
import java.sql.SQLException;

import util.PrintUtil;

public class Demo {
	
	public static void main(String [] args) throws Exception{
		if(args.length == 0) {
			Demo.inValidMessage();
			return;
		}
		
		
		try {
			switch(args[0]){
				case "m2c1":
					com.pluralsight.corejdbc.m2.Main.main(null);
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
				case "m4c1":
					com.pluralsight.corejdbc.m4c1.Main.main(null);
					break;
				case "m4c2":
					com.pluralsight.corejdbc.m4c3.Main.main(null);
					break;
				case "m4c3":
					com.pluralsight.corejdbc.m4c5.Main.main(null);
					break;
				case "m5c1":
					String[] myargs_m5c1 = null;
					if(args.length == 4) {
						myargs_m5c1 = new String[3];
						myargs_m5c1[0] = args[1];
						myargs_m5c1[1] = args[2];
						myargs_m5c1[2] = args[3];
					}
					com.pluralsight.corejdbc.m5c2.Main.main(myargs_m5c1);
					break;
				case "m5c2":
					String[] myargs_m5c2 = null;
					if(args.length == 3) {
						myargs_m5c2 = new String[2];
						myargs_m5c2[0] = args[1];
						myargs_m5c2[1] = args[2];
					}
					com.pluralsight.corejdbc.m5c2.Main.main(myargs_m5c2);
					break;
				case "m5c3":
					com.pluralsight.corejdbc.m5c3.Main.main(null);
					break;
				case "m6c1":
					com.pluralsight.corejdbc.tryWithResources.Main.main(null);
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
