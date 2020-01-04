package siveroo.authNoFall;

import org.bukkit.plugin.java.JavaPlugin;
import siveroo.authNoFall.events.Freeze;

public class Main extends JavaPlugin {
    @Override
    public void onEnable(){
        this.getServer().getPluginManager().registerEvents(new Freeze(), this);
    }
    @Override
    public void onDisable(){

    }
}
