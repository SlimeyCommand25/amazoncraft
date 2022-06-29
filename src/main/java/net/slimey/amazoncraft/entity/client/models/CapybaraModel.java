package net.slimey.amazoncraft.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.custom.CapybaraEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class CapybaraModel extends AnimatedGeoModel<CapybaraEntity> {
    @Override
    public ResourceLocation getModelLocation(CapybaraEntity object) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "geo/capybara.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity object) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "textures/entity/capybara/capybara.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(CapybaraEntity animatable) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "animations/animation.capybara.json");
    }
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(CapybaraEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("Head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
