package codeChallenge.plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author trinapal
 */

interface Plugin{
    void initialize();
    void execute();
    void shutdown();
}




class PluginStrategy{
    private Plugin plugin; // composition

    PluginStrategy(Plugin plugin){ //constructor arg injection
        this.plugin = plugin;
    }

    public void setPlugin(Plugin plugin){
        this.plugin = plugin;
    }

    public void selectPluginOption(){
        plugin.initialize();
        plugin.execute();
        plugin.shutdown();
    }
}
/*
The ServiceLoader in Java is a built-in mechanism to enable dynamic discovery and
loading of implementations at runtime, following the Service Provider Interface (SPI) pattern.
It's super useful in large, extensible applications, plugin architectures, or frameworks.
 */
class PluginManager{

    List<String> pluginClassNames = List.of(
            "codeChallenge.plugin.SocketPlugin",
            "codeChallenge.plugin.USBPlugin"
    );

    ReflectivePluginManager loader = new ReflectivePluginManager();
    List<Plugin> plugins = loader.allPlugins(pluginClassNames);


    public void loadAllPlugins(){
        ServiceLoader<Plugin> serviceLoader = ServiceLoader.load(Plugin.class);
        for(Plugin plugin: serviceLoader){
            System.out.println("---- Executing plugin: " + plugin.getClass().getSimpleName() + " ----");
            plugin.initialize();
            plugin.execute();
            plugin.shutdown();
            System.out.println();
        }
    }
}

class ReflectivePluginHandler{
    List<String> pluginClassNames = List.of(
            "codeChallenge.plugin.SocketPlugin",
            "codeChallenge.plugin.USBPlugin"
    );

    ReflectivePluginManager loader = new ReflectivePluginManager();
    List<Plugin> plugins = loader.allPlugins(pluginClassNames);


    public void loadAllPlugins(){
        for(Plugin plugin: plugins){
            System.out.println("---- Executing plugin: " + plugin.getClass().getSimpleName() + " ----");
            plugin.initialize();
            plugin.execute();
            plugin.shutdown();
            System.out.println();
        }
    }
}
/*
Use reflection
 */

class ReflectivePluginManager{
    public List<Plugin> allPlugins(List<String> pluginClassNames){
        List<Plugin> plugins = new ArrayList<>();
        for(String  className : pluginClassNames){
            try{
            Class<?> clazz = Class.forName(className);
            Object instance = clazz.getDeclaredConstructor().newInstance();
                if (instance instanceof Plugin plugin) {
                    plugins.add(plugin);
                } else {
                    System.err.println(className + " does not implement Plugin");
                }

            } catch (Exception e) {
                System.err.println("Failed to load plugin: " + className);
                e.printStackTrace();
            }
        }
        return plugins;
    }
}
public class PluginSystemMain {
    public static void main(String[] args) {
        Plugin socketPlugin = new SocketPlugin();
        Plugin usbPlugin = new USBPlugin();
        socketPlugin.initialize();
        socketPlugin.execute();
        socketPlugin.shutdown();

        usbPlugin.initialize();
        usbPlugin.execute();
        usbPlugin.shutdown();

        System.out.println("---------------------------implement strategy pattern-------------------");

        PluginStrategy strategy = new PluginStrategy(new SocketPlugin());
        strategy.selectPluginOption();

        strategy.setPlugin(new USBPlugin());
        strategy.selectPluginOption();

        System.out.println("---------------------------implement service loader-------------------");
        PluginManager manager = new PluginManager();
        manager.loadAllPlugins();

        System.out.println("---------------------------implement Reflection -------------------");
        ReflectivePluginHandler reflectivePluginHandler = new ReflectivePluginHandler();
        reflectivePluginHandler.loadAllPlugins();
    }
}
