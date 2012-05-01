/*
 * Copyright 2002-2012 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.springframework.integration.dsl.groovy.builder

import java.util.Map
import org.springframework.integration.dsl.groovy.RouterComposition

import groovy.util.AbstractFactory
import groovy.util.FactoryBuilderSupport

/**
 * @author David Turanski
 *
 */
public class ChannelMapFactory extends IntegrationComponentFactory {

	/* (non-Javadoc)
	 * @see groovy.util.Factory#newInstance(groovy.util.FactoryBuilderSupport, java.lang.Object, java.lang.Object, java.util.Map)
	 */
	public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes)
	throws InstantiationException, IllegalAccessException {
		attributes
	}

	@Override
	boolean isLeaf() {
		true
	}
	
	
	public void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
		if (logger.isDebugEnabled()) {
			logger.debug("set parent parent:${parent.class} child:${child.class}")
		}
		assert parent instanceof RouterComposition, "${parent.class} must be a child of " + RouterComposition
		
		parent.channelMap = child
		 
	}
	
}