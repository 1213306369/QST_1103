package No4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		//Scanner scanner = new Scanner(System.in);
		Locale locale = Locale.US;
		SimpleDateFormat regularFormat = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",locale);
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = outputFormat.parse(args[0]);
		Date endDate = outputFormat.parse(args[1]);
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
					System.out.println(strIp);
				}
			}
		}
	}
}