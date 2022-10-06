package teste.pluginteste.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Tag implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //open menu with pre define tags.
        if(command.getName().equalsIgnoreCase("tag")){
            if (sender instanceof Player){
                Player player = (Player)sender;
                if(args.length==0) {
                    Inventory tags = Bukkit.createInventory((Player) sender, 9, ChatColor.DARK_PURPLE+"Tags");
                    ItemStack dono = new ItemStack(Material.BOOK);
                    ItemStack admin = new ItemStack(Material.BOOK);
                    ItemStack mod = new ItemStack(Material.BOOK);
                    ItemMeta admin_meta = admin.getItemMeta();
                    admin_meta.setDisplayName("§c§lADMIN");
                    admin.setItemMeta(admin_meta);
                    ItemMeta dono_meta = dono.getItemMeta();
                    dono_meta.setDisplayName("§4§lDONO");
                    dono.setItemMeta(dono_meta);
                    ItemMeta mod_meta = mod.getItemMeta();
                    mod_meta.setDisplayName("§5§lMOD");
                    mod.setItemMeta(mod_meta);
                    tags.setItem(0, dono);
                    tags.setItem(1, admin);
                    tags.setItem(2, mod);
                   player.openInventory(tags);
                    return true;
                }if (args.length==1){
                    player.setDisplayName(args[0]+" "+player.getName());
                    player.setPlayerListName(player.getDisplayName());
                    player.setCustomName(player.getDisplayName());
                    player.setCustomNameVisible(true);
                    return true;
                }
            }
        }
        return false;
    }
}
