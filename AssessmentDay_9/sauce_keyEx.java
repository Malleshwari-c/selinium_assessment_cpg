package keyWordDriven;

public class sauce_keyEx {
  //create an object of sauce keyword implementation class
	sauce_keyWordI se=new sauce_keyWordI();
	//create a method of sauceExec and give the keyword as an argument
	public void sauceExec(String kw) throws InterruptedException {
    //if "LAUNCH_BROWSER" is a keyword it executes launch browser method from implementation class
		if(kw.equals("LAUNCH_BROWSER")) {
			se.launchBrowser();
		}
    //if "OPEN_URL" is a keyword it executes launch browser method from implementation class
		else if(kw.equals("OPEN_URL")) {
			se.openurl();
		}
    //if "USERNAME" is a keyword it executes launch browser method from implementation class
		else if(kw.equals("USERNAME")) {
			se.userName();
		}
    //if "PASSWORD" is a keyword it executes launch browser method from implementation class
		else if(kw.equals("PASSWORD")) {
			se.password();
		}
		//if "LOGIN_B" is a keyword it executes launch browser method from implementation class
		else if(kw.equals("LOGIN_B")) {
			se.loginB();	
		}
    //if "CLOSE_B" is a keyword it executes launch browser method from implementation class
		else if(kw.equals("CLOSE_B")) {
			se.closeBw();
		}
	}

}
