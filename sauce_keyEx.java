package keyWordDriven;

public class sauce_keyEx {
	sauce_keyWordI se=new sauce_keyWordI();
	
	public void sauceExec(String kw) throws InterruptedException {
		if(kw.equals("LAUNCH_BROWSER")) {
			se.launchBrowser();
		}
		else if(kw.equals("OPEN_URL")) {
			se.openurl();
		}
		else if(kw.equals("USERNAME")) {
			se.userName();
		}
		else if(kw.equals("PASSWORD")) {
			se.password();
		}
		
		else if(kw.equals("LOGIN_B")) {
			se.loginB();
			
		}
		else if(kw.equals("CLOSE_B")) {
			se.closeBw();
		}
	}

}
