package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class SignUp extends Composite {

	private static SignUpUiBinder uiBinder = GWT.create(SignUpUiBinder.class);

	interface SignUpUiBinder extends UiBinder<Widget, SignUp> {
	}
	private GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	@UiField
	MaterialButton sb1;
	@UiField
	MaterialTextBox st1;
	@UiField
	MaterialTextBox st2;
	@UiField
	MaterialTextBox st3;
	@UiField
	MaterialTextBox st4;
	@UiField
	MaterialTextBox st5;
	@UiField
	MaterialTextBox st6;
 static SignUp a=null;
 
public static SignUp getInstance() {
	if (a==null) {
       a=new SignUp();
     }
    	 return a; 
     }
  private SignUp() {
		initWidget(uiBinder.createAndBindUi(this));
		sb1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				String fn=st1.getText();
				String ln=st2.getText();
				String em=st3.getText();
				String ph =st4.getText();
				String ps=st5.getText();
	            String re=st6.getText();
	            	 a1.createUser(fn,ln,em,ph,ps,re,new AsyncCallback<String>(){

	 					@Override
	 					public void onFailure(Throwable caught) {
	 						// TODO Auto-generated method stub
	 					
	 					}

	 					@Override
	 					public void onSuccess(String result) {
	 						// TODO Auto-generated method stub
	 						//MaterialToast.fireToast(result);
	 						MaterialToast.fireToast(result);
	 					}
	 			
	 				});
	            }
	           });
  }}

