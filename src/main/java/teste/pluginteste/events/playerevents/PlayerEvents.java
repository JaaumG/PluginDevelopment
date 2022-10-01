package teste.pluginteste.events.playerevents;

import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerEvents implements Listener {

    public PlayerEvents(){

    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setGameMode(GameMode.CREATIVE);
        event.setJoinMessage("§4§lDONO§r" + player.getDisplayName() +" §aEntrou no servidor");
        player.setOp(true);
        player.setPlayerListHeader("§4§lDONO §6");
        player.setPlayerListFooter("§c" + player.getPing());
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
