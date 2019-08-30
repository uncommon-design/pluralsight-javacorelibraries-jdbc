package com.pluralsight.corejdbc.m2;

import java.awt.Color;
import util.PrintUtil;

public class Main {
	
	public static void main(String[] args) throws Exception{

		ConnectComponent comp = new ConnectComponent();
							
		if(comp.tryConnection()) {
			System.out.println("Demo m2c1:");
			System.out.println("The attempt to Connection was a SUCCESS");
		}else {
			System.out.println("Demo m2c1:");
			System.out.println("The attempt to Connection FAILED");
		}

	}

}
