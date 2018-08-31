package com.cdd.client;

import com.cdd.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Cdd implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network " + "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
    public static NavBar n=new NavBar();
	@Override
	public void onModuleLoad() {
		
		RootPanel.get("div").add(LoginPanel.getInstance());
		RootPanel.get("NavBar").add(n.navBar);
				
		History.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				// TODO Auto-generated method stub
				
		if(History.getToken().equals("LoginPanel"))
		{RootPanel.get("div").clear();
		RootPanel.get("div").add(UserMenu.getInstance());
}
		
		if(History.getToken().equals(""))
		{RootPanel.get("div").clear();
		RootPanel.get("NavBar").clear();
				RootPanel.get("div").add(LoginPanel.getInstance());
				RootPanel.get("NavBar").add(n.navBar);
		}
		if(History.getToken().equals("UserMenu"))
		{RootPanel.get("div").clear();
		RootPanel.get("div").add(CreateQuiz.getInstance());
}
		if(History.getToken().equals("UserMenu1"))
{RootPanel.get("div").clear();
RootPanel.get("div").add(Category.getInstance());
} 
		if(History.getToken().equals("Category"))
		{RootPanel.get("div").clear();
		RootPanel.get("div").add(SubCategory.getInstance());
		} 	/*if(History.getToken().equals("UserMenu2"))
		{RootPanel.get("div").clear();
		RootPanel.get("div").add(new Quiz());
		} */
		}
});
		}}
