/*
 * Copyright 2002-2010 the original author or authors.
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
package com.springframework.integration.samples.loanbroker.loanshark.biz;

/**
 * @author Gary Russell
 *
 */
public class SharkQuote {
	private String sharkName;
	private Double sharkRate;
	
	/**
	 * @param sharkName
	 * @param sharkRate
	 */
	public SharkQuote(String sharkName, double sharkRate) {
		super();
		this.sharkName = sharkName;
		this.sharkRate = sharkRate;
	}
	/**
	 * @return the sharkName
	 */
	public String getSharkName() {
		return sharkName;
	}
	/**
	 * @param sharkName the sharkName to set
	 */
	public void setSharkName(String sharkName) {
		this.sharkName = sharkName;
	}
	/**
	 * @return the sharkRate
	 */
	public Double getSharkRate() {
		return sharkRate;
	}
	/**
	 * @param sharkRate the sharkRate to set
	 */
	public void setSharkRate(Double sharkRate) {
		this.sharkRate = sharkRate;
	}
}