package codeChallenge.plugin;

public class SocketPlugin implements Plugin {
    public SocketPlugin(){

    }
    @Override
    public void initialize() {
        System.out.println("initialize socket plugin");
    }

    @Override
    public void execute() {
        System.out.println("executing socket plugin");
    }

    @Override
    public void shutdown() {
        System.out.println("shut down socket plugin");
    }
}
