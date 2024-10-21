package com.qweekyhyo.minechad.entity.ai.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.EnumSet;
import java.util.List;

public class RunTowardsItemGoal extends Goal {
    private final CreatureEntity mob;
    private final Item wantedItem;
    private ItemEntity targetItem;
    private final double speedModifier;
    private final double detectionRange;

    public RunTowardsItemGoal(CreatureEntity entity, Item item, double speedModifier, double detectionRange) {
        this.mob = entity;
        this.wantedItem = item;
        this.speedModifier = speedModifier;
        this.detectionRange = detectionRange;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        if (!this.mob.isVehicle()) {
            World world = this.mob.level;

            List<ItemEntity> items = world.getEntitiesOfClass(
                    ItemEntity.class, new AxisAlignedBB(mob.blockPosition()).inflate(this.detectionRange)
            );

            for (ItemEntity item : items) {
                if (item.getItem().getItem() == this.wantedItem) {
                    this.targetItem = item;
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean canContinueToUse() {
        return this.targetItem != null && this.targetItem.isAlive();
    }

    @Override
    public void start() {
        if (this.targetItem != null) {
            this.mob.getNavigation().moveTo(this.targetItem, this.speedModifier);
        }
    }

    @Override
    public void stop() {
        this.targetItem = null;
    }

    @Override
    public void tick() {
        if (this.targetItem != null) {
            this.mob.getNavigation().moveTo(this.targetItem, this.speedModifier);
        }
    }
}