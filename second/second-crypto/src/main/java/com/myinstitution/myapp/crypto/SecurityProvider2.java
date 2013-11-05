package com.myinstitution.myapp.crypto;

import java.security.Provider;
import java.security.Security;

import org.slf4j.Logger;

import com.myinstitution.myapp.logger.LoggerFactory;
import com.sun.crypto.provider.SunJCE;

public class SecurityProvider2 {
	private static Logger LOGGER = LoggerFactory
			.getLogger(SecurityProvider2.class);

	public static void initSecurityProvider() {
		final Provider provider = getDefaultSecurityProvider();
		int i = 1;
		LOGGER.debug("================================");
		for (Provider p : Security.getProviders()) {
			LOGGER.debug(i++ + " " + p.getName());
		}
		if (Security.getProvider(provider.getName()) == null) {
			LOGGER.debug("There's no provider with the name "
					+ provider.getName());
			Security.addProvider(provider);
		} else {
			LOGGER.debug("There's already a provider with the name "
					+ provider.getName());
			LOGGER.debug("Removing the provider with the name "
					+ provider.getName() + " and adding it again.");
			Security.removeProvider(provider.getName());
			Security.addProvider(provider);
		}
		i = 1;
		LOGGER.debug("================================");
		for (Provider p : Security.getProviders()) {
			LOGGER.debug(i++ + " " + p.getName());
		}
		LOGGER.debug("================================");
	}

	public static void configureDefaultSecurityProvider() {
		final Provider provider = getDefaultSecurityProvider();
		if (Security.getProvider(provider.getName()) == null) {
			Security.addProvider(provider);
		}
	}

	public static Provider getDefaultSecurityProvider() {
		final Provider provider = new SunJCE();
		return provider;
	}

}
