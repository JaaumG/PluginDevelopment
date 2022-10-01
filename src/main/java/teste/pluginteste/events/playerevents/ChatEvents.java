package teste.pluginteste.events.playerevents;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvents implements Listener {

    public ChatEvents() {
    }

    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event){
        if(event.getMessage().contains("&")){
            event.setMessage(event.getMessage().replace("&", "§"));
        }
    }
}
