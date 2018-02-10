package core.SlackBot;

import java.io.IOException;

import org.riversun.slacklet.Slacklet;
import org.riversun.slacklet.SlackletRequest;
import org.riversun.slacklet.SlackletResponse;
import org.riversun.slacklet.SlackletService;
import org.riversun.xternal.simpleslackapi.SlackChannel;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {

        System.out.println("Bot start.");

        String token = "xoxb-313555174566-3xjJ8SsKteYNHEs5b5v5i68f" ;
        SlackletService slackService = new SlackletService(token);

        slackService.addSlacklet(new Slacklet() {
            @Override
            public void onMessagePosted(SlackletRequest req, SlackletResponse res) {
                SlackChannel channel = req.getChannel();

                if (channel.getName().equals("bottest")) {

                    String content = req.getContent();

                    res.reply(content + ". BotTest.");
                }
            }
        });
        slackService.start();

    }
}
