//package utils;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//import java.util.Random;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.commons.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.tuniu.operation.platform.base.json.JsonFormatter;
//
//
///**
// * 字符串工具类
// * Created
// */
//public class StringUtil {
//    private static final Logger LOGGER = LoggerFactory.getLogger(StringUtil.class);
//    private static final int DEFAULT_POW = 10;
//    private static final int MAX_SIZE = 2;
//
//    /**
//     * 字符串用base64解码后转换成指定charset的字符串
//     *
//     * @param source
//     * @return
//     */
//    public static String getFromBase64(String source) {
//        if (isEmpty(source)) {
//            return source;
//        }
//        return new String(Base64.decodeBase64(source.getBytes()));
//    }
//
//    public static String getFromBase64(String source, String charSet) {
//        if (isEmpty(source)) {
//            return source;
//        }
//        try {
//            return new String(Base64.decodeBase64(source.getBytes()), charSet);
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error("get from base64 fail", e);
//            return null;
//        }
//    }
//
//    public static String base64(String source) {
//        return new String(Base64.encodeBase64(source.getBytes()));
//    }
//
//    public static String base64(String source, String charset) {
//        try {
//            return new String(Base64.encodeBase64(source.getBytes(charset)));
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error("base64 fail", e);
//            return null;
//        }
//    }
//
//    /**
//     * 转成json格式字符串后再base64的字符串
//     *
//     * @param object
//     * @return
//     */
//    public static String base64AndJsonPackage(Object object) {
//        try {
//            String json = JsonFormatter.toJsonString(object);
//            return new String(Base64.encodeBase64(json.getBytes()));
//        } catch (IOException e) {
//            LOGGER.error("base64AndJsonPackage fail", e);
//            return null;
//        }
//    }
//
//    public static String base64AndJsonPackage(Object object, String charSet) {
//        try {
//            String json = JsonFormatter.toJsonString(object);
//            return new String(Base64.encodeBase64(json.getBytes(charSet)));
//        } catch (IOException e) {
//            LOGGER.error("base64AndJsonPackage fail", e);
//            return null;
//        }
//    }
//
//    public static String convertObjToJsonString(Object object, boolean transNull) {
//        String result = null;
//        try {
//            result = JsonFormatter.toJsonString(object, transNull);
//        } catch (IOException e) {
//            LOGGER.error("convert object to json string error", e);
//        }
//        return result;
//    }
//
//    /**
//     * 对象转换成json字符串
//     *
//     * @param object
//     * @return
//     */
//    public static String convertObjToJsonString(Object object) {
//        String result = null;
//        try {
//            result = JsonFormatter.toJsonString(object);
//        } catch (IOException e) {
//            LOGGER.error("convert object to json string error", e);
//        }
//        return result;
//    }
//
//    public static <T> T convertJsonStringToObject(String content, Class<T> objectClass) {
//        try {
//            return JsonFormatter.toObject(content, objectClass);
//        } catch (IOException e) {
//            LOGGER.error("convert string to obj fail", e);
//            return null;
//        }
//    }
//
//    /**
//     * String encoded
//     *
//     * @param source
//     * @return
//     */
//    public static String encodedString(String source) {
//        try {
//            return URLEncoder.encode(source, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            LOGGER.error("string encoded failed", e);
//            return null;
//        }
//    }
//
//    /**
//     * 判断字符串是否为空
//     *
//     * @param target
//     * @return
//     */
//    public static boolean isEmpty(String target) {
//        if (null == target || "".equals(target)) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 检查是否是合法手机号
//     *
//     * @param mobile
//     * @return
//     */
//    public static boolean isMobile(String mobile) {
//        if (mobile == null) {
//            return false;
//        }
//        Pattern p = Pattern.compile("^(13|14|15|18|17|16|19)\\d{9}$");
//        Matcher m = p.matcher(mobile);
//        return m.matches();
//    }
//
//    /**
//     * 产生验证码
//     *
//     * @param digit
//     * @return
//     */
//    public static String generateCode(int digit) {
//        Random rand = new Random();
//        Double max = Math.pow(DEFAULT_POW, digit);
//        int value = rand.nextInt(max.intValue()) + 1;
//        return String.format("%0" + digit + "d", value);
//    }
//
//    /**
//     * 获取字符串首字母
//     *
//     * @param source
//     * @return
//     */
//    public static String initialLetter(String source) {
//        if (isEmpty(source)) {
//            return null;
//        }
//        return String.valueOf(source.charAt(0)).toUpperCase();
//    }
//
//    /**
//     * 移除字符串中的emoji表情
//     *
//     * @param source
//     * @return
//     */
//    public static String removeEmoji(String source) {
//        if (source == null) {
//            return null;
//        }
//        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
//        Matcher emojiMatcher = emoji.matcher(source);
//        return emojiMatcher.replaceAll("");
//    }
//
//    /**
//     * 将null转为""，便于字符串为空时序列化为"";
//     *
//     * @param string
//     * @return
//     */
//    public static String ifNullToEmpty(String string) {
//        return string == null ? "" : string;
//    }
//
//    /**
//     * 去掉字符串中的html标签，保留换行符
//     *
//     * @param content html内容
//     * @return String
//     */
//    public static String stripHtml(String content) {
//        if (StringUtil.isEmpty(content)) {
//            return content;
//        }
//        // <p>段落替换为换行
//        String htmlStr = content.replaceAll("</?p>", "\n");
//        // <br><br/>替换为换行
//        htmlStr = htmlStr.replaceAll("<br\\s*/?>", "\n");
//        htmlStr = htmlStr.replaceAll("<\\/?br.*?>", "\n");
//        // 去掉其它的<>之间的东西
//        htmlStr = htmlStr.replaceAll("\\<.*?>", "");
//        // 替换空格
//        htmlStr = htmlStr.replaceAll("&nbsp;", " ");
//        // 多个\n替换为一个
//        htmlStr = htmlStr.replaceAll("\n+", "\n");
//        return htmlStr;
//    }
//
//    /**
//     * 去掉字符串中的html标签
//     */
//    public static String removeHtmlTag(String inputString) {
//        if (StringUtil.isEmpty(inputString)) {
//            return "";
//        }
//        String htmlStr = inputString; // 含html标签的字符串
//        String textStr = "";
//        Pattern pScript;
//        Matcher mScript;
//        Pattern pStyle;
//        Matcher mStyle;
//        Pattern pHtml;
//        Matcher mHtml;
//        //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
//        String regExScript = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
//        //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
//        String regExStyle = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
//        String regExHtml = "<[^>]+>"; // 定义HTML标签的正则表达式
//        pScript = Pattern.compile(regExScript, Pattern.CASE_INSENSITIVE);
//        mScript = pScript.matcher(htmlStr);
//        htmlStr = mScript.replaceAll(""); // 过滤script标签
//        pStyle = Pattern.compile(regExStyle, Pattern.CASE_INSENSITIVE);
//        mStyle = pStyle.matcher(htmlStr);
//        htmlStr = mStyle.replaceAll(""); // 过滤style标签
//        pHtml = Pattern.compile(regExHtml, Pattern.CASE_INSENSITIVE);
//        mHtml = pHtml.matcher(htmlStr);
//        htmlStr = mHtml.replaceAll(""); // 过滤html标签
//        textStr = htmlStr;
//        return textStr;// 返回文本字符串
//    }
//
//    /**
//     * 替换特殊字符，br标签替换成\n 等
//     *
//     * @param content
//     * @return
//     */
//    public static String replaceSpecialTag(String content) {
//        if (StringUtil.isEmpty(content)) {
//            return "";
//        }
//        String htmlStr = content.replaceAll("<\\/?br.*?>", "\n");
//        htmlStr = htmlStr.replaceAll("[\\r\\n]+", "\n");
//        htmlStr = htmlStr.replaceAll("[\\r]+", "\n");
//        htmlStr = htmlStr.replaceAll("[\\n]+", "\n");
//        htmlStr = htmlStr.replaceAll("&nbsp;", " ");
//        htmlStr = htmlStr.replaceAll("&mdash;", "-");
//        htmlStr = htmlStr.replaceAll("&lt;", "<");
//        htmlStr = htmlStr.replaceAll("&gt;", ">");
//        htmlStr = htmlStr.replaceAll("&ldquo;", "“");
//        htmlStr = htmlStr.replaceAll("&amp;", "&");
//        htmlStr = htmlStr.replaceAll("&rdquo;", "”");
//        return htmlStr;
//    }
//}