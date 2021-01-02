package tech.harmless.minecraft.multiuserockets.items.rockets;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.OptionalInt;

//TODO Use nbt or something else?
public class RocketEntity extends FireworkRocketEntity {

    public RocketEntity(@NotNull World world) {
        super(EntityType.FIREWORK_ROCKET, world);
    }

    public RocketEntity(@NotNull World world, @NotNull ItemStack stack, @NotNull LivingEntity shooter) {
        super(EntityType.FIREWORK_ROCKET, world);

        dataTracker.set(SHOOTER_ENTITY_ID, OptionalInt.of(shooter.getEntityId()));
        this.shooter = shooter;

        setOwner(shooter);

        life = 0;
        updatePosition(shooter.getX(), shooter.getY(), shooter.getZ());

        int i = 1;
        if(!stack.isEmpty() && stack.hasTag()) {
            dataTracker.set(ITEM, stack.copy());
            i += stack.getOrCreateSubTag("Fireworks").getByte("Flight"); //TODO Different tag?
        }

        setVelocity(this.random.nextGaussian() * 0.001D, 0.05D, this.random.nextGaussian() * 0.001D);
        lifeTime = 10 * i + this.random.nextInt(6) + this.random.nextInt(7); //TODO Change.
    }
}
