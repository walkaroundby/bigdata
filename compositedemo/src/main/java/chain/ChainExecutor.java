package chain;
import java.net.URL;
import org.apache.commons.chain.Catalog;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.config.ConfigParser;
import org.apache.commons.chain.impl.CatalogFactoryBase;
import org.apache.commons.chain.impl.ContextBase;
import org.apache.commons.configuration.PropertiesConfiguration;
/**
 * @author luowei
 * @date 2018-12-07 16:41
 */
public class ChainExecutor {
    public static void main(String[] args) {
        //获取chain链
        String fname = "chains-config.xml";
        PropertiesConfiguration pc = null;
        URL file = null;
        Catalog catalog = null;
        try {
            pc = new PropertiesConfiguration(fname);
            file = pc.getFile().toURI().toURL();
            new ConfigParser().parse(file);
            catalog = CatalogFactoryBase.getInstance().getCatalog();
            //构建Context对象
            Context ctx = new ContextBase();
            ctx.put("first", "first");
            //执行链
            catalog.getCommand("basic").execute(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
