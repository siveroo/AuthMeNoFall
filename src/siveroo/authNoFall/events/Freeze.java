package siveroo.authNoFall.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import siveroo.underworldlogin.fr.xephi.events.LoginEvent;

public class Freeze implements Listener {

    public Freeze(){

    }
    @EventHandler
    public void onJoin(PlayerJoinEvent pe){
        pe.getPlayer().setAllowFlight(true);
        pe.getPlayer().setGravity(false);
        pe.getPlayer().sendMessage("belom login");
    }
    @EventHandler
    public void onLogin(LoginEvent le){
        le.getPlayer().setGravity(true);
        le.getPlayer().setFlying(false);
        le.getPlayer().setAllowFlight(false);
        le.getPlayer().sendMessage("udah login");
    }

}
