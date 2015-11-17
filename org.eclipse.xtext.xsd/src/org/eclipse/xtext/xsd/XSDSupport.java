package org.eclipse.xtext.xsd;

import org.eclipse.xtext.resource.generic.AbstractGenericResourceSupport;

import com.google.inject.Module;

public class XSDSupport extends AbstractGenericResourceSupport {

	@Override
	protected Module createGuiceModule() {
		return new XSDRuntimeModule();
	}

}
