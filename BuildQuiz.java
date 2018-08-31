package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickHandler;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class BuildQuiz extends Composite {

	private static BuildQuizUiBinder uiBinder = GWT.create(BuildQuizUiBinder.class);
	private static GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface BuildQuizUiBinder extends UiBinder<Widget, BuildQuiz> {
	}
	static BuildQuiz a=null;
	@UiField
	MaterialTextBox t1;
	@UiField
	MaterialTextBox t2;
	@UiField
	MaterialTextBox t3;
	@UiField
	MaterialTextBox t4;
	@UiField
	MaterialTextBox t5;
	@UiField
	MaterialButton b1;
	@UiField
	MaterialTextBox t7;
	int a2=1;
	public static BuildQuiz getInstance() {
		
		if(a==null) 
		{
		 a=new BuildQuiz();}
	     return a;
	}
	private BuildQuiz() {
		initWidget(uiBinder.createAndBindUi(this));
		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				int n=Integer.parseInt(CreateQuiz.a.ct2.getText());
				
					if(a2<=n) {
				
			BuildQuiz.a1.buildQuiz(Integer.toString(a2),t5.getText(),t1.getText(),t2.getText(),t3.getText(),t4.getText(),t7.getText(),new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					}
             @Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					a2++;
	      }
			});}
					else {
						MaterialToast.fireToast("Question limit achieved");
					}
				
			}
			
		});
	}

}