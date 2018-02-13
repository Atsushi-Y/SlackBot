package core.SlackBot.daily.slack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.riversun.xternal.simpleslackapi.SlackAttachment;
import org.riversun.xternal.simpleslackapi.SlackChannel;
import org.riversun.xternal.simpleslackapi.SlackSession;
import org.riversun.xternal.simpleslackapi.impl.SlackSessionFactory;

import com.atlassian.jira.rest.client.api.domain.Issue;

public class SlackPost {

    public static void postMsg(List<Issue> issueList) throws IOException {
        // BotのAPI Tokenを設定
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("TOKEN");

        session.connect();

        SlackChannel channel = session.findChannelByName("bottest");

        for (Issue issue : issueList) {
            SlackAttachment attach = new SlackAttachment();
            attach.setTitle(issue.getSummary());
            attach.setTitleLink(issue.getKey());
            attach.setColor("#36a64f");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            StringBuilder sb = new StringBuilder();
            sb.append("起案日時 ").append(sdf.format(new Date(issue.getCreationDate().getMillis())));
            sb.append(" 更新日時 ").append(sdf.format(new Date(issue.getUpdateDate().getMillis())));
            sb.append(" 期限 ").append(sdf.format(new Date(issue.getDueDate().getMillis())));
            sb.append(" 起案者 ").append(issue.getReporter().getDisplayName());
            sb.append(" 対応者 ").append(issue.getAssignee().getDisplayName());
            sb.append(" ステータス ").append(issue.getStatus().getName());
            attach.setText(sb.toString());

            session.sendMessage(channel, null, attach);
        }

        session.disconnect();
    }
}
