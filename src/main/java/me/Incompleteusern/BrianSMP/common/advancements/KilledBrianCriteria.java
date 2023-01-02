package me.Incompleteusern.BrianSMP.common.advancements;

import com.google.gson.JsonObject;
import me.Incompleteusern.BrianSMP.common.BrianSMPMod;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.AbstractCriterionConditions;
import net.minecraft.predicate.entity.AdvancementEntityPredicateDeserializer;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class KilledBrianCriteria extends AbstractCriterion<KilledBrianCriteria.Condition> {

    public static final Identifier ID = new Identifier(BrianSMPMod.MODID, "killed_brian");

    @Override
    protected Condition conditionsFromJson(JsonObject obj, EntityPredicate.Extended playerPredicate, AdvancementEntityPredicateDeserializer predicateDeserializer) {
        return new Condition();
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    public void trigger(ServerPlayerEntity player) {
        trigger(player, condition -> true);
    }

    public static class Condition extends AbstractCriterionConditions {

        public Condition() {
            super(ID, EntityPredicate.Extended.EMPTY);
        }
    }

}
