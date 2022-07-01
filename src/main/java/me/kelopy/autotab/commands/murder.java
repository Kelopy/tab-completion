package me.kelopy.autotab.commands;

import me.kelopy.autotab.AUTOTAB;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class murder implements TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            if(args.length == 0){
                String suicide = AUTOTAB.getInstance().getConfig().getString("suicide-msg");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', suicide));
                p.setHealth(0.0);
            }else if(args.length > 0){
                Player target = Bukkit.getPlayer(args[0]);

                target.setHealth(0);

                String murder = "&7You just murdered &b" + target.getDisplayName() + "&7!";
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', murder));
                String murderOther = "&7You were murdered by &b" + p.getDisplayName() + "&7!";
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', murderOther));
            }
        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(args.length == 1){
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);

            for (Player player : players) {
                playerNames.add(player.getName());
            }

            return playerNames;
        }else if (args.length == 2){
            List<String> rickroll = new ArrayList<>();

            rickroll.add("never");
            rickroll.add("gonna");
            rickroll.add("give");
            rickroll.add("you");
            rickroll.add("up");

            return rickroll;
        }

        return null;
    }

}
