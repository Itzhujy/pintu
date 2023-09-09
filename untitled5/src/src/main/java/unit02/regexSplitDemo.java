package src.main.java.unit02;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式示例
 * 要点：定义模式字符串，并且
 * （1）JDK正则包提供了类 Pattern，用于...
 * （2）String的方法replaceAll()本质是调用正则包里的静态方法 Pattern.compile()
 *
 */
public class regexSplitDemo {
    public static void main(String[] args) {
        //正则表达式
        String regex = "[,\\s]+";  //,或空白字符组成的若干字符
        String source = "Red,White, Blue   Green        Yellow, Orange"; //富文本
        Pattern splitter = Pattern.compile(regex);  //
        String[] result = splitter.split(source);  //正则处理后，得到结果文本
        for (String str : result) {  //遍历
            System.out.format("Colour = \"%s\"%n", str);
        }
        System.out.println(checkPhoneNumber("15527643858"));
    }

    @Test
    public void use1() {
        String source = "我的QQ是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com";
        //用法一
        String target = source.replaceAll("\\d+", "");
        System.out.println(target);  //输出：我的QQ是:我的电话是:我的邮箱是:aaa@aaa.com

        //用法二
        //创建模式对象，以正则表达式作为方法参数
        Pattern pattern = Pattern.compile("\\d+");  //若干数字（至少1次）
        String[] strArray = pattern.split(source);  //根据若干数字（至少1个）分割
        //strArray[0]="我的QQ是:"
        //strArray[1]="我的电话是:"
        //strArray[2]="我的邮箱是:aaa@aaa.com"
        for (String str : strArray) {
            System.out.println(str);
        }
    }
    @Test
    public void regrexHtmlText(){
        //使用正则表达式过滤XML文档中的标签（如<、>及空格等）
        String source="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n"
                + "    <string xmlns=\"http://WebXml.com.cn/\">1552764：湖北 武汉 湖北联通GSM卡</string>";
        //从<或</开始到>结束的若干字符替换为空串。其中，使用/?表示/出现0次或1次，使用[^>]+表示非>的若干字符。
        String result = source.replaceAll("</?[^>]+>", "").trim();//正则处理
        System.out.println(result);  //输出：1552764：湖北 武汉 湖北联通GSM卡
    }

    @Test
    public void regrexHtmlText2(){
        String source = "中国|人民/万岁";
        System.out.println(source);  //输出：中国|人民/万岁
        String result = source.replaceAll("[|/]","");
        System.out.println(result);  //输出：中国人民万岁
    }

    @Test
    public void use5(){
        String source = "中山\\浩二/aa";  //斜杠字符\属于转义字符
        System.out.println(source);  //输出：中山\浩二/
        String result = source.replaceAll("[\\\\/]","");  //特殊
        System.out.println(result);  //输出：中山浩二
    }

    @Test
    public void use6(){
        String source = "appy\n" +
                        "app\n" +
                        "happy\n" +
                        "apply\n" +
                        "ability\n" +
                        "quickly";
        //（1）将以a开头、以y结尾的单词替换为空【多行模式】
        Pattern regex = Pattern.compile("^a[a-z]+y$", Pattern.MULTILINE);
        Matcher matcher = regex.matcher(source);
        String result = matcher.replaceAll("");
        System.out.println(result);
        //再去掉换行
        /*String result2 = result.replaceAll("\n", " ");
        System.out.println(result2);*/

        //（3）将以a开头、以y结尾的单词替换为空【单行模式】
        System.out.println("-----------------");
        //使用\\b匹配英文单词的开始或结束
        System.out.println(source.replaceAll("\\ba[a-z]*y\\s?", ""));  //OK
        System.out.println("-----------------");
        System.out.println(source.replaceAll("a[a-z]*y\\s?", ""));  //不正确
        /*System.out.println("-----------------");
        System.out.println(source.replaceAll("^a[a-z]+y\\s|\\sa[a-z]+y[\\sy$]", ""));  //不正确*/
    }

    @Test
    public void use8(){
        String phone="05527643858";
        System.out.println(phone.replaceAll("1\\d{10}", "true"));
        //^与$，分别表示开始位置与结束位置，不影响运行
        System.out.println(phone.replaceAll("^1\\d{10}$", "true"));
    }

    @Test
    public void use9(){
        String phone="15527643858";
        Pattern pattern=Pattern.compile("1\\d{10}");
        //System.out.println(phone.replaceAll("1\\d{10}", "true"));
        if(Pattern.matches("1\\d{10}",phone)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }

    public static boolean checkPhoneNumber(String phoneNumber){
        if(Pattern.matches("1\\d{10}",phoneNumber)){
            return true;
        }else{
            return false;
        }
    }

}
