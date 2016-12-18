package com.zhaojunlike.theme.utils;

/**
 * Created by zhaojunlike@ on 2016/6/21.
 * Email: 1716771371@qq.com
 * Phone：15760079693
 * Oschina：http://git.oschina.net/zhaojunlike/
 */
public class ApiUtil {
    public static final String API_IP = "";
    public static final int port = 80;//api端口
    //public static final String API_root = "http://10.1.56.86/blog/api.php";//根
    public static final String API_root = "http://121.42.146.105/blog/api.php";//根
    public static final String API_version = "1.0";
    public static final String API_framework = "ThinkPHP3.2.3";
    public static final String API_module = "Service";//api模块
    public static final String API_M_Article = "Article";//控制器
    public static final String API_M_Category = "Category";//分类控制器
    public static final String API_u_getDocuments = API_root + "/" + API_M_Article + "/getDocuments";//获取文档列表
    public static final String API_u_getHotArticle = API_root + "/" + API_M_Article + "/getHotArticle";//最热

    /**
     * params  ;  pid(int),field 字段
     */
    public static final String APi_u_getCategorys = API_root + "/" + API_M_Category + "/getCategory";//获取分类


    /**
     * 生成url
     *
     * @param control
     * @param action
     * @return
     */
    public static String createApiUrl(String control, String action) {

        return "";
    }
}
