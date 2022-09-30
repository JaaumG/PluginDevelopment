package teste.pluginteste.events.playerevents;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ChatEvents implements Listener {

    public ChatEvents() {
    }

    @EventHandler
    public void onMessageSend(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();
        message.replace("&", "§");
        event.setMessage(message);
    }
}
