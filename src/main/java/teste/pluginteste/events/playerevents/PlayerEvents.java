package teste.pluginteste.events.playerevents;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerEvents implements Listener {

    Plugin PluginTeste;
    public PlayerEvents(Plugin plugin) {
        PluginTeste = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setGameMode(GameMode.CREATIVE);
        event.setJoinMessage("§4§lDONO§r" + player.getDisplayName() +" §aEntrou no servidor");
        player.setOp(true);
        new BukkitRunnable() {
            @Override
            public void run() {
                int ping = player.getPing();
                if(ping<=30) {
                    player.setPlayerListFooter("Ping: §2" + ping + "ms");
                }else if(ping<=50){
                    player.setPlayerListFooter("Ping: §a" + ping + "ms");
                }else if(ping<=70){
                    player.setPlayerListFooter("Ping: §e" + ping + "ms");
                }else if(ping<=150){
                    player.setPlayerListFooter("Ping: §c" + ping + "ms");
                }else{
                    player.setPlayerListFooter("Ping: §4" + ping + "ms");
                }
            }
        }.run();
    }


    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(player.getDisplayName().equals("JaaumG")){
            event.setQuitMessage("§4§lDONO§r" + player.getDisplayName() +" §csaiu no servidor");
            return;
        }
        event.setQuitMessage("§c" + player.getDisplayName() +" Saiu do servidor");
    }

    @EventHandler
    public void onPlayerWalk(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location location = player.getLocation();
        location.setY(location.getBlockY()-1);

        if(location.getBlock().getType().equals(Material.SAND)) {
            location.getBlock().setType(Material.TNT);
        }
    }
}
