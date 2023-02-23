package top.meethigher;

/**
 * 通过关闭回调实现优雅关闭
 * 其实应用已经关闭了，只是在关闭时，回调启动一个线程执行
 *
 * @author chenchuancheng
 * @since 2023/2/23 10:04
 */
public class ByHook {

    public static void main(String[] args) throws Exception {
        //注册关闭后的回调hook
        registerHook();
        //模拟应用运行
        while (true) {
            Thread.sleep(1000);
            System.out.println("running...");
        }
    }

    public static void registerHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("通过Hook关闭: 其实应用已经关闭了，只是在关闭时，回调启动一个线程执行")));
    }


}
