package maxe.projektwoche.Events;

import kitpvp1.maxe.Main;
import kitpvp1.maxe.game.Game;
import kitpvp1.maxe.queue.Queue;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class ClickListener implements Listener {

    Game game = new Game();
    Queue queue = new Queue(game);

    @EventHandler
    public void clickListener(InventoryClickEvent event){

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Spielen")){

            Player player = (Player) event.getWhoClicked();

            if(Main.getConfig().getString(player.getDisplayName()) == null){
                switch(event.getCurrentItem().getType()){
                    case FISHING_ROD:
                        player.closeInventory();

                        //Create Inventory
                        ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
                        ItemMeta stone_sword_meta = stone_sword.getItemMeta();
                        stone_sword_meta.setUnbreakable(true);
                        stone_sword.setItemMeta(stone_sword_meta);

                        ItemStack rod = new ItemStack(Material.FISHING_ROD);
                        ItemMeta rod_meta = rod.getItemMeta();
                        rod_meta.setUnbreakable(true);
                        rod.setItemMeta(rod_meta);

                        ItemStack bow = new ItemStack(Material.BOW);
                        ItemMeta bow_meta = bow.getItemMeta();
                        bow_meta.setUnbreakable(true);
                        bow.setItemMeta(bow_meta);

                        ItemStack cobweb = new ItemStack(Material.COBWEB);
                        cobweb.setAmount(3);
                        ItemMeta cobweb_meta = cobweb.getItemMeta();
                        cobweb_meta.setUnbreakable(true);
                        cobweb.setItemMeta(cobweb_meta);

                        //armor
                        ItemStack ironHelmet = new ItemStack(Material.IRON_HELMET);
                        ItemMeta ironHelmet_meta = ironHelmet.getItemMeta();
                        ironHelmet_meta.setUnbreakable(true);
                        ironHelmet.setItemMeta(ironHelmet_meta);

                        ItemStack ironChest = new ItemStack(Material.IRON_CHESTPLATE);
                        ItemMeta ironChest_meta = ironChest.getItemMeta();
                        ironChest_meta.setUnbreakable(true);
                        ironChest.setItemMeta(ironChest_meta);

                        ItemStack ironLeg = new ItemStack(Material.IRON_LEGGINGS);
                        ItemMeta ironLeg_meta = ironLeg.getItemMeta();
                        ironLeg_meta.setUnbreakable(true);
                        ironLeg.setItemMeta(ironLeg_meta);

                        ItemStack ironBoot = new ItemStack(Material.IRON_BOOTS);
                        ItemMeta ironBoot_meta = ironBoot.getItemMeta();
                        ironBoot_meta.setUnbreakable(true);
                        ironBoot.setItemMeta(ironBoot_meta);

                        ItemStack water_bucket = new ItemStack(Material.WATER_BUCKET);

                        ItemStack lava_bucket = new ItemStack(Material.LAVA_BUCKET);

                        ItemStack f_s = new ItemStack(Material.FLINT_AND_STEEL);
                        ItemMeta f_s_meta = f_s.getItemMeta();
                        f_s.setDurability((short) (f_s.getType().getMaxDurability() - 32));
                        f_s.setItemMeta(f_s_meta);

                        ItemStack meat = new ItemStack(Material.COOKED_BEEF);
                        meat.setAmount(5);

                        ItemStack arrow = new ItemStack(Material.ARROW);
                        arrow.setAmount(5);

                        HashMap<Integer, ItemStack> invSG = new HashMap<Integer, ItemStack>();

                        invSG.put(0, stone_sword);
                        invSG.put(1, rod);
                        invSG.put(2, bow);
                        invSG.put(3, null);
                        invSG.put(4, lava_bucket);
                        invSG.put(5, water_bucket);
                        invSG.put(6, f_s);
                        invSG.put(7, cobweb);
                        invSG.put(8, meat);
                        invSG.put(27, arrow);
                        //32-35 armor
                        invSG.put(32, ironHelmet);
                        invSG.put(33, ironChest);
                        invSG.put(34, ironLeg);
                        invSG.put(35, ironBoot);

                        queue.joinQueue(player, "SG", invSG);
                        break;
                    case STICK:
                        player.closeInventory();

                        //Create Inventory
                        ItemStack stick = new ItemStack(Material.STICK);
                        ItemMeta stick_meta = stick.getItemMeta();
                        stick_meta.setUnbreakable(true);
                        stick.setItemMeta(stick_meta);


                        HashMap<Integer, ItemStack> invSt = new HashMap<Integer, ItemStack>();

                        invSt.put(0, stick);

                        queue.joinQueue(player, "ST", invSt);
                        break;
                    default:
                        break;
                }
            }else{
                player.sendMessage(ChatColor.DARK_RED + "DU BIST SCHON IN EINER QUEUE!");
            }

            event.setCancelled(true);

        }

    }

}
