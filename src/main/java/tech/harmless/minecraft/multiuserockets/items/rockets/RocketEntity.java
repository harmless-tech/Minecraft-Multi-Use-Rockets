package tech.harmless.minecraft.multiuserockets.items.rockets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;

public class RocketEntity extends FireworkRocketEntity {

    public RocketEntity(@NotNull World world) {
        super(EntityType.FIREWORK_ROCKET, world);
    }

    public RocketEntity(@NotNull World world, @NotNull ItemStack stack, @NotNull LivingEntity shooter) {
        super(world, stack, shooter);
        //this(world, shooter, shooter.getX(), shooter.getY(), shooter.getZ(), stack);
        //this.dataTracker.set(SHOOTER_ENTITY_ID, OptionalInt.of(shooter.getEntityId()));
        //this.shooter = shooter;
        super.shooter = null;
    }
}
