package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLink;

public class UserMenu extends Composite {

	private static UserMenuUiBinder uiBinder = GWT.create(UserMenuUiBinder.class);
	private GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface UserMenuUiBinder extends UiBinder<Widget, UserMenu> {
	}
	@UiField
MaterialButton b1;
	@UiField
MaterialButton b2;
	@UiField
	MaterialButton b3;
	@UiField
	MaterialButton b4;
static UserMenu a=null;
public static UserMenu getInstance() {
	
	if(a==null) 
	{
	 a=new UserMenu();}
     return a;
}
     private UserMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	//RootPanel.get("div").add(b1);
		b1.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
			RootPanel.get("div").clear();
				RootPanel.get("div").add(CreateQuiz.getInstance());
				//RootPanel.get("div").add(new Quiz());
				History.newItem("UserMenu"); 
			/*	a1.getQuiz(new AsyncCallback<Quiz>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(Quiz result) {
						// TODO Auto-generated method stub
						
					}
					
				});  */
				
			}
			
		});
		b2.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				RootPanel.get("div").clear();
				RootPanel.get("div").add(CreateQuiz.getInstance());
				History.newItem("UserMenu1");
		       }
			});
		b3.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				  //String s1=null;
				Quiz.q.quizType="online";
				a1.getQuiz( Quiz.q.t2.getText(),"Next",new AsyncCallback<String>() {

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
						Quiz.q.t2.setText(s);
						Quiz.q.t1.setText(s0);
						Quiz.q.r1.setText(s1);
						Quiz.q.r2.setText(s2);
						Quiz.q.r3.setText(s3);
						Quiz.q.r4.setText(s4);
						
						Cdd.n.s1.setText("Question"+" "+Quiz.q.t2.getText());
							/*if(result.charAt(i)=='~') {
								
								s0=result.substring(a2,i);
								 a2=i;
								}*/
							
							//ln=t1.substring(i+1,t1.length());}
					
					
					}});
			
				
			
					Cdd.n.sideNav.add((Widget) new MaterialLink("Question"+" "+Quiz.q.t2.getText()).addClickHandler(new ClickHandler() {

						@Override
						public void onClick(ClickEvent event) {
							// TODO Auto-generated method stub
							
						}
						
					}));
					
				
				          Quiz.q.t.run();
					RootPanel.get("div").clear();
				RootPanel.get("div").add(Quiz.q);
				History.newItem("UserMenu2");
			}
			
		});
		b4.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Quiz.q.quizType="offline";
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
				RootPanel.get("div").clear();
				RootPanel.get("div").add(Quiz.q);
				for(int i=1;i<=Quiz.q.question.length;i++) {
					
				}
				//History.newItem("UserMenu2");
			}
			
		});
     }
     }
