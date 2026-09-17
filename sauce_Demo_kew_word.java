package keyWordDriven;

public class sauce_Demo_kew_word {
	public static void main(String[] args) throws InterruptedException {
		sauce_keyEx  SE= new sauce_keyEx();
		SE.sauceExec("LAUNCH_BROWSER");
		SE.sauceExec("OPEN_URL");
		SE.sauceExec("USERNAME");
		SE.sauceExec("PASSWORD");
		SE.sauceExec("LOGIN_B");
		Thread.sleep(1000);
		SE.sauceExec("CLOSE_B");

	}
		

	
}
