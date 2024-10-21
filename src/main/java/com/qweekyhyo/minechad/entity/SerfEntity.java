package com.qweekyhyo.minechad.entity;

import com.qweekyhyo.minechad.entity.ai.goal.RunTowardsItemGoal;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class SerfEntity extends AgeableEntity {
    public SerfEntity(EntityType<? extends AgeableEntity> entityType, World worldIn) {
        super(entityType, worldIn);
        this.xpReward = 3;
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.MAX_HEALTH, 20.0D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new RunTowardsItemGoal(this, Items.COOKED_CHICKEN, 1.0D, 15.0D));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(3, new LookRandomlyGoal(this));
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld serverWorld, AgeableEntity ageable) {
        return ModEntities.SERF.get().create(serverWorld);
    }
}