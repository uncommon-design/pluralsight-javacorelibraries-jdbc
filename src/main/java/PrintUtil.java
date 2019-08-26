import java.awt.Color;

public class PrintUtil {
	
    public static void colorPrint(String txt, Color color, boolean line) {
    	

		
		String defaultColor = (char)27 + "[0m";
		String txtColor = defaultColor;
		if(color == Color.orange) {
			txtColor = (char)27 + "[33m";
		}else if (color == Color.green) {
			txtColor = (char)27 + "[32m";
		}else if (color == Color.blue) {
			txtColor = (char)27 + "[34m";
		}

		// Change this to the desired output (e.g. JUL)
    	System.out.print(txtColor + txt + "" + defaultColor);
    	if(line) {
    		System.out.println("");
    	}


    }

}
