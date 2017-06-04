package main.java.com;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.BufferedReader;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Main {
		
	public static void main(String[] args) {
		String modelDirectory = "CommonNounExtractor\\tagger\\models\\english-left3words-distsim.tagger";
		System.out.println(args[0]);
		String filesDirectory = args[0];
		
		ObjectMapper mapper = new ObjectMapper();
		File f = new File(filesDirectory);
		PosTagger pos = new PosTagger(modelDirectory);
		Integer i = 0;
		Map<String, Integer> reviewWordCount = new HashMap<String, Integer>();
		try {
			BufferedReader b = new BufferedReader(new FileReader(f));
			String reviewString = "";
			while ((reviewString = b.readLine()) != null) {
				i++;
				ReviewPOJO review1 = mapper.readValue(reviewString, ReviewPOJO.class);
    			List<String> wordList = pos.getPosTag(review1.getReviewText());
    			for(String word: wordList) {
    				  Integer count = reviewWordCount.get(word);    
    				  reviewWordCount.put(word, (count==null) ? 1 : count+1);
    				}
            }
			b.close();

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Integer>  sortedReviewWordCount = new TreeMap<String, Integer>(reviewWordCount);
		
		for(Map.Entry<String, Integer> entry : sortedReviewWordCount.entrySet()){
			System.out.println(entry.getKey()+"	"+entry.getValue());
		}
			
		
	}
}
