package com.pluralsight.corejdbc.m2c1;

import java.awt.Color;
import util.PrintUtil;

public class Main {
	
	public static void main(String[] args) throws Exception{

		ConnectComponent comp = new ConnectComponent();
							
		if(comp.tryConnection()) {
			System.out.println("The Connection is Valid");
		}

	}

}
