package No1;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 * 2016/11/11 11:11:11 to 1478833871000
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//获取输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//定义输入的时间格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//定义输出的时间格式
		while (scanner.hasNext()){//检测输入
			String line = scanner.nextLine();//定义一个字符串获取输入
			Date lineDate = null;//定义一个Date类型的变量
			long lineTimestamp;//定义一个long类型的变量timestamp
			try {
				lineDate = inputFormat.parse(line);//对输入的时间进行格式转换
				lineTimestamp = lineDate.getTime();//将lineDate转换成long类型并赋给linetimestamp
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//输出结果
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
