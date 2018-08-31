package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class UserMenu1 extends Composite {

	private static UserMenu1UiBinder uiBinder = GWT.create(UserMenu1UiBinder.class);
private GreetingServiceAsync a1 ;
	interface UserMenu1UiBinder extends UiBinder<Widget, UserMenu1> {
	}
@UiField
MaterialTextBox t1;
@UiField
MaterialButton b2;
	public UserMenu1() {
		initWidget(uiBinder.createAndBindUi(this));
	//RootPanel.get("div").add(b1);
		b2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			a1 = GWT.create(GreetingService.class);
			
				a1.getResult(LoginPanel.a.t1.getText(),new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
					       t1.setText("You scored"+" "+result);
					}
					
				});
			}
			
		});
	}

}
