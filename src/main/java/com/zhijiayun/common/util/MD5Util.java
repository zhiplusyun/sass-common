package com.zhijiayun.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author zhangyu
 * @description MD5加密工具类
 * @date 2018/7/10 下午2:33
 */
public class MD5Util {

    public static String MD5(final String input) throws NoSuchAlgorithmException {
        final MessageDigest md = MessageDigest.getInstance("MD5");
        final byte[] digest = md.digest(input.getBytes());
        final String result = byte2hex(digest);
        return result;
    }
    private static String byte2hex(final byte[] digest) {
        String des = "";
        String tmp = null;
        for (final byte element : digest) {
            tmp = (Integer.toHexString(element & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }
    private static final String HEX_DIGITS[] = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String md5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(UTF_8)));
            else
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    private static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}
