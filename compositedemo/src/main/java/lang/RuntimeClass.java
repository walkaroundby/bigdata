package lang;


import java.io.File;

/**
 * @author luowei
 * @date 2019-02-03 10:24
 */
public class RuntimeClass {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        try{
            Process proc = r.exec("cmd /c dir > %dest%", new String[]{"dest=c:\\dir.txt"}, new File("d:\\test"));
            // 阻塞当前线程，并等待外部程序中止后获取结果码
            int exitVal = proc.waitFor();
            System.out.println(exitVal == 0 ? "成功" : "失败");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
