package core.SlackBot;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;

import core.SlackBot.daily.jira.AuthenticateJira;
import core.SlackBot.daily.jira.FetchingJiraIssue;
import core.SlackBot.daily.slack.SlackPost;

public class JiraApp {

    public static void main(String... args) {
        String jpl = "";

        String url = "";
        String user = "";
        String pass = "";

        try (JiraRestClient jiraRestClient = AuthenticateJira.authenticateJira(url, user, pass)){
            List<Issue> list = FetchingJiraIssue.searchIssues(jiraRestClient, jpl);
            SlackPost.postMsg(list);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }

}
