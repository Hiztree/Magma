package org.bukkit.craftbukkit.v1_12_R1.entity;

import net.minecraft.entity.monster.EntityIllusionIllager;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Illusioner;
import org.bukkit.entity.LivingEntity;

public class CraftIllusioner extends CraftSpellcaster implements Illusioner {

    public CraftIllusioner(CraftServer server, EntityIllusionIllager entity) {
        super(server, entity);
    }

    @Override
    public EntityIllusionIllager getHandle() {
        return (EntityIllusionIllager) super.getHandle();
    }

    @Override
    public String toString() {
        return "CraftIllusioner";
    }

    @Override
    public EntityType getType() {
        return EntityType.ILLUSIONER;
    }

    // TODO: 12/07/2020 Magma Comeback
    @Override
    public void rangedAttack(LivingEntity target, float charge) {

    }

    @Override
    public void setChargingAttack(boolean raiseHands) {

    }
}
