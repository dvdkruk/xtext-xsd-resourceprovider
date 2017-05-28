package org.eclipse.xtext.xsd;

import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule;

@SuppressWarnings("restriction")
public class XSDRuntimeModule extends AbstractGenericResourceRuntimeModule {

	@Override
	protected String getLanguageName() {
		// "org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor"
		return InternalXSDMultiPageEditor.class.getName();
	}

	@Override
	protected String getFileExtensions() {
		// "xsd"
		return org.eclipse.xsd.XSDPackage.eNS_PREFIX;
	}

	public Class<? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return XSDResourceDescriptionStrategy.class;
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return XSDQualifiedNameProvider.class;
	}

}
