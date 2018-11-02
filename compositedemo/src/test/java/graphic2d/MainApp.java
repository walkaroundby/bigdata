package graphic2d;

import org.junit.Test;
import java.awt.*;

/**
 * @author luowei
 * @date 2018-09-28 18:06
 */
public class MainApp {
    @Test
    public void addPic(){
        String certificatePath = MainApp.class.getClassLoader().getResource("certificate.jpg").getFile();
        String stampPath = MainApp.class.getClassLoader().getResource("stamp.png").getFile();
        String pdfPath = MainApp.class.getClassLoader().getResource("certificate.jpg").getPath().replace("certificate.jpg","certificate.pdf");
        int certificateWidth = 1024;
        int certificateHeight = 665;
        int stampWidth = 150;
        int stampHeight = 120;
        int stampLeftMargin = 720;
        int stampUpMargin = 480;
        float transparency = 0.8f;
        int contentLeftMargin = 140;
        int contentUpMargin = 320;
        double lineSpace = 1.5;
        Font font = new Font("微软雅黑", Font.BOLD, 28);
        Font signatureFont = new Font("微软雅黑", Font.BOLD, 18);
        String prefix = "        ____同志于2018年12月12日至12月26日参加2018年";
        String content = "教育部教育事业统计业务骨干培训班学习，按照学习计划修完全部课程，经考核成绩合格，批准结业，特发此证。";
        String signature = "成都信息工程培训基地";
        Utils.mark(certificatePath, stampPath, pdfPath, certificateWidth, certificateHeight,
                stampWidth, stampHeight, stampLeftMargin, stampUpMargin, transparency,
                prefix, content, contentLeftMargin, contentUpMargin, lineSpace, font,
                signature, signatureFont);
    }
}
