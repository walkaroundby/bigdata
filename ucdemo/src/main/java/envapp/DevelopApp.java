package envapp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luowei
 * @date 2018-11-02 14:06
 */
public class DevelopApp {

    public static List<DeployThread> getDeployAppList() {
        List<DeployThread> deployThreadList = new ArrayList<DeployThread>();
        String env = "dev";
//        deployThreadList.add(new DeployThread(env, "dev-webapp"));
        deployThreadList.add(new DeployThread(env, "test-transfer-one2"));
        deployThreadList.add(new DeployThread(env, "test-transfer-three"));
        deployThreadList.add(new DeployThread(env, "test-transfer-one4"));
        deployThreadList.add(new DeployThread(env, "test-transfer-five"));
        deployThreadList.add(new DeployThread(env, "test-transfer-seven"));
        deployThreadList.add(new DeployThread(env, "test-transfer-eight"));
        deployThreadList.add(new DeployThread(env, "test-transfer-nine"));
        deployThreadList.add(new DeployThread(env, "test-transfer-ten"));
        deployThreadList.add(new DeployThread(env, "jenkins1"));
        deployThreadList.add(new DeployThread(env, "jenkins2"));
        deployThreadList.add(new DeployThread(env, "jenkins3"));
        deployThreadList.add(new DeployThread(env, "jenkins4"));
        deployThreadList.add(new DeployThread(env, "jenkins5"));
        deployThreadList.add(new DeployThread(env, "jenkins6"));
        deployThreadList.add(new DeployThread(env, "jenkins7"));
        deployThreadList.add(new DeployThread(env, "jenkins8"));
        deployThreadList.add(new DeployThread(env, "jenkins9"));
        deployThreadList.add(new DeployThread(env, "jenkins10"));
        deployThreadList.add(new DeployThread(env, "jenkins11"));
        deployThreadList.add(new DeployThread(env, "jenkins12"));
        deployThreadList.add(new DeployThread(env, "jenkins13"));
        deployThreadList.add(new DeployThread(env, "jenkins14"));
        deployThreadList.add(new DeployThread(env, "jenkins15"));
        deployThreadList.add(new DeployThread(env, "jenkins16"));
        deployThreadList.add(new DeployThread(env, "jenkins17"));
        deployThreadList.add(new DeployThread(env, "jenkins18"));
        deployThreadList.add(new DeployThread(env, "jenkins19"));
        deployThreadList.add(new DeployThread(env, "jenkins20"));


        return deployThreadList;
    }
}
