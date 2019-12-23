import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// 処理前の時刻を取得
		long startTime = System.currentTimeMillis();
//		System.out.println(startTime);

		int INTERVAL = 5; // 間隔(分刻み)
		LocalDateTime startLocalDateTime = LocalDateTime.of(2002, 04, 7, 00, 00, 00); // 始まりの時刻
		LocalDateTime endLocalDateTime = LocalDateTime.of(2002, 04, 8, 00, 00, 00); // 終わりの時刻
		int totalMinutes = (int) ChronoUnit.MINUTES.between(startLocalDateTime, endLocalDateTime); // 始まりから終わりまでの時間(分)
		int listLength = totalMinutes / INTERVAL; // 出力結果表の長さを決める
		Log log = null;
		List<Log> logList = new ArrayList<>();
		for (int i = 1; i <= listLength; i++) {
			log = new Log();
			log.setLocalDateTime(startLocalDateTime.plusMinutes(INTERVAL * (i - 1)));
			logList.add(log);
		}
		System.out.println(logList.size());
		try {
			File cdirectory = new File("C:\\Users\\yysk3\\Desktop\\Batch\\アクセスログ.txt");
			BufferedReader br = new BufferedReader(new FileReader(cdirectory));
			String str = br.readLine();
			int logCount = 0;
			int listnumber = 0;
			while (str != null) { // 読み込んだ結果がnullで無かったら実行
				String[] logs = str.split("\\s", -1); // 年月日、時間、html、応答時間で分割
				if (logCount != 0) {
					String[] HourMinuteTime = logs[1].split(":", -1);
					int minute = Integer.parseInt(HourMinuteTime[1]);
					listnumber = (minute + Integer.parseInt(HourMinuteTime[0]) * 60) / INTERVAL; // 呼び出すリストの番号を決める
					log = logList.get(listnumber);

					int responceTime = Integer.parseInt(logs[3]);
					log.setTotalResponceTime(log.getTotalResponceTime() + responceTime);
					if (responceTime <= 500) {
						log.setUnder500ms(log.getUnder500ms() + 1);
					} else if (responceTime <= 2000) {
						log.setUnder2000ms(log.getUnder2000ms() + 1);
					} else {
						log.setOver2001ms(log.getOver2001ms() + 1);
					}
					logList.set(listnumber, log);
				}
				logCount += 1;
				str = br.readLine();
			}
			System.out.println();
			for (Log outputLog : logList) {
				if (outputLog.getLocalDateTime().getMinute() == 0 && outputLog.getLocalDateTime().getHour() == 0) {
					System.out.println();
					System.out.println(outputLog.getLocalDateTime().getYear() + "/" + outputLog.getLocalDateTime().getMonthValue()
							+ "/" + outputLog.getLocalDateTime().getDayOfMonth());
					System.out.println();
					System.out.println("時刻	500ms以下	2000ms以下	2001ms以上	平均応答");
				}
				String hour = String.format("%02d", outputLog.getLocalDateTime().getHour()); // 2桁表示の為に目埋め
				String minute = String.format("%02d", outputLog.getLocalDateTime().getMinute()); // 2桁表示の為に目埋め
				String averageResponceTime = String.format("%4s", outputLog.getAverageResponceTime()); // 4桁で表示できるように目埋め
				System.out.println(hour + ":" + minute + "   " + outputLog.getUnder500ms() + "     " + outputLog.getUnder2000ms()
						+ "      " + outputLog.getOver2001ms() + "      " + averageResponceTime);
			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

//			 処理後の時刻を取得
		long endTime = System.currentTimeMillis();
//		System.out.println("処理時間：" + (endTime - startTime) + " ms");
	}

}
