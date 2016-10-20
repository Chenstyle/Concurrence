package work.test.reconstitution;

import java.util.HashMap;

/**
 * Created by Chenstyle on 2016/10/20 0020.
 */
public class MoreSwitchToMap {
    private static String msg(int code) {
        String msg = "";
        switch (code) {
            case 1001:
                msg = "服务器错误或未知错误";
                break;
            case 1005:
                msg = "上传文件错误";
                break;
            case 1006:
                msg = "上传文件被拒绝";
                break;
            case 2001:
                msg = "卡号错误";
                break;
            case 2002:
                msg = "输入异常";
                break;
            case 2003:
                msg = "数据库错误";
                break;
            case 1015:
                msg = "卡状态异常";
                break;
            default:
                msg = "未知错误";
        }
        return msg;
    }

    // 如果是使用map的形式的话，对map中数据的填充很明显需要单独开一个方法来进行初始化。
}
