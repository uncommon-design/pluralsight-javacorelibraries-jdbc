/**
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements.  See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License.  You may obtain a copy of the License at
http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.pluralsight.corejdbc.m3c5;

public class Main {
	
	public static void main(String[] args) throws Exception{

		final String errorMsg = "You must secify either JEE or CDI as an imput paramters";

		if (args.length != 1) {
			System.out.println(errorMsg);
			return;
		}
		
		String argValue = args[0];

		if (argValue.equalsIgnoreCase("A")) {
			ProductsComponent_A comp = new ProductsComponent_A();
			comp.printProductList();
		}else if(argValue.equalsIgnoreCase("B")) {
			ProductsComponent_C comp = new ProductsComponent_C();
			comp.printProductList();
		}else if(argValue.equalsIgnoreCase("C")) {
			ProductsComponent_C comp = new ProductsComponent_C();
			comp.printProductList();
		}else {
			System.out.println(errorMsg);
		}
		

	}
}
