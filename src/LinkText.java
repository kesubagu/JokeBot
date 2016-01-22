import java.io.IOException;

import org.jsoup.*;
import org.jsoup.nodes.Document;

public class LinkText {
	String link;
	
	public LinkText(String link){
		this.link = link;
	}
	
	public String getText() throws IOException, InterruptedException{
		Document doc = Jsoup.connect(this.link).get();
		Thread.sleep(20000);
		String theTitle = doc.select("p.title").text();
		String theBody = doc.select("div.expando div.usertext-body.may-blank-within.md-container div.md").text();
		//Thread.sleep(20000);
		
		//Thread.sleep(20000);
		
		String Joke = theTitle + " " + theBody;
		
		return Joke.replace(" (self.Jokes)", "");
	}
	

}
