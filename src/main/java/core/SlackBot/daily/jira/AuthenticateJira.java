package core.SlackBot.daily.jira;

import java.net.URI;
import java.net.URISyntaxException;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.JiraRestClientFactory;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;

public class AuthenticateJira {

    public static JiraRestClient authenticateJira(String url, String user, String pass) throws URISyntaxException {
        JiraRestClientFactory factory = new AsynchronousJiraRestClientFactory();
        URI uri = new URI(url);
        return factory.createWithBasicHttpAuthentication(uri, user, pass);
    }
}
