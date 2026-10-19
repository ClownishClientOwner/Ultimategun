
package dev.example.ultimategun;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class UltimateGunItem extends Item {
    public UltimateGunItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(
        World world, PlayerEntity user, Hand hand
    ) {
        if (!world.isClient) {
            Vec3d look = user.getRotationVec(1.0F);
            Vec3d origin = user.getEyePos();
            Vec3d target = origin.add(look.multiply(12.0));

            for (int i = 0; i < 24; i++) {
                double t = i / 24.0;
                world.spawnParticles(
                    ParticleTypes.END_ROD,
                    origin.x + (target.x - origin.x) * t,
                    origin.y + (target.y - origin.y) * t,
                    origin.z + (target.z - origin.z) * t,
                    2, 0.08, 0.08, 0.08, 0.01
                );
            }

            world.createExplosion(
                user, target.x, target.y, target.z,
                3.0F, World.ExplosionSourceType.TNT
            );

            world.playSound(
                null, user.getBlockPos(),
                SoundEvents.ENTITY_GENERIC_EXPLODE,
                SoundCategory.PLAYERS, 1.0F, 0.75F
            );

            user.getItemCooldownManager().set(this, 30);
        }

        return ActionResult.SUCCESS;
    }
}
