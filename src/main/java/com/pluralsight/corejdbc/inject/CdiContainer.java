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

package com.pluralsight.corejdbc.inject;

import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class CdiContainer implements java.lang.AutoCloseable {

	private static ContainerLifecycle lifecycle = null;

	public Object getCdiReference(java.lang.Class beanType) {

		Object myBean = null;

		try (PrintStream out = new PrintStream(new FileOutputStream("target/errors.txt"))) {
			System.setErr(out);

			lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
			lifecycle.startApplication(null);

			final BeanManager beanManager = lifecycle.getBeanManager();
			final Bean<?> bean = beanManager.getBeans(beanType).iterator().next();

			myBean = beanManager.getReference(bean, beanType, beanManager.createCreationalContext(bean));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return myBean;

	}

	public void close() throws Exception {
		lifecycle.stopApplication(null);
	}

}
