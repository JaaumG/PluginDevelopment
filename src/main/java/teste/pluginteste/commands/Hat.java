package teste.pluginteste.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Hat implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("hat")){
            if(sender instanceof Player){
                Player player = ((Player) sender).getPlayer();
                if(player.getInventory().getItemInMainHand().getAmount()>0) {
                    ItemStack itemInHand = player.getInventory().getItemInMainHand().clone();
                    if(player.getInventory().getHelmet()!=null) {
                        ItemStack itemInHead = player.getInventory().getHelmet();
                        player.getInventory().addItem(itemInHead);
                    }
                    itemInHand.setAmount(1);
                    player.getInventory().setHelmet(itemInHand);
                    player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                    return true;
                }else{
                    player.sendMessage("§6Para usar o comando /hat voce precisa ter um item na sua mão");
                    return true;
                }
            }
        }
        return false;
    }
}
