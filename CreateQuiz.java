package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class CreateQuiz extends Composite {

	private static CreateQuizUiBinder uiBinder = GWT.create(CreateQuizUiBinder.class);
	private static GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface CreateQuizUiBinder extends UiBinder<Widget, CreateQuiz> {
	}
	static CreateQuiz a=null;
	@UiField
	MaterialTextBox ct1;
	@UiField
	MaterialTextBox ct2;
	@UiField
	MaterialTextBox ct3;
	@UiField
	MaterialButton cb1;
	public static CreateQuiz getInstance() {
		
		if(a==null) 
		{
		 a=new CreateQuiz();}
	     return a;
	}
	
	private CreateQuiz() {
		initWidget(uiBinder.createAndBindUi(this));
	cb1.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			String s=ct1.getText();
			String s1=ct2.getText();
			String s2=ct3.getText();
			
			RootPanel.get("div").clear();
			RootPanel.get("div").add(BuildQuiz.getInstance());
			History.newItem("CreateQuiz");
		/*CreateQuiz.a1.createQuiz(s,s1,s2,new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				MaterialToast.fireToast(result);
			}
			
		})	;*/
		}
		
	});
	

}}
