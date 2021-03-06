package com.ankoki.elementals.spells.generic.medic;

import com.ankoki.elementals.Elementals;
import com.ankoki.elementals.api.GenericSpell;
import com.ankoki.elementals.managers.ParticlesManager;
import com.ankoki.elementals.managers.Spell;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class CastMedic implements GenericSpell {
    private final Elementals plugin;
    private final Spell spell = new Spell("Medic", 3735, false);
    @Getter
    @Setter
    private int cooldown = 30;

    @Override
    public boolean onCast(Player player) {
        double health = player.getHealth() + 5;
        if (health > 20) health = 20;
        player.setHealth(health);
        new ParticlesManager(player, plugin).scatterParticles(5, Particle.HEART, Particle.VILLAGER_HAPPY);
        return true;
    }

    @Override
    public Spell getSpell() {
        return spell;
    }
}
