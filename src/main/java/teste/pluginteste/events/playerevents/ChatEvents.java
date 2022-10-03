package teste.pluginteste.events.playerevents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class ChatEvents implements Listener {
    Plugin PluginTeste;
    public ChatEvents(Plugin plugin) {
        PluginTeste = plugin;
    }

    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event){
        event.setFormat(event.getPlayer().getDisplayName()+"§8: §7"+event.getMessage());
        if(event.getMessage().contains("&")){
            event.setMessage(event.getMessage().replace("&", "§"));
        }
    }
}
