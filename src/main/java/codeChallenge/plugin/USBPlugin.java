package codeChallenge.plugin;

public class USBPlugin implements Plugin {
    public USBPlugin(){

    }
    @Override
    public void initialize() {
        System.out.println("initialize USB plugin");
    }

    @Override
    public void execute() {
        System.out.println("Executing USB plugin");
    }

    @Override
    public void shutdown() {
        System.out.println("shut down USB plugin");
    }
}