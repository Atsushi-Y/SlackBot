package core.SlackBot.daily.schedule;

import java.util.Calendar;
import java.util.Timer;

import core.SlackBot.daily.task.StartTask;

public class SetSchedule {

    public static void main(String...args) {

        StartTask startTask = new StartTask();
        Timer timer = new Timer("Timer TEST");

        // 朝の1回目の通知
        Calendar startMorningCal = Calendar.getInstance();
        startMorningCal.set(Calendar.HOUR_OF_DAY, 12);
        startMorningCal.set(Calendar.MINUTE, 14);
        startMorningCal.set(Calendar.SECOND, 00);

        timer.scheduleAtFixedRate(startTask, startMorningCal.getTime(), 86400000);

        // 定時付近に通知
        StartTask startEveningTask = new StartTask();
        Calendar startEveningCal = Calendar.getInstance();
        startEveningCal.set(Calendar.HOUR_OF_DAY, 10);
        startEveningCal.set(Calendar.MINUTE, 52);
        startEveningCal.set(Calendar.SECOND, 0);

        timer.scheduleAtFixedRate(startEveningTask, startEveningCal.getTime(), 86400000);

    }
}
