package test.practice.springbootquickstart.restController;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.languagetool.AnalyzedSentence;
import org.languagetool.JLanguageTool;
import org.languagetool.language.BritishEnglish;
import org.languagetool.rules.RuleMatch;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RestControllerAPI {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	@RequestMapping("/checking")
	public List<mappingResult> check(@RequestParam String sentence) throws Exception {
		
		JLanguageTool langTool = new JLanguageTool(new BritishEnglish());
		List<mappingResult> mapping = new ArrayList<>();
		// comment in to use statistical ngram data:
		//langTool.activateLanguageModelRules(new File("/data/google-ngram-data"));
		if(!sentence.equals(null) || sentence != null || !sentence.isEmpty()) {
			//"A sentence with a error in the Hitchhiker's Guide tot he Galaxy"
			List<RuleMatch> matches = langTool.check(sentence);
			
			for (RuleMatch match : matches) {
				System.out.println(match.getMessage());
				mappingResult mr = new mappingResult();
				mr.setGetFromPos(match.getFromPos());
				mr.setGetToPos(match.getToPos());
				mr.setGetMessage(match.getMessage());
				mr.setGetSuggestedReplacements(match.getSuggestedReplacements());
				mapping.add(mr);
			}
		}
		
	
		
		System.out.println(mapping.toString());
		
		return mapping;

	}


}
