package ass_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Common_data {
	
	public String BROWSER;
	public String URL;
	public String USERNAME;
	public String PASSWORD;
	
	public void cdata() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT/ass_9.properties");
		Properties pro=new Properties();
		pro.load(fis);
		BROWSER=pro.getProperty("browser");
		URL=pro.getProperty("url");
		USERNAME=pro.getProperty("username");
		PASSWORD=pro.getProperty("password");
	}

}
