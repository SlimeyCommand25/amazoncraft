package net.slimey.amazoncraft.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.custom.CapybaraEntity;
import net.slimey.amazoncraft.entity.custom.DwarfcaimanEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class DwarfCaimanModel extends AnimatedGeoModel<DwarfcaimanEntity> {
    @Override
    public ResourceLocation getModelLocation(DwarfcaimanEntity object) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "geo/dwarfcaiman.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DwarfcaimanEntity object) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "textures/entity/dwarfcaiman/dwarfcaiman.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DwarfcaimanEntity animatable) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "animations/animation.dwarfcaiman.json");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(DwarfcaimanEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}