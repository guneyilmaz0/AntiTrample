package net.guneyilmaz0.antitrample;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;

public class AntiTrample extends PluginBase {
    public static Config config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();
        getServer().getPluginManager().registerEvents(new AntiTrampleListener(), this);
    }
}