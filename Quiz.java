package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;

public class Quiz extends Composite{

	private static QuizUiBinder uiBinder = GWT.create(QuizUiBinder.class);
	private GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface QuizUiBinder extends UiBinder<Widget, Quiz> {
	}
@UiField
MaterialTextBox t1;
@UiField
public MaterialTextBox t2;
@UiField
MaterialRadioButton r1;
@UiField
MaterialRadioButton r2;
@UiField
MaterialRadioButton r3;
@UiField
MaterialRadioButton r4;
@UiField
MaterialButton b1;
@UiField
MaterialButton b2;
@UiField
MaterialButton b3;
String answer;
Timer1 t=new Timer1();
@UiField
MaterialTextBox t3;
String[] question;
String quizType;
static public Quiz q=new Quiz();

	public Quiz() {
		initWidget(uiBinder.createAndBindUi(this));
		t2.setText("0");
		b2.setEnabled(false);
		b3.setEnabled(false);
		t.scheduleRepeating(1000);
		t3.setTextColor(Color.BLACK);
		a1.getQuiz1(new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				question=result.split("&");
			}
			
		});
	    b2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				t.cancel();
				RootPanel.get("div").clear();
				RootPanel.get("div").add(new UserMenu1());
			}
	    	
	    });
		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				b3.setEnabled(true);
				if(quizType=="online") {
				q.getAnswer();
				a1.postResult(LoginPanel.a.t1.getText(),t2.getText(),answer,new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
					//	MaterialToast.fireToast("bsdj");
					}
					
				});		
			a1.getQuiz(t2.getText(),"Next",new AsyncCallback<String>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void onSuccess(String result) {
					// TODO Auto-generated method stub
					int a2=0;String s=null;String s0=null;String s1=null;String s2=null;String s3=null;String s4=null;
					
					for(int i=0;i<=result.length()-1;i++)    
					{    if(result.charAt(i)==';') {
						  s=result.substring(0,i);
						a2=i+1;
						}
						if(result.charAt(i)=='~') {
						  s0=result.substring(a2,i);
						a2=i+1;
						}
					if(result.charAt(i)=='`') {
						s1=result.substring(a2,i);
						a2=i+1;
						}
					
					if(result.charAt(i)=='$') {
						s2=result.substring(a2,i);
					a2=i+1	;
					}
                     if(result.charAt(i)=='|') {
                    	 s3=result.substring(a2,i);
 						a2=i+1;	
					}
                    s4=result.substring(a2,result.length());   
					}if(s!="null"&&s0!="null") {
					t2.setText(s);
					t1.setText(s0);
				    r1.setText(s1);
				    r2.setText(s2);
					r3.setText(s3);
				    r4.setText(s4);
				}else {
					b1.setEnabled(false);
				     b2.setEnabled(true);
				}
					}
				
			});
			Cdd.n.sideNav.add((Widget) new MaterialLink("Question"+" "+Quiz.q.t2.getText()).addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
				}
				
			}));
			
				}
			if(quizType=="offline") {
				int a=Integer.parseInt(Quiz.q.t2.getText());
				String s=null;String s0=null;String s1=null;String s2=null;String s3=null;String s4=null;
				String s5=Quiz.q.question[a];
				String[] s6=s5.split(",");
				s0=s6[0];
				s=s6[1];
				s1=s6[2];
				s2=s6[3];
				s3=s6[4];
				s4=s6[5];
				Quiz.q.t2.setText(s0);
				Quiz.q.t1.setText(s);
				Quiz.q.r1.setText(s1);
				Quiz.q.r2.setText(s2);
				Quiz.q.r3.setText(s3);
				Quiz.q.r4.setText(s4);
			}
			}
			
		});
		b3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				a1.getQuiz(t2.getText(),"Previous",new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						int a2=0;String s=null;String s0=null;String s1=null;String s2=null;String s3=null;String s4=null;
						
						for(int i=0;i<=result.length()-1;i++)    
						{    if(result.charAt(i)==';') {
							  s=result.substring(0,i);
							a2=i+1;
							}
							if(result.charAt(i)=='~') {
							  s0=result.substring(a2,i);
							a2=i+1;
							}
						if(result.charAt(i)=='`') {
							s1=result.substring(a2,i);
							a2=i+1;
							}
						
						if(result.charAt(i)=='$') {
							s2=result.substring(a2,i);
						a2=i+1	;
						}
	                     if(result.charAt(i)=='|') {
	                    	 s3=result.substring(a2,i);
	 						a2=i+1;	
						}
	                    s4=result.substring(a2,result.length());   
						}
						t2.setText(s);
						t1.setText(s0);
					    r1.setText(s1);
					    r2.setText(s2);
						r3.setText(s3);
					    r4.setText(s4);
					    if(s=="1") {
				
							b3.setEnabled(false);
					    }
					}
					
				});
			}
			
		});
		
	}
	void getAnswer() {
		if(r1.isChecked()) {
			answer=r1.getText();
			r1.setChecked(false);
			}
			else {
				if(r2.isChecked()) {
					answer=r2.getText();
					r2.setChecked(false);
				}
				else {
					if(r3.isChecked()) {
						answer=r3.getText();
						r3.setChecked(false);
					}
					else {
						if(r4.isChecked()) {
							answer=r4.getText();
							r4.setChecked(false);
					}
						else {
							answer="Unanswered";
						}
					}
				}
			}
	
	}

}