package teste.pluginteste.events.playerevents;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class PlayerEvents implements Listener {

    Plugin PluginTeste;
    public PlayerEvents(Plugin plugin) {
        PluginTeste = plugin;
    }

    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event){
        Player player = event.getPlayer();
        player.setGameMode(GameMode.CREATIVE);
        event.setJoinMessage( player.getDisplayName() +" §aEntrou no servidor");
        player.setOp(true);

    }


    @EventHandler
    public void onPlayerLeaveEvent(PlayerQuitEvent event){
        Player player = event.getPlayer();
        if(player.getDisplayName().equals("JaaumG")){
            event.setQuitMessage( player.getDisplayName() +" §csaiu no servidor");
            return;
        }
        event.setQuitMessage("§c" + player.getDisplayName() +" Saiu do servidor");
    }

    @EventHandler
    public void TreeBreakEvent(BlockBreakEvent event){
        if(event.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.IRON_AXE)){
            Bukkit.getConsoleSender().sendMessage("A");
            Block block = event.getBlock();
            if (block.getType().equals(Material.OAK_LOG)){
                Bukkit.getConsoleSender().sendMessage("B");
                Location location = block.getLocation();
                location.setY(location.getBlockY()+1);
                while(location.getBlock().getType().equals(block.getType())){
                    Block block1 = location.getBlock();
                    location.setY(location.getBlockY()+1);
                    block1.breakNaturally();
                }
            }
        }
    }
}
