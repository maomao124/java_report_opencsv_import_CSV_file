package mao;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * Project name(项目名称)：java报表_opencsv导入CSV文件
 * Package(包名): mao
 * Class(类名): Test1
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/6/6
 * Time(创建时间)： 14:44
 * Version(版本): 1.0
 * Description(描述)： 无
 */

public class Test1
{
    public static void main(String[] args)
    {
        try (FileInputStream fileInputStream = new FileInputStream("./out.csv");
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))
        {
            CSVReader csvReader = new CSVReader(inputStreamReader);
            //标题
            final String[] title = csvReader.readNext();
            for (String s : title)
            {
                System.out.print(s + "\t\t");
            }
            System.out.println();

            //读取内容
            while (true)
            {
                String[] readNext = csvReader.readNext();
                if (readNext == null)
                {
                    break;
                }
                //读取行数据
                for (String s : readNext)
                {
                    System.out.print(s + "\t\t");
                }
                System.out.println();
            }
            csvReader.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
