
package dev.example.ultimategun;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroups;

public class UltimateGunMod implements ModInitializer {
    @Override
    public void onInitialize() {
        System.out.println("Ultimate Gun mod initialized!");
    }
}
