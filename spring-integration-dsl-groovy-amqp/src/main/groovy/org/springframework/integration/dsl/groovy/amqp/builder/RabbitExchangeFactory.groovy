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
package org.springframework.integration.dsl.groovy.amqp.builder
import groovy.util.FactoryBuilderSupport
import java.util.Map
import org.springframework.integration.dsl.groovy.builder.IntegrationComponentFactory
import org.springframework.integration.dsl.groovy.builder.SpringXmlComponentFactory

/**
 * @author David Turanski
 *
 */
class RabbitExchangeFactory extends SpringXmlComponentFactory {

	/* (non-Javadoc)
	 * @see org.springframework.integration.dsl.groovy.builder.IntegrationComponentFactory#doNewInstance(groovy.util.FactoryBuilderSupport, java.lang.Object, java.lang.Object, java.util.Map)
	 */
	@Override
	protected Object doNewInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) {
		String elementName = propertyNameToAttributeName(name).replace('rabbit-','rabbit:')
		
		def bindings
		if (attributes.containsKey('bindings')){
			bindings = attributes.remove('bindings')
		}
		builder.springXml{"$elementName"(attributes) {
				if (bindings){
					'rabbit:bindings' {
					// Expecting a list of Maps
						bindings.each {Map binding ->
							'rabbit:binding'(binding)
						}
					}
				}
			}
		}
	}
}