
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.*;

public class JokesMain {
	
	public static void main(String[] args) throws InterruptedException, IOException{
		int i = 1;
		Document doc;
		String jokePage = "https://www.reddit.com/r/Jokes/comments/";
		Thread.sleep(2000);   // Prevent 429 error.
		ArrayList<String> jokes = new ArrayList<String>();
		
		try {
			doc = Jsoup.connect("https://www.reddit.com/r/jokes/").get();
			Elements links = doc.select("a[href]");
			
			/*Get 429 error without this line.*/

			
			for (Element link : links){
				if (link.attr("abs:href").toString().contains(jokePage)){
					jokes.add(link.attr("abs:href").toString());
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(String joke : jokes){
			if(i%2 == 1 && i<10){
			LinkText newJoke = new LinkText(joke);
			System.out.println(newJoke.getText());
			}
			i++;
		}
	}


}
