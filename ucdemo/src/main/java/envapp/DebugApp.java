package envapp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luowei
 * @date 2018-11-02 14:17
 */
public class DebugApp {
    public static List<DeployThread> getDeployAppList() {
        List<DeployThread> deployThreadList = new ArrayList<DeployThread>();
        String env = "debug";
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

        deployThreadList.add(new DeployThread(env, "jenkins-ios"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios1"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios2"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios3"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios4"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios5"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios6"));
        deployThreadList.add(new DeployThread(env, "jenkins-ios7"));

//        deployThreadList.add(new DeployThread(env, "branch-sdp-webapp"));
        return deployThreadList;
    }
}
