package net.guneyilmaz0.antitrample;

import cn.nukkit.Player;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityInteractEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.level.Sound;
import cn.nukkit.utils.Config;

@SuppressWarnings("unused")
public class AntiTrampleListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != PlayerInteractEvent.Action.PHYSICAL) return;
        if (event.getBlock().getId() != BlockID.FARMLAND) return;
        Config config = AntiTrample.config;

        String bypassPermission = config.getString("bypass_permission");
        if (bypassPermission != null && event.getPlayer().hasPermission(bypassPermission)) return;

        String message = config.getString("message");
        if (message != null && !message.isEmpty()) event.getPlayer().sendPopup(message);

        if (config.getBoolean("sound", false)) {
            Player player = event.getPlayer();
            player.getLevel().addSound(player, Sound.NOTE_BASS, 0.5f, 1.0f);
        }

        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onEntityInteract(EntityInteractEvent event) {
        if (!AntiTrample.config.getBoolean("prevent_mobs")) return;
        if (event.getBlock().getId() != BlockID.FARMLAND) return;
        event.setCancelled(true);
    }
}