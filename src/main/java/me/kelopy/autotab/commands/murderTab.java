package me.kelopy.autotab.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class murderTab implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if(command.getName().equalsIgnoreCase("murder")){
            if(args.length == 1){
                List<String> playerNames = new ArrayList<>();
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);

                for (Player player : players) {
                    playerNames.add(player.getName());
                }

                return playerNames;
            }else if (args.length == 2){
                List<String> arguments = new ArrayList<>();
                arguments.add("Daddy");
                arguments.add("Pops");

                return arguments;
            }

        }

        return null;
    }

}
