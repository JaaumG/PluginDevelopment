package teste.pluginteste.events.playerevents;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class MenuEvents implements Listener {

    @EventHandler
    public void onMenu(InventoryClickEvent event){
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equals(ChatColor.DARK_PURPLE+"Tags")){
            event.setCancelled(true);
            if(event.getCurrentItem()!=null) {
                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§4§lDONO" -> {
                        player.setDisplayName("§4§lDONO§r " + player.getName());
                        player.setPlayerListName(player.getDisplayName());
                        player.setCustomName(player.getDisplayName());
                        player.setCustomNameVisible(true);
                        player.closeInventory();
                        player.sendTitle("§6§lTag alterada",event.getCurrentItem().getItemMeta().getDisplayName());
                    }
                    case "§c§lADMIN" -> {
                        player.setDisplayName("§c§lADMIN§r " + player.getName());
                        player.setPlayerListName(player.getDisplayName());
                        player.setCustomName(player.getDisplayName());
                        player.setCustomNameVisible(true);
                        player.closeInventory();
                        player.sendTitle("§6§lTag alterada",event.getCurrentItem().getItemMeta().getDisplayName());
                    }
                    case "§5§lMOD" -> {
                        player.setDisplayName("§5§lMOD§r " + player.getName());
                        player.setPlayerListName(player.getDisplayName());
                        player.setCustomName(player.getDisplayName());
                        player.setCustomNameVisible(true);
                        player.closeInventory();
                        player.sendTitle("§6§lTag alterada",event.getCurrentItem().getItemMeta().getDisplayName());
                    }
                }
            }
        }
    }
}
