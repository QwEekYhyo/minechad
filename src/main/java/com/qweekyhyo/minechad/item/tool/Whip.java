package com.qweekyhyo.minechad.item.tool;

import net.minecraft.item.ToolItem;

import java.util.HashSet;

import static net.minecraft.item.ItemTier.WOOD;

public class Whip extends ToolItem {
    public Whip(Properties properties) {
        super(40, 5, WOOD, new HashSet<>(), properties);
    }
}
