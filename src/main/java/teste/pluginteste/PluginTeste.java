package teste.pluginteste;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import teste.pluginteste.events.playerevents.ChatEvents;
import teste.pluginteste.events.playerevents.PlayerEvents;

public final class PluginTeste extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("Hello World by JAAUMG");
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(this), this);
        Bukkit.getPluginManager().registerEvents(new ChatEvents(this), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if (command.getName().equals("ping")) {
                PotionEffect HitKillStrenght = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 255, false, false);
                Player player = ((Player) sender).getPlayer();
                int ping = player.getPing();
                if(ping<=30) {
                    player.sendMessage("Seu ping: §2" + player.getPing() + "ms");
                }else if(ping<=50){
                    player.sendMessage("Seu ping: §a" + player.getPing() + "ms");
                }else if(ping<=70){
                    player.sendMessage("Seu ping: §e" + player.getPing() + "ms");
                }else if(ping<=150){
                    player.sendMessage("Seu ping: §c" + player.getPing() + "ms");
                }else{
                    player.sendMessage("Seu ping: §4" + player.getPing() + "ms");
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
