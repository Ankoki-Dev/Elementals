package com.ankoki.elementals.events;

import com.ankoki.elementals.managers.Spell;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class EntitySpellCastEvent extends Event implements Cancellable {

    @Getter
    @Setter
    private boolean cancelled;
    @Getter
    private static final HandlerList handlerList = new HandlerList();
    @Getter
    private final Player player;
    @Getter
    private final Entity entity;
    @Getter
    private final Spell spell;
    @Getter
    private final long cooldown;

    public EntitySpellCastEvent(Player player, Entity entity, Spell spell, long cooldown) {
        this.player = player;
        this.entity = entity;
        this.spell = spell;
        this.cooldown = cooldown;
        Bukkit.getPluginManager().callEvent(this);
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }
}