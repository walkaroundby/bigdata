package graphic2d;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import sun.font.FontDesignMetrics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luowei
 * @date 2018-09-28 18:06
 */
public class Utils {
    public static int getWordWidth(Font font, String content) {
        FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
        int width = 0;
        for (int i = 0; i < content.length(); i++) {
            width += metrics.charWidth(content.charAt(i));
        }
        return width;
    }
    /**
     * 为上传的证书添加印章和文字
     * @param certificatePath 证书样式路径
     * @param stampPath 印章路径
     * @param pdfPath 输出pdf证书路径
     * @param certificateWidth 最后生成的证书宽度
     * @param certificateHeight 最后生成的证书高度
     * @param stampWidth 印章在证书上的宽度
     * @param stampHeight 印章在证书上的高度
     * @param stampLeftMargin 印章距离证书左边距
     * @param stampUpMargin  印章距离证书上边距
     * @param transparency 印章透明度
     * @param prefix 证书内容第一行固定的内容
     * @param content 证书正文
     * @param contentLeftMargin 证书正文距离证书左边距
     * @param contentUpMargin 证书正文距离证书上边距
     * @param lineSpace 证书正文行间距（倍数）
     * @param signature 单位落款
     * @param font 证书字体大小
     * @param signatureFont 落款字体大小
     */
    public static void mark(String certificatePath, String stampPath, String pdfPath,
                            int certificateWidth, int certificateHeight,
                            int stampWidth, int stampHeight, int stampLeftMargin, int stampUpMargin, float transparency,
                            String prefix, String content, int contentLeftMargin, int contentUpMargin, double lineSpace, Font font,
                            String signature, Font signatureFont) {
        File certificateImageFile = new File(certificatePath);
        File stampImageFile = new File(stampPath);
        Image certificateImage;
        Image stampImage;
        PDDocument pdDocument;
        PDPage pdPage;
        PDImageXObject pdImageXObject;
        PDPageContentStream contentStream;
        try {
            certificateImage = ImageIO.read(certificateImageFile);
            stampImage = ImageIO.read(stampImageFile);
            // 原图的bufferedImage，创建了一个originImgWidth*originImgWidth的黑色画布
            BufferedImage outputImgBufferedImage = new BufferedImage(certificateWidth, certificateHeight, BufferedImage.TYPE_INT_RGB);
            // 一根画笔
            Graphics2D g = outputImgBufferedImage.createGraphics();
            // 把originImage按照originImgWidth*originImgWidth的尺寸画在（0,0）的起点坐标处
            g.drawImage(certificateImage, 0, 0, certificateWidth, certificateHeight, null);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, transparency));
            // 画出印章
            g.drawImage(stampImage, stampLeftMargin, stampUpMargin, stampWidth, stampHeight, null);

            // 换行画出字体
            FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
            int textHeight = metrics.getHeight();
            // 正文部分能画的宽度 只有以第一行prefix为准的长度
            int times = content.length()/prefix.length()+1;
            List<String> textList = getContentList(content, times);
            g.setFont(font);
            g.setColor(Color.BLACK);
            // 固定前缀
            g.drawString(prefix, contentLeftMargin, contentUpMargin);
            for(String text:textList){
                contentUpMargin = contentUpMargin + (int)Math.round(textHeight*lineSpace);
                g.drawString(text, contentLeftMargin, contentUpMargin);
            }
            g.setFont(signatureFont);

            g.drawString(signature, certificateWidth-contentLeftMargin-getWordWidth(signatureFont, signature), stampUpMargin+stampHeight/2);

            g.dispose();
            //输出pdf
            pdDocument = new PDDocument();
            pdPage = new PDPage(new PDRectangle(outputImgBufferedImage.getWidth(), outputImgBufferedImage.getHeight()));
            pdDocument.addPage(pdPage);
            pdImageXObject = LosslessFactory.createFromImage(pdDocument, outputImgBufferedImage);
            contentStream = new PDPageContentStream(pdDocument, pdPage);
            contentStream.drawImage(pdImageXObject, 0, 0, outputImgBufferedImage.getWidth(), outputImgBufferedImage.getHeight());
            contentStream.close();
            pdDocument.save(pdfPath);
            pdDocument.close();
            //输出图片
//            FileOutputStream outImgStream = new FileOutputStream(targetImagePath);
//            ImageIO.write(outputImgBufferedImage, "jpg", new File(targetImagePath));
//            outImgStream.flush();
//            outImgStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static java.util.List<String> getContentList(String content, int times) {
        // 一行多少字
        int words = content.length()/times+1;
        java.util.List<String> wordsList = new ArrayList<String>(times);
        for(int i=0;i<times;i++){
            if((i+1)*words>content.length()){
                wordsList.add(content.substring(i*words, content.length()));
            }else{
                wordsList.add(content.substring(i*words, (i+1)*words));
            }
        }
        return wordsList;
    }
}
