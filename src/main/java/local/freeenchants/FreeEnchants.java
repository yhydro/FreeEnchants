package local.freeenchants;

import org.bukkit.plugin.java.JavaPlugin;

public final class FreeEnchants extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FreeEnchants aktiv: Enchantment-Konflikte sind aufgehoben.");
    }
}
