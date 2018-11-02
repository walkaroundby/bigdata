import java.util.concurrent.*;

/**
 * @author luowei
 * @date 2018-10-29 10:21
 */
public class DeployApp {

    public static void main(String[] args) {
        String env = "dev";
        // 5bcd2e38e4b0a7545ccf0b40
        final DeployThread d1 = new DeployThread(env, "branch-sdp-webapp");

//        final DeployThread d1 = new DeployThread(env, "dev-webapp");
//        // 5bcef4a5e4b0be0b62bdfb8d
        final DeployThread d2 = new DeployThread(env, "test-transfer-one2");
        // 5bce878ee4b0c5f8120ca456
        final DeployThread d3 = new DeployThread(env, "test-transfer-three");
        // 5bd023e1e4b02b979494fe96
        final DeployThread d4 = new DeployThread(env, "test-transfer-one4");
        // 5bce8864e4b0c5f8120ca4ed
        final DeployThread d5 = new DeployThread(env, "test-transfer-five");
        // 5bce9379e4b0c5f8120ca5a7
        final DeployThread d7 = new DeployThread(env, "test-transfer-seven");
        // 5bceb9c0e4b0c5f8120ca681
        final DeployThread d8 = new DeployThread(env, "test-transfer-eight");
        // 5bcef050e4b0be0b62bdfa6d
        final DeployThread d9 = new DeployThread(env, "test-transfer-nine");
        // 5bcef1f6e4b0be0b62bdfb13
        final DeployThread d10 = new DeployThread(env, "test-transfer-ten");
        // 5bd6af0fe4b0e9324a5b6255
        final DeployThread d11 = new DeployThread(env, "jenkins1");
        // 5bd6b027e4b0e9324a5b63e3
        final DeployThread d12 = new DeployThread(env, "jenkins2");
        // 5bd6af67e4b0e9324a5b62aa
        final DeployThread d13 = new DeployThread(env, "jenkins3");
        // 5bd6af76e4b0e9324a5b62c2
        final DeployThread d14 = new DeployThread(env, "jenkins4");
        // 5bd6b00be4b0e9324a5b63c2
        final DeployThread d15 = new DeployThread(env, "jenkins5");
        // 5bd6b0e2e4b0e9324a5b6469
        final DeployThread d16 = new DeployThread(env, "jenkins6");
        // 5bd6b0eee4b0e9324a5b647c
        final DeployThread d17 = new DeployThread(env, "jenkins7");
        // 5bd6b0fbe4b0e9324a5b649a
        final DeployThread d18 = new DeployThread(env, "jenkins8");
        // 5bd6b112e4b0e9324a5b64c7
        final DeployThread d19 = new DeployThread(env, "jenkins9");
        // 5bd6b11fe4b0e9324a5b64d6
        final DeployThread d20 = new DeployThread(env, "jenkins10");
        // linux label
        final DeployThread d21 = new DeployThread(env, "jenkins11");
        final DeployThread d212 = new DeployThread(env, "jenkins12");
        final DeployThread d213 = new DeployThread(env, "jenkins13");
        final DeployThread d214 = new DeployThread(env, "jenkins14");
        final DeployThread d215 = new DeployThread(env, "jenkins15");
        final DeployThread d216 = new DeployThread(env, "jenkins16");
        final DeployThread d217 = new DeployThread(env, "jenkins17");
        final DeployThread d218 = new DeployThread(env, "jenkins18");
        final DeployThread d219 = new DeployThread(env, "jenkins19");
        final DeployThread d220 = new DeployThread(env, "jenkins20");

        // mac
        final DeployThread d22 = new DeployThread(env, "jenkins-ios");
        final DeployThread d23 = new DeployThread(env, "jenkins-ios1");
        final DeployThread d24 = new DeployThread(env, "jenkins-ios2");
        final DeployThread d25 = new DeployThread(env, "jenkins-ios3");
        final DeployThread d26 = new DeployThread(env, "jenkins-ios4");
        final DeployThread d27 = new DeployThread(env, "jenkins-ios5");
        final DeployThread d28 = new DeployThread(env, "jenkins-ios6");
        final DeployThread d29 = new DeployThread(env, "jenkins-ios7");

        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10,32,
                30, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        pool.scheduleAtFixedRate(new Runnable() {
            public void run() {
//                poolExecutor.submit(d1);
                poolExecutor.submit(d2);
                poolExecutor.submit(d3);
                poolExecutor.submit(d4);
                poolExecutor.submit(d5);
                poolExecutor.submit(d7);
                poolExecutor.submit(d8);
                poolExecutor.submit(d9);
                poolExecutor.submit(d10);
                poolExecutor.submit(d11);
                poolExecutor.submit(d12);
                poolExecutor.submit(d13);
                poolExecutor.submit(d14);
                poolExecutor.submit(d15);
                poolExecutor.submit(d16);
                poolExecutor.submit(d17);
                poolExecutor.submit(d18);
                poolExecutor.submit(d19);
                poolExecutor.submit(d20);
                poolExecutor.submit(d21);
                poolExecutor.submit(d21);
                poolExecutor.submit(d21);
                poolExecutor.submit(d21);
                poolExecutor.submit(d21);

//                poolExecutor.submit(d22);
//                poolExecutor.submit(d23);
//                poolExecutor.submit(d24);
//                poolExecutor.submit(d25);
//                poolExecutor.submit(d26);
//                poolExecutor.submit(d27);
//                poolExecutor.submit(d28);
//                poolExecutor.submit(d29);

                poolExecutor.submit(d212);
                poolExecutor.submit(d213);
                poolExecutor.submit(d214);
                poolExecutor.submit(d215);
                poolExecutor.submit(d216);
                poolExecutor.submit(d217);
                poolExecutor.submit(d218);
                poolExecutor.submit(d219);
                poolExecutor.submit(d220);


            }
        }, 0,30, TimeUnit.SECONDS);
    }

}
