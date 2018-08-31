package com.cdd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;

public class Category extends Composite {

	private static CategoryUiBinder uiBinder = GWT.create(CategoryUiBinder.class);

	interface CategoryUiBinder extends UiBinder<Widget, Category> {
	}
	@UiField
	MaterialButton b1;
		@UiField
	MaterialButton b2;
		@UiField
MaterialButton b3;
		
	static Category a=null;
	public static Category getInstance() {
		
		if(a==null) 
		{
		 a=new Category();}
	     return a;
	}
	public Category() {
		initWidget(uiBinder.createAndBindUi(this));
	
	b1.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			RootPanel.get("div").clear();
			RootPanel.get("div").add(SubCategory.getInstance());
			History.newItem("Category");

		}
		
	});
	b2.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			RootPanel.get("div").clear();
			RootPanel.get("div").add(SubCategory.getInstance());
			History.newItem("Category");

		}
		
	});
	b3.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			RootPanel.get("div").clear();
			RootPanel.get("div").add(SubCategory.getInstance());
			History.newItem("Category");

		}
		
	});
	
	}

}
