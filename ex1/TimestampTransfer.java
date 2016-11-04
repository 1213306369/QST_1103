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
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){//main函数,程序入口
		Scanner scanner = new Scanner(System.in);//键盘输入
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式化,输入日期格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//要求输出的日期格式
		while (scanner.hasNext()){//判断scanner当前是否有下个节点
			String line = scanner.nextLine();//得到下一行输入数据
			Date lineDate = null;//定义一个Date类型的变量
			long lineTimestamp;//定义长整型变量
			try {//抛出异常
				lineDate = inputFormat.parse(line);//提取格式中的日期
				lineTimestamp = lineDate.getTime();//时间戳，保证每次拿到的时间函数不是浏览器缓存
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//输出格式的日期和时间戳
			} catch (ParseException e) {//捕获异常
				// TODO Auto-generated catch block
				e.printStackTrace();//当执行捕获到异常，就会执行catch中的语句
			}
		}
	}
}