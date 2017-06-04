package main.java.com;


import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

import edu.stanford.nlp.process.Morphology;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class PosTagger {
	
	MaxentTagger tagger;
	PosTagger(String modelDirectory){
		
		tagger = new MaxentTagger(modelDirectory);
		
	}
	public List<String> getPosTag(String review){
		
		// Initialize the tagger
		String tagged = tagger.tagString(review);
		Morphology m  = new Morphology();
		List<String> str = new ArrayList<String>();
		
		String patternStringOne = "(\\w+)_(JJ[RS]?) (\\w+)_(NNS?) ";
		String patternStringTwo = "(\\w+)_(NNS?) ";
		
		Pattern patternOne = Pattern.compile(patternStringOne, Pattern.CASE_INSENSITIVE);
		Pattern patternTwo = Pattern.compile(patternStringTwo, Pattern.CASE_INSENSITIVE);
		
		Matcher matcherOne = patternOne.matcher(tagged);
		Matcher matcherTwo = patternTwo.matcher(tagged);
		while(matcherOne.find()){
			str.add(m.lemma(matcherOne.group(1), matcherOne.group(2))+"_"+m.lemma(matcherOne.group(3), matcherOne.group(4)));
		}
		while(matcherTwo.find()){
			str.add(m.lemma(matcherTwo.group(1), matcherTwo.group(2)));
		}
		return str;
	}
}
