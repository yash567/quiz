package com.cdd.server;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cdd.client.Cdd;
import com.cdd.client.GreetingService;
import com.cdd.client.Quiz;
import com.cdd.client.UserMenu;
import com.cdd.client.Quiz;
import com.cdd.shared.FieldVerifier;
import com.google.gwt.core.ext.typeinfo.JType;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.client.rpc.SerializationStreamReader;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.user.client.rpc.impl.Serializer;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.rebind.rpc.SerializationUtils;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService{
     Connection con=null;
	Statement st=null;
	Statement st1=null;
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/syncquiz","root","");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st=(Statement) con.createStatement();
			st1=(Statement)con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public String createUser(String s1,String ln,String em,String ph,String ps,String re) throws IllegalArgumentException {
		int a=0;
		init();
		if(ps==re){ try{
			st.executeUpdate("insert into userdata(fn,ln,em,ph,ps) values('"+s1+"','"+ln+"','"+em+"','"+ph+"','"+ps+"')");
			a=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(a!=0) {
			return "Data inserted succesfully";
		}
		else {
			return "Data insertion unsuccesful";
		}
	}else{
		return "Please enter a correct password";
	}}
		@Override
		public String verifyUser(String t1, String t2) throws IllegalArgumentException{
			// TODO Auto-generated method stub
		init();
		//Quiz q=new Quiz();
		String result = null;
		ResultSet a = null;
		String fn=null,ln=null,ps=null;
		for(int i=0;i<=t1.length()-1;i++)    
		{
			if(t1.charAt(i)==' ') {
				fn=t1.substring(0,i);
				ln=t1.substring(i+1,t1.length());
				//System.out.println(fn+"         "+ln);
			}}
		
		try {
			 a = st.executeQuery("SELECT * FROM `userdata` WHERE fn='"+fn+"' and ln='"+ln+"' and ps='"+t2+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
					try {
						if(a.next()) {
						     result= "1";
						}
						else {result= "Please enter a valid username or password";
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//return SerializationUtils.getRpcTypeName(q.getErasedType());
				return result;}
		
		/*@Override
		public Quiz getQuiz() {
			// TODO Auto-generated method stub
                init();
                String s = null;
               Quiz q=null;
                ResultSet a=null;
                try {
					a=st.executeQuery("SELECT * FROM `userdata`");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
					a.next(); 
						 s=a.getString(0);
					 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
           
				
                //q=new Quiz();
                //q.t1.setText(s);
                return q;    
		}*/
		@Override
		public String getQuiz(String a2,String a3) {
			// TODO Auto-generated method stub
			init();
			//int a1=Integer.parseInt(Quiz.q.t2.getText());
			int a1=Integer.parseInt(a2);
			String s=null;String s0=null;String s1=null;String s2=null;String s3=null;String s4=null;
			ResultSet a=null;
			try {
				a=st.executeQuery("SELECT * FROM `questions`");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try 
			{if(a3.equals("Next")) {
				for(int i=0;i<=a1;i++) {
				a.next();}}
			else {
				if(a3.equals("Question")) {
					for(int i=1;i<=a1;i++) {
					a.next();}}
				else {
					for(int i=1;i<=(a1-1);i++) {
						a.next();}
				}
			}
				s=a.getString(1);		
				s0=a.getString(2);
			s1=a.getString(3);
				s2=a.getString(4);
			s3=a.getString(5);
             s4=a.getString(6);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(s0+"         "+s1);
			return s+";"+s0+"~"+s1+"`"+s2+"$"+s3+"|"+s4;
		}
		@Override
		public String createQuiz(String s6, String s1, String s2) throws IllegalArgumentException {
			// TODO Auto-generated method stub
			init();
			int k=0;
			try {
				k=st.executeUpdate("insert into quizdata(id,qn,time) values('"+s6+"','"+s1+"','"+s2+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (k!=0) {
				return "Quiz created";
			}
			else {
				return "Data insertion unsuccessful";
			}
		}
		@Override
		public String buildQuiz(String text, String text2, String text3, String text4, String text5,String text6, String text7)
				 {
			// TODO Auto-generated method stub
			init();
			int k=0;int a=0;
			try {
				a=st.executeUpdate("insert into answer(qn,ans) values('"+text+"','"+text7+"')");
				k=st.executeUpdate("insert into questions(qn,qu,op1,op2,op3,op4) values('"+text+"','"+text2+"','"+text3+"','"+text4+"','"+text5+"','"+text6+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}if (k!=0&&a!=0) {
				return "Question added";
			}
			else {
				return "Data insertion unsuccessful";
			}
		}
		@Override
		public String postResult(String s,String s1,String s2) throws IllegalArgumentException {
			// TODO Auto-generated method stub
               init();
               try {
				st.executeUpdate("insert into result1(user,qn,ans) values('"+s+"','"+s1+"','"+s2+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
               return null;
		}
		@Override
		public String getResult(String s) throws IllegalArgumentException {
			// TODO Auto-generated method stub
		init();
		ResultSet a = null,a1 = null;
		int a2=0;
		try {
			a=st1.executeQuery("SELECT * FROM `answer`");
			a1=st.executeQuery("SELECT * FROM `result1`");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			a1.last();
			int a3=a1.getRow();
			a1.first();
			a.first();
			for(int i=1;i<=a3;i++) {
				if(a1.getString(1).equals(s)) {
					String s2=a1.getString(3);
					String s3=a.getString(2);
					
					if(s2.equals(s3)) {
						System.out.println("         "+s2+" "+s3);
						a2=a2+1;
					}
					else if(s2.equals(s3)) {
						System.out.println("         "+s2+" "+s3);
						a2=a2+1;
					}
					a.next();
				
				}
					a1.next();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			while(a1.next()) {
		
				if(a1.getString(1)==s) {
					a2=a2++;
				a.next();
					s2=a1.getString(3);
				s4=a.getString(2);
					if(s2==s4) {
							
					}
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return Integer.toString(a2);
		}
		@Override
		public String getQuiz1() throws IllegalArgumentException
		{
			init();
			ResultSet a;
			String s5 ="";
			try {
				a=st.executeQuery("SELECT * FROM `questions`");
				a.last();
				int a1=a.getRow();
				a.first();
				for(int i=1;i<=a1;i++) {
					String s=a.getString(1);		
					String s0=a.getString(2);
					String s1=a.getString(3);
					String s2=a.getString(4);
					String s3=a.getString(5);
					String s4=a.getString(6);
					s5=s5+s+","+s0+","+s1+","+s2+","+s3+","+s4+"&";
					a.next();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return s5;
			
		}
		
		}
		

