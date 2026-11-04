package local.freeenchants;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.set.RegistrySet;
import org.bukkit.enchantments.Enchantment;

import java.util.List;

public final class FreeEnchantsBootstrap implements PluginBootstrap {

    /** Hier aendern, falls du ein anderes Maximum willst (erlaubt: 1 bis 255). */
    private static final int MAX_LEVEL = 255;

    @Override
    public void bootstrap(final BootstrapContext context) {
        context.getLifecycleManager().registerEventHandler(
            RegistryEvents.ENCHANTMENT.entryAdd().newHandler(event -> {
                event.builder().exclusiveWith(
                    RegistrySet.keySet(RegistryKey.ENCHANTMENT, List.<TypedKey<Enchantment>>of())
                );
                if ("minecraft".equals(event.key().key().namespace())) {
                    event.builder().maxLevel(MAX_LEVEL);
                }
            })
        );
    }
}
