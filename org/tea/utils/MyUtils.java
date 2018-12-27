package org.tea.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.text.SimpleDateFormat;

public class MyUtils {
	
	
	//获取当前时间戳
	public static String getTimeStamp() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		return date;
	}
	
	
	//把文件导出到D:\\out\\out.txt
	public static void outAsk()  {
		FileOutputStream out;
		try {
			String pathname="D:\\out\\out.txt";
			File file=new File(pathname);
			if (!file.exists()) {
				
				file.createNewFile();
			}
			out = new FileOutputStream(file);
			Server server=new Server();
			//通过disEvent方法获取到全部信息，再通过write的方法写入txt文件
	        out.write(server.disEvent().getBytes("utf8"));
	        System.out.println("文件写入成功");
	        
	        out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//从文件中录入学生信息
	public static boolean inStu(String filePath) {
		
		List<String> list = new ArrayList<String>();
        
            String encoding = "gbk";
            File file = new File(filePath);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
            	try{
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
                
                
                Server server=new Server();
                System.out.println(list.get(0)+"-------");
                System.out.println(list.size());
                for (int i = 0; i < list.size(); i++) {
                	String []stus=((String)list.get(i)).split(",");
                	String sid=stus[0];
                	String name=stus[1];
                	String classes=stus[2];
                	String pic_url=stus[3];
                	System.out.println(sid+name+classes+pic_url);
                	//调用把学生信息插入库中
                	server.insertStu(sid, name, classes, pic_url);
                	System.out.println(i);
        		}
                return true;
            	}catch (Exception e){
                    System.out.println("读取文件内容出错");
                    e.printStackTrace();
                    return false;
                }
                
            }
            else
            {
                System.out.println("找不到指定的文件");
                return false;
            }
        }	
	}
	
