/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.impl.javasupport;

import com.google.inject.Inject;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.javasupport.UnconfirmedStructuralChangesDelta;
import org.eclipse.xtext.common.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.common.types.ui.notification.DeltaConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class BuilderDeltaConverter extends DeltaConverter {
	@Inject
	public BuilderDeltaConverter(IQualifiedNameConverter nameConverter, TypeURIHelper uriHelper, IBuilderState builderState) {
		super(nameConverter, uriHelper, builderState);
	}

	@Override
	public IResourceDescription.Delta createStructureChangeDelta(IType type, IResourceDescription oldDescription,
			IResourceDescription newDescription) {
		return new UnconfirmedStructuralChangesDelta(type, oldDescription, newDescription);
	}
}