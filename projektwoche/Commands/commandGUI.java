package maxe.projektwoche.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class commandGUI implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){

            Player spieler = ((Player) sender).getPlayer();

            if(spieler.getWorld().getName().equalsIgnoreCase("world")){

                Inventory gui = Bukkit.createInventory(spieler, 54, ChatColor.GOLD + "Spielen"); // create Inventory

                ItemStack white_glass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
                ItemStack barrier = new ItemStack(Material.BARRIER);
                ItemStack angel = new ItemStack(Material.FISHING_ROD);
                ItemStack stick = new ItemStack(Material.STICK);

                ItemMeta angel_meta = angel.getItemMeta();
                angel_meta.setDisplayName(ChatColor.GREEN + "SurvivalGames");
                angel.setItemMeta(angel_meta);

                ItemMeta stick_meta = angel.getItemMeta();
                stick_meta.setDisplayName(ChatColor.BLUE + "ONLY STICK");
                stick.setItemMeta(stick_meta);

                for(int i = 0; i < gui.getSize(); i++){
                    gui.setItem(i, white_glass);
                }

                gui.setItem(10, angel);
                gui.setItem(12, stick);
                gui.setItem(14, barrier);
                gui.setItem(16, barrier);
                gui.setItem(37, barrier);
                gui.setItem(39, barrier);
                gui.setItem(41, barrier);
                gui.setItem(43, barrier);

                spieler.openInventory(gui);

            }

        }

        return true;
    }

}
