package com.smartsheet.api.oauth;

/*
 * #[license]
 * Smartsheet SDK for Java
 * %%
 * Copyright (C) 2014 Smartsheet
 * %%
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
 * %[license]
 */



import com.smartsheet.api.SmartsheetException;

/**
 * <p>This is the exception thrown by {@link OAuthFlow} to indicate errors occurred when obtaining authorization code.</p>
 * 
 * <p>Thread safety: Exceptions are not thread safe.</p>
 */
public class OAuthAuthorizationCodeException extends SmartsheetException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor.
	 *
	 * @param message the message
	 */
	public OAuthAuthorizationCodeException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public OAuthAuthorizationCodeException(String message, Throwable cause) {
		super(message, cause);
	}
}
