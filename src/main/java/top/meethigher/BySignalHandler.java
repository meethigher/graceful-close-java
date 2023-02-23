package top.meethigher;

import sun.misc.Signal;
import sun.misc.SignalHandler;

/**
 * 监听信号
 * 收到信号时，决定要进行的操作，如果不打算关闭，则对项目运行不影响。
 *
 * @author chenchuancheng
 * @since 2023/2/23 10:11
 */
public class BySignalHandler implements SignalHandler {

    public static void main(String[] args) throws Exception {
        //注册信号监听
        BySignalHandler handler = new BySignalHandler();
        Signal.handle(new Signal("TERM"), handler);
        Signal.handle(new Signal("INT"), handler);
        //模拟应用运行
        while (true) {
            Thread.sleep(1000);
            System.out.println("running...");
        }
    }


    @Override
    public void handle(Signal signal) {
        /**
         * SIGINT - 中断信号，通常是在用户按下 CTRL + C 时发送给前台进程的信号。
         * SIGTERM - 终止信号，通常是在需要正常终止进程时发送给进程的信号。
         */
        switch (signal.getName()) {
            case "INT":
                System.out.println("接收到命令 INT");
                break;
            case "TERM":
                System.out.println("接收到命令 TERM");
                break;
        }
    }
}
