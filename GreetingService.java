package com.cdd.client;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String createUser(String s1,String ln,String em,String ph,String ps,String re) throws IllegalArgumentException;
    String verifyUser(String t1, String t2) throws IllegalArgumentException;
   //Quiz getQuiz();
    String getQuiz(String s,String s1)throws IllegalArgumentException;
	String createQuiz(String s,String s1,String s2)throws IllegalArgumentException;
	String buildQuiz(String text, String text2, String text3, String text4, String text5,String text6,String text7)throws IllegalArgumentException;
	String postResult(String s,String s1,String s2)throws IllegalArgumentException;
	String getResult(String s)throws IllegalArgumentException;
	String getQuiz1()throws IllegalArgumentException;
}
