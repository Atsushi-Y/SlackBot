package core.SlackBot.daily.task;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.TimerTask;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;

import core.SlackBot.daily.jira.AuthenticateJira;
import core.SlackBot.daily.jira.FetchingJiraIssue;
import core.SlackBot.daily.slack.SlackPost;

public class StartTask extends TimerTask {
    @Override
    public void run() {

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
