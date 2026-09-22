package final_ass_POMFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class commonDataf {
	public String BROWSER;
	public String URL;
	public String USERNAME,PASSWORD;
	
	public void bowser() throws IOException {
		FileInputStream fis=new FileInputStream("./src/test/resources/DDT1/comData.properties");
		Properties pro=new Properties();
		pro.load(fis);
		BROWSER=pro.getProperty("browser");
		URL=pro.getProperty("url");
		USERNAME=pro.getProperty("username");
		PASSWORD=pro.getProperty("password");
	}

}


