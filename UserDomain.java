package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class UserDomain extends Composite {

	private static UserDomainUiBinder uiBinder = GWT.create(UserDomainUiBinder.class);

	interface UserDomainUiBinder extends UiBinder<Widget, UserDomain> {
	}

	public UserDomain() {
		RootPanel.get("NavBar").clear();
		initWidget(uiBinder.createAndBindUi(this));


	
	}}