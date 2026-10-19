
package dev.example.ultimategun;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class UltimateGunMod implements ModInitializer {
    public static final String MOD_ID = "ultimate_gun";

    public static final Item ULTIMATE_GUN = Registry.register(
        Registries.ITEM,
        Identifier.of(MOD_ID, "ultimate_gun"),
        new UltimateGunItem(
            new Item.Settings().registryKey(
                RegistryKey.of(
                    RegistryKeys.ITEM,
                    Identifier.of(MOD_ID, "ultimate_gun")
                )
            ).maxCount(1)
        )
    );

    @Override
    public void onInitialize() {
        ItemGroupEvents.modifyEntriesEvent(
            ItemGroups.COMBAT
        ).register(entries ->
            entries.add(new ItemStack(ULTIMATE_GUN))
        );
    }
}
