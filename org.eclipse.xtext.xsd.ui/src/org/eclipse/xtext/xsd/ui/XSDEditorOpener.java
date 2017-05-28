package org.eclipse.xtext.xsd.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.wst.xsd.ui.internal.editor.InternalXSDMultiPageEditor;
import org.eclipse.xsd.XSDConcreteComponent;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class XSDEditorOpener extends LanguageSpecificURIEditorOpener {

	@Inject(optional = true)
	private IWorkbench workbench;

	@Override
	protected void selectAndReveal(IEditorPart openEditor, URI uri, EReference crossReference, int indexInList,
			boolean select) {
		final InternalXSDMultiPageEditor xsdEditor = openEditor.getAdapter(InternalXSDMultiPageEditor.class);
		if (xsdEditor != null && select) {
			final EObject eObject = xsdEditor.getXSDSchema().eResource().getEObject(uri.fragment());
			if (eObject instanceof XSDConcreteComponent) {
				final XSDConcreteComponent xsdComponent = (XSDConcreteComponent) eObject;
				workbench.getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						xsdEditor.openOnGlobalReference(xsdComponent);
					}
				});
			}
		}

	}
}
