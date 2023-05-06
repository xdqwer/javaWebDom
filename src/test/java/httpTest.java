import cn.hutool.http.HttpUtil;

public class httpTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("select * from test where 1=1 ");
        System.out.println(str+"");
        System.out.println("==========");
        String str1 = "张";
        str.append("and name like %");
        str.append(str1);
        str.append("%");
        System.out.println(str+"");
    }
}
