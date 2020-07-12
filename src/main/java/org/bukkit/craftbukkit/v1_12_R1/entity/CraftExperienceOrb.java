package org.bukkit.craftbukkit.v1_12_R1.entity;

import net.minecraft.entity.item.EntityXPOrb;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;

import javax.annotation.Nullable;
import java.util.UUID;

public class CraftExperienceOrb extends CraftEntity implements ExperienceOrb {
    public CraftExperienceOrb(CraftServer server, EntityXPOrb entity) {
        super(server, entity);
    }

    public int getExperience() {
        return getHandle().xpValue;
    }

    public void setExperience(int value) {
        getHandle().xpValue = value;
    }

    // TODO: 12/07/2020 Magma Comeback
    @Nullable
    @Override
    public UUID getTriggerEntityId() {
        return null;
    }

    @Nullable
    @Override
    public UUID getSourceEntityId() {
        return null;
    }

    @Override
    public SpawnReason getSpawnReason() {
        return null;
    }

    @Override
    public EntityXPOrb getHandle() {
        return (EntityXPOrb) entity;
    }

    @Override
    public String toString() {
        return "CraftExperienceOrb";
    }

    public EntityType getType() {
        return EntityType.EXPERIENCE_ORB;
    }
}
