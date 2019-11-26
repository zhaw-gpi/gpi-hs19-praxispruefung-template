package ch.zhaw.gpi.prozessapplikation;

import java.util.Date;

import javax.inject.Named;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.web.client.RestTemplate;

/**
 * SendTweetDelegate
 */
@Named("sendTweet")
public class SendTweetDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String tweetContent = (String) execution.getVariable("tweetContent");
        String userName = (String) execution.getVariable("anfrageStellenderBenutzer");

        RestTemplate rt = new RestTemplate();

        Tweet tweet = new Tweet();
        tweet.setContent(tweetContent);
        tweet.setUserId(userName);

        Date posted = rt.postForObject("http://localhost:8090/api/tweets", tweet, Date.class);
        
        System.out.println("Erfolgreich getweetet um " + posted.toString());
    }

    
}