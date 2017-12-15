/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.text.ParseException;  
import java.text.SimpleDateFormat; 
/**
 *
 * @author Annabella
 */
public class Coun {
   private JFrame frame;  
    private JLabel jl0;  
  
   // public static void main(String[] args) throws ParseException {  
  
//new Coun().getTime("2017-12-12 21:45:00");  
  
    //}  
  
    /* String -> Date */  
    private Date String2Date(String dateStr) {  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        try {  
            Date date = simpleDateFormat.parse(dateStr);  
            return date;  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    /* 倒计时的主要代码块 */  
    public void getTime(String dateStr) {  
  
        Date end = String2Date(dateStr);  
  
        long time = (end.getTime() - 1 - new Date().getTime()) / 1000; // 自定义倒计时时间  
        long hour = 0;  
        long minute = 0;  
        long seconds = 0;  
  
        while (time >= 0) {  
            hour = time / 3600;  
            minute = (time - hour * 3600) / 60;  
            seconds = time - hour * 3600 - minute * 60;  
            StringBuilder stringBuilder = new StringBuilder();  
            stringBuilder.append("<html><br>the time to reach").append(dateStr).append(" is<br><br>")  
                    .append(hour).append("hour ").append(minute).append("mins ").append(seconds).append("second ")  
                    .append("</html>");  
            jl0.setText(stringBuilder.toString());  
  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
            time--;  
        }  
  
    }  
  
    /* 构造 实现界面的开发 GUI */  
    public Coun() {  
        frame = new JFrame("倒计时");  
        jl0 = new JLabel();  
  
        init();  
  
    }  
  
    /* 组件的装配 */  
    private void init() {  
        JPanel jp = new JPanel();  
        jp.add(jl0);  
  
        frame.add(jp);  
  
        frame.setVisible(true);  
        frame.setLocation(300, 400);  
        frame.setSize(330, 200);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
  
    
    
}
