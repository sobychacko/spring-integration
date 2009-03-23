/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.router;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.Router;
import org.springframework.integration.channel.ChannelResolver;
import org.springframework.integration.core.Message;
import org.springframework.integration.handler.MessageMappingMethodInvoker;

/**
 * A Message Router that invokes the specified method on the given object. The
 * method's return value may be a single MessageChannel instance, a single
 * String to be interpreted as a channel name, or a Collection (or Array) of
 * either type. If the method returns channel names, then a
 * {@link ChannelResolver} is required.
 * 
 * @author Mark Fisher
 */
public class MethodInvokingRouter extends AbstractChannelNameResolvingMessageRouter {

	private final MessageMappingMethodInvoker invoker;

	

	public MethodInvokingRouter(Object object, Method method) {
		this.invoker = new MessageMappingMethodInvoker(object, method);
	}

	public MethodInvokingRouter(Object object, String methodName) {
		this.invoker = new MessageMappingMethodInvoker(object, methodName);
	}

	public MethodInvokingRouter(Object object) {
		this.invoker = new MessageMappingMethodInvoker(object, Router.class);
	}

	@Override
	protected List<Object> getChannelIndicatorList(Message<?> message) {
		Object result = this.invoker.invokeMethod(message);
		List<Object> asList = new ArrayList<Object>();
		asList.add(result);
		return asList;
	}

}
