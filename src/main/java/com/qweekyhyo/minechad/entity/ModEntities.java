package com.qweekyhyo.minechad.entity;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.entity.serf.SerfEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, MineChad.MODID);

    public static final RegistryObject<EntityType<SerfEntity>> SERF = ENTITIES.register("serf",
            () -> EntityType.Builder.of(SerfEntity::new, EntityClassification.CREATURE)
                    .sized(0.6F, 1.95F)
                    .build(MineChad.MODID + ":serf")
    );


    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}