package chain;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
public class ChainLoader1Command implements Command {

	public boolean execute(Context arg0) throws Exception {
		System.out.println("================ChainLoader1Command================");
		return false;
	}
}
