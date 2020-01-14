package siveroo.authNoFall.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import fr.xephi.authme.events.LoginEvent;
import fr.xephi.authme.events.RegisterEvent;

public class Freeze implements Listener {

    public Freeze(){

    }
    //MENGKONDISIKAN PLAYER SAAT AKAN LOGIN
    @EventHandler
    public void onJoin(PlayerJoinEvent pe){
        Location loc = new Location(Bukkit.getWorld("world"), 0, -3, 0, 90, 90);
        pe.getPlayer().teleport(loc);
        pe.getPlayer().setAllowFlight(true);
        pe.getPlayer().setFlying(true);
        pe.getPlayer().setGameMode(GameMode.SPECTATOR);
        pe.getPlayer().setGravity(false);
        pe.getPlayer().sendTitle(ChatColor.BOLD +"Wadeeya Network", ChatColor.GRAY + "Silahkan login atau mendaftar terlebih dahulu!", 10, 50, 10);
    }
    //MENGKONDISIKAN PLAYER SETELAH BERHASIL LOGIN
    @EventHandler
    public void onLogin(LoginEvent le) {
        le.getPlayer().setGameMode(GameMode.SURVIVAL);
        le.getPlayer().setGravity(true);
        le.getPlayer().setFlying(false);
        le.getPlayer().setAllowFlight(false);
    }
    //MENGKONDISIKAN PLAYER SETELAH BERHASIL REGISTER
    @EventHandler(priority = EventPriority.HIGHEST) // udah gua utak atik highest atau lowest, ttp ga ngaruh
    public void onRegister(RegisterEvent re){
        re.getPlayer().sendTitle(ChatColor.BOLD +"Wadeeya Network", ChatColor.AQUA + "Ketik " + ChatColor.GREEN + ChatColor.ITALIC + "/help " + ChatColor.RESET + ChatColor.AQUA + "untuk mengetahui daftar perintah!", 10, 40, 10);
        Location spawn = new Location(Bukkit.getWorld("world"), -66, 64, -138, 180 ,0);
        re.getPlayer().teleport(spawn);
        re.getPlayer().setGameMode(GameMode.SURVIVAL);
        re.getPlayer().setGravity(true);
        re.getPlayer().setFlying(false);
        re.getPlayer().setAllowFlight(false);
    }

    // MENCEGAH PAKAI TELEPORT WAKTU MASIH SPECTATOR MODE
    @EventHandler
    public void onTeleport(PlayerTeleportEvent te){
        if(te.getCause().equals(PlayerTeleportEvent.TeleportCause.SPECTATE)){
            te.setCancelled(true);
            te.getPlayer().kickPlayer("You have been kicked for abusing spectator mode.");
        }
    }

}
