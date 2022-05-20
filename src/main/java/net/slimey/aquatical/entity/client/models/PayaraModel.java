package net.slimey.aquatical.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.custom.PayaraEntity;
import net.slimey.aquatical.entity.custom.PayaraEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class PayaraModel extends AnimatedGeoModel<PayaraEntity> {
    @Override
    public ResourceLocation getModelLocation(PayaraEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "geo/payara.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(PayaraEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "textures/entity/payara/payara.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(PayaraEntity animatable) {
        return new ResourceLocation(Aquatical.MOD_ID, "animations/animation.payara.json");
    }
}