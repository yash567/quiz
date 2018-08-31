package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Timer;
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
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialSideNav;
import gwt.material.design.client.ui.MaterialSideNavDrawer;
import gwt.material.design.client.ui.MaterialTextBox;

public class NavBar extends Composite {

	private static NavBarUiBinder uiBinder = GWT.create(NavBarUiBinder.class);
	private GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	interface NavBarUiBinder extends UiBinder<Widget, NavBar> {
	}
@UiField
MaterialNavBar navBar;
@UiField
MaterialNavBar navBar1;
@UiField
MaterialNavBar navBar2;
@UiField
MaterialLink s;
@UiField
MaterialSideNavDrawer sideNav;
@UiField
MaterialLink s1;




	public NavBar() {
		initWidget(uiBinder.createAndBindUi(this));
		
	
	
		s1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Quiz.q.b1.setEnabled(true);
				
				String s=s1.getText();String s1;
				String s2 = null;
				for(int i=0;i<=s.length()-1;i++)    
				{
					if(s.charAt(i)==' ') {
						s1=s.substring(0,i);
						s2=s.substring(i+1,s.length());
						//System.out.println(fn+"         "+ln);
					}}
				a1.getQuiz(s2,"Question", new AsyncCallback<String>(){

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
						Quiz.q.t2.setText(s);
						Quiz.q.t1.setText(s0);
						Quiz.q.r1.setText(s1);
						Quiz.q.r2.setText(s2);
						Quiz.q.r3.setText(s3);
						Quiz.q.r4.setText(s4);}
					}
					
				});
			}
			
		});
		
	s.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			RootPanel.get("NavBar").clear();
			RootPanel.get("NavBar").add(Cdd.n.navBar2);
			RootPanel.get("div").clear();
			RootPanel.get("div").add(SignUp.getInstance());
			History.newItem("LoginPanel1");
		}
		
	});
	
	}

	
}
