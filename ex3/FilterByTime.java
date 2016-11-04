package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		Locale locale = Locale.US;
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",locale);
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = outputFormat.parse("2015-12-31 18:00:00");
		Date endDate = outputFormat.parse("2015-12-31 19:00:00");
		String filePath = "./access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]*) [^ ]*\\] \"[^ ]+ [^ ]+.*";
			Pattern r = Pattern.compile(pattern);
			// 对每行进行处理
			Matcher m = r.matcher(line);
			if(m.find()){
				Date date = regularFormat.parse(m.group(2));
				if(date.before(endDate)&&date.after(beginDate)){
					// 切分获取IP，Time
					String strIp = m.group(1);
					String strTime = outputFormat.format(date);
					// 对在时间区间内的数据进行输出
					System.out.println(strIp + "\t" + strTime);
				}
			}
		}
	}
}