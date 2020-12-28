
//package utils;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.util.CollectionUtils;
//
///**
// * @author zqmDateUtils
// * @date 2019/8/8 9:43
// **/
//public class EmojiUtil {
//
////    private static final Logger LOGGER = LoggerFactory.getLogger(EmojiUtil.class);
//
//    private static final String SIGN_CODE = "*";
//
//    public static int getMaxKey(Map<Integer, Integer> map) {
//        if (CollectionUtils.isEmpty(map)) {
//            return 0;
//        }
//        Set<Integer> set = map.keySet();
//        Object[] obj = set.toArray();
//        Arrays.sort(obj);
//        return (int) obj[obj.length - 1];
//    }
//
//    public static int getMinKey(Map<Integer, Integer> map) {
//        if (map == null) {
//            return 0;
//        }
//        Set<Integer> set = map.keySet();
//        Object[] obj = set.toArray();
//        Arrays.sort(obj);
//        return (int) obj[0];
//    }
//
////    public static void main(String[] args) {
////        String str = "悠悠";
////        System.out.println(buildNickName(str));
////
////    }
//
//    /**
//     * emoji表情脱敏
//     *
//     * @param str
//     * @return
//     */
//    public static String buildNickName(String str) {
//        if (StringUtils.isBlank(str)) {
//            return null;
//        }
//
//        String result;
//        int length = str.length();
//        int index;
//        int lastIndex;
//        int codePointCount = str.codePointCount(0, length);
//        if (codePointCount == 1) {
//            return str;
//        }
//        if (codePointCount >= 5) {
//            index = 3;
//            lastIndex = 1;
//        } else if (codePointCount == 4) {
//            index = 2;
//            lastIndex = 1;
//        } else if (codePointCount == 3) {
//            index = 1;
//            lastIndex = 1;
//        } else {
//            index = 1;
//            lastIndex = 0;
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        int count = 0;
//        for (int i = 1; i <= str.length(); i++) {
//
//            if (str.codePointCount(0, i) == index) {
//                count++;
//                map.put(count, i);
//            }
//        }
//        int lcont = 0;
//        Map<Integer, Integer> lmap = new HashMap<>();
//        for (int i = str.length() - 1; i >= 0; i--) {
//
//            if (str.codePointCount(i, length) == lastIndex) {
//                lcont++;
//                lmap.put(lcont, i);
//            }
//        }
//        if (codePointCount > 5) {
//            result = str.substring(0, map.get(getMaxKey(map))) + SIGN_CODE + SIGN_CODE + str.substring(lmap.get(getMaxKey(lmap)), length);
//        } else if (codePointCount == 2) {
//            result = str.substring(0, map.get(getMaxKey(map))) + SIGN_CODE;
//        } else {
//            result = str.substring(0, map.get(getMaxKey(map))) + SIGN_CODE + str.substring(lmap.get(getMaxKey(lmap)), length);
//        }
//        return result;
//    }
//
//    /**
//     * 普通字符脱敏
//     *
//     * @param name
//     * @return
//     */
//    public static String buildName(String name) {
//        String dealName = null;
//        if (StringUtils.isBlank(name)) {
//            return null;
//        }
//        int length = name.length();
//        if (length > 5) {
//            dealName = name.substring(0, 3) + SIGN_CODE + SIGN_CODE + name.substring(length - 2, length - 1);
//        } else if (length == 5) {
//            dealName = name.substring(0, 3) + SIGN_CODE + name.substring(length - 2, length - 1);
//        } else if (length == 4) {
//            dealName = name.substring(0, 2) + SIGN_CODE + name.substring(length - 2, length - 1);
//        } else if (length == 3) {
//            dealName = name.substring(0, 1) + SIGN_CODE + name.substring(length - 2, length - 1);
//        } else if (length == 2) {
//            dealName = name.substring(0, 1) + SIGN_CODE;
//        } else if (length == 1) {
//            dealName = name;
//        }
//        return dealName;
//    }
//}
