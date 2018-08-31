package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class LoginPanel extends Composite {

	private static LoginPanelUiBinder uiBinder = GWT.create(LoginPanelUiBinder.class);
	private GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface LoginPanelUiBinder extends UiBinder<Widget, LoginPanel> {
	}
	@UiField
MaterialButton login;
@UiField
MaterialTextBox t1;
@UiField
MaterialTextBox t2;
static LoginPanel a=null;
public static LoginPanel getInstance() {
	
	if(a==null) 
	{
	 a=new LoginPanel();}
     return a;
}
	private LoginPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		
		login.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String t1=a.t1.getText();
				String t2=a.t2.getText();
				
				a1.verifyUser(t1,t2,new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						}
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						if(result=="1") {
						RootPanel.get("NavBar").clear();
						RootPanel.get("NavBar").add(Cdd.n.navBar1);
						RootPanel.get("NavBar").add(Cdd.n.sideNav);
						RootPanel.get("div").clear();
						//RootPanel.get("div").add(new UserDomain());
						RootPanel.get("div").add(UserMenu.getInstance());
						History.newItem("LoginPanel");
					}else {
						MaterialToast.fireToast(result);
					}
					}});
				}
			});
}}


