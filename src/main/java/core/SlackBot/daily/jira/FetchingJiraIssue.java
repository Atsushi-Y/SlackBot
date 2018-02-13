package core.SlackBot.daily.jira;

import java.util.ArrayList;
import java.util.List;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.SearchRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.SearchResult;

public class FetchingJiraIssue {

    public static List<Issue> searchIssues(JiraRestClient jiraRestClient, String jpl) {
        SearchRestClient searchRestClient = jiraRestClient.getSearchClient();

        SearchResult result = searchRestClient.searchJql(jpl).claim();

        List<Issue> res = new ArrayList<Issue>();
        for (Issue i : result.getIssues()) {
            res.add(i);
        }
        return res;
    }
}
