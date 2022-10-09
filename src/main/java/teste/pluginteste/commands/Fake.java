package teste.pluginteste.commands;

import com.github.javafaker.Faker;
import net.skinsrestorer.api.PlayerWrapper;
import net.skinsrestorer.api.SkinsRestorerAPI;
import net.skinsrestorer.api.exception.SkinRequestException;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Fake implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("fake")){
            if(sender instanceof Player){
                SkinsRestorerAPI skinRestorerAPI = SkinsRestorerAPI.getApi();
                if(args.length == 0 ){
                    if(!((Player) sender).getDisplayName().equals(sender.getName())) {
                        ((Player) sender).setCustomName(sender.getName());
                        ((Player) sender).setPlayerListName(sender.getName());
                        ((Player) sender).setDisplayName(sender.getName());
                        ((Player) sender).setCustomNameVisible(true);
                        try {
                            skinRestorerAPI.setSkin(sender.getName(), sender.getName());
                            skinRestorerAPI.applySkin(new PlayerWrapper(sender));
                        } catch (SkinRequestException e) {
                            throw new RuntimeException(e);
                        }
                        sender.sendMessage("Seu fake foi desabilitado.");
                        return true;
                    }
                    else{
                        Faker faker = new Faker();
                        String fakeNick =faker.name().firstName();
                        ((Player) sender).setDisplayName(fakeNick);
                        ((Player) sender).setCustomName(fakeNick);
                        ((Player) sender).setPlayerListName(fakeNick);
                        ((Player) sender).setCustomNameVisible(true);
                        randomSkin(sender, skinRestorerAPI);
                        sender.sendMessage("Seu nick foi atualizado para: " + fakeNick);
                        return true;
                    }
                }if(args.length==1) {
                    ((Player) sender).setDisplayName(args[0]);
                    ((Player) sender).setCustomName(args[0]);
                    ((Player) sender).setPlayerListName(args[0]);
                    ((Player) sender).setCustomNameVisible(true);
                    try{
                        skinRestorerAPI.setSkin(sender.getName(), args[0]);
                        skinRestorerAPI.applySkin(new PlayerWrapper(sender));
                    }catch (SkinRequestException e){
                        randomSkin(sender, skinRestorerAPI);
                    }
                    sender.sendMessage("Seu nick foi atualizado para: " + args[0]);
                    return true;
                }
            }
        }
        return false;
    }

    private void randomSkin(CommandSender sender, SkinsRestorerAPI skinRestorerAPI){
        try {
            Faker faker = new Faker();
            String fakeNick = faker.name().firstName();
            skinRestorerAPI.setSkin(sender.getName(), fakeNick);
            skinRestorerAPI.applySkin(new PlayerWrapper(sender));
        } catch (SkinRequestException e) {
            randomSkin(sender, skinRestorerAPI);
        }
    }

}
