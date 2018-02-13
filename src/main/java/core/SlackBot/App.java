package core.SlackBot;

import java.io.IOException;

import org.riversun.xternal.simpleslackapi.SlackAttachment;
import org.riversun.xternal.simpleslackapi.SlackChannel;
import org.riversun.xternal.simpleslackapi.SlackSession;
import org.riversun.xternal.simpleslackapi.impl.SlackSessionFactory;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws IOException {

        // BotのAPI Tokenを設定
        SlackSession session = SlackSessionFactory.createWebSocketSlackSession("");

        session.connect();

        SlackChannel channel = session.findChannelByName("bottest");
        SlackAttachment attach = new SlackAttachment("title", "fall", "text", "pretext");
        attach.setColor("#36a64f");

        for (int i=0; i<=1; i++) {
            session.sendMessage(channel, null, attach);
        }

        session.disconnect();

//        System.out.println("Bot start.");
//
//        String token = "";
//        SlackletService slackService = new SlackletService(token);
//
//        slackService.addSlacklet(new Slacklet() {
//            @Override
//            public void onMessagePosted(SlackletRequest req, SlackletResponse res) {
//                SlackChannel channel = req.getChannel();
//
//                if (channel.getName().equals("bottest")) {
//
//                    String content = req.getContent();
//                    res.reply(">" + content + ". BotTest.");
//                    res.reply(":house:");
//                    res.reply("{\"channel\":\"#bottest\",\"username\":\"webhookbot\",\"attachments\":[{\"fallback\":\"ブログに記事が投稿されました。（http://blog.howtelevision.co.jp/entry/2015/04/09/xxxxxx）\",\"color\":\"#36a64f\",\"pretext\":\"ブログに記事が投稿されました。\",\"author_name\":\"xyz_i\",\"author_link\":\"http://howtelevision.jp/\",\"title\":\"SlackWebAPIでナイスなフォーマットのメッセージを送る\",\"title_link\":\"http://blog.howtelevision.co.jp/entry/2015/04/09/xxxxxx\",\"text\":\"（ブログの冒頭や本文を全部入れても良いかもしれません。）\"}],\"icon_emoji\":\":ghost:\"}");
//                }
//            }
//        });
//        slackService.start();

    }
}
