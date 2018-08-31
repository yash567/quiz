package com.cdd.client;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class Timer1 extends Timer {
	
	int i=10;
	int j=0;
	int k=60;
	@Override
	public void run() {
		if(j==0) {
			j=1;
			Quiz.q.t3.setText(i+":"+"00");
			i--;
			k--;
		}
		if(k<0) {
			k=59;
			i--;
		}
		if(k>10) {
            Integer.toString(i);
			Integer.toString(k);
			
			Quiz.q.t3.setText("0"+i+":"+k);
		}
		if(k<10) {
            Integer.toString(i);
			Integer.toString(k);
			Quiz.q.t3.setText("0"+i+":"+"0"+k);
		}
		k--;
		if(i==0&&k==0) {
			RootPanel.get("div").clear();
			RootPanel.get("div").add(new UserMenu1());
			Quiz.q.t.cancel();
			
		}
		}
	

}
