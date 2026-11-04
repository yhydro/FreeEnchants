package local.freeenchants;

import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.registry.RegistryKey;
import io.papermc.paper.registry.TypedKey;
import io.papermc.paper.registry.event.RegistryEvents;
import io.papermc.paper.registry.set.RegistrySet;
import org.bukkit.enchantments.Enchantment;

import java.util.List;

/**
 * Hebt bei JEDEM Enchantment die Liste der unvertraeglichen Enchantments auf.
 * Dadurch funktionieren Infinity + Mending, Schaerfe + Bann usw. ueberall:
 * Amboss, Verzauberungstisch, Buecher und Loot.
 */
public final class FreeEnchantsBootstrap implements PluginBootstrap {

    @Override
    public void bootstrap(final BootstrapContext context) {
        context.getLifecycleManager().registerEventHandler(
            RegistryEvents.ENCHANTMENT.entryAdd().newHandler(event ->
                event.builder().exclusiveWith(
                    RegistrySet.keySet(RegistryKey.ENCHANTMENT, List.<TypedKey<Enchantment>>of())
                )
            )
        );
    }
}
