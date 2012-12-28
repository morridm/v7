package uk.co.q3c.basic.shiro;

import javax.servlet.ServletContext;

import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.io.ResourceUtils;

import uk.co.q3c.basic.A;

import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class Q3ShiroWebModule extends ShiroWebModule {

	public Q3ShiroWebModule(ServletContext sc) {
		super(sc);
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void configureShiroWeb() {
		bindRealm().to(ShiroDebugRealm.class);
		addFilterChain("/rest/**", ANON);
		addFilterChain("/**", ANON/* AUTHC_BASIC */);
		bindConstant().annotatedWith(Names.named("shiro.globalSessionTimeout")).to(30000L);
	}

	@Provides
	@Named(A.SHIRO_CONFIG_PATH)
	String getConfigPath() {
		return ResourceUtils.CLASSPATH_PREFIX + "shiro.ini";
	}

}
