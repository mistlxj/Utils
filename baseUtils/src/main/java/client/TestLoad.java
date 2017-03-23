package client;

import loader.TestLoadUtil;

/**
 * Created by lixiaojian on 2017/3/23.
 */
public class TestLoad {
    public static void main(String[] args) {
        String url = "/com/mist/test4";
        boolean res = TestLoadUtil.isLog(url);
        System.out.println(res);
    }
}
