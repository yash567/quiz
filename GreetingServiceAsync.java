package com.cdd.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void createUser(String s1,String ln,String em,String ph,String ps,String re, AsyncCallback<String> callback) throws IllegalArgumentException;
	void verifyUser(String t1, String t2, AsyncCallback<String> asyncCallback) throws IllegalArgumentException;
     //void getQuiz(AsyncCallback<Quiz> asyncCallback);
	void getQuiz(String s,String s1,AsyncCallback<String> asynCallback)throws IllegalArgumentException;
	void createQuiz(String s,String s4,String s3,AsyncCallback<String> asyncCallback)throws IllegalArgumentException;
	void buildQuiz(String text, String text2, String text3, String text4, String text5,String text6,String text7,
			AsyncCallback<String> asyncCallback)throws IllegalArgumentException;
	void postResult(String s,String s1,String s2,AsyncCallback<String> asyncCallback)throws IllegalArgumentException;
	void getResult(String s,AsyncCallback<String> asyncCallback)throws IllegalArgumentException;
	void getQuiz1(AsyncCallback<String> asyncCallback)throws IllegalArgumentException;

}
