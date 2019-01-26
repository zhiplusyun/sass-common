package com.zhijiayun.common.util;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringUtil {
    static Logger log = LoggerFactory.getLogger(StringUtils.class);

    //去掉大写O和熊写l
	public static final String ALLCHAR = "0123456789abcdefghijkmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
	
	/**
     * 字符串左边补0
     */
	public static String padLeft(String s, int length)
    {
        byte[] bs = new byte[length];
        byte[] ss = s.getBytes();
        Arrays.fill(bs, (byte) (48 & 0xff));
        System.arraycopy(ss, 0, bs,length - ss.length, ss.length);
        return new String(bs);
    }
	
	/**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
          for(int i=1; i<=4-randLength; i++)
              fourRandom = "0" + fourRandom  ;
      }
        return fourRandom;
    }
    
    /** 
     * 返回一个定长的随机字符串(只包含大小写字母、数字) 
     *  
     * @param length 
     *            随机字符串长度 
     * @return 随机字符串 
     */  
    public static String generateString(int length) {  
        StringBuffer sb = new StringBuffer();  
        Random random = new Random();  
        for (int i = 0; i < length; i++) {  
            sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));  
        }  
        return sb.toString();  
    }

    /**
     * 移除字符串数组中空值
     * @return
     */
    public static String[] removeBlackAndNull(String[] arrStr){
        List<String> tmp = new ArrayList<String>();
        for(String str:arrStr){
            if(StringUtils.isNotEmpty(str.trim())){
                tmp.add(str);
            }
        }
        return tmp.toArray(new String[0]);
    }


    /**
     * 字符串转换为表达式，并输出结果
     * （逻辑表达式）
     * <pre>
     *   示例：
     *     字符串：“(a >= 0 && a <= 5)”
     *     参数：a=4
     *     输出结果：true
     * </pre>
     * @param str 表达式字符串
     * @param key 表达式中，参与运算的变量别名
     * @param value 表达式中，参与运算的变量值
     * @return
     */
    public static Object str2Exp(String str, String key, Object value){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        if (!key.trim().isEmpty() && value!=null){
            engine.put(key, value);
        }
        Object result = null;
        try {
            result = engine.eval(str);
        } catch (ScriptException e) {
            log.error("无效表达式e [{}]",e);
        }
        return result;
    }

}
