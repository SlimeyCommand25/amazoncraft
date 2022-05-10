package net.slimey.aquatical.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.custom.ThreshersharkEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ThreshersharkModel extends AnimatedGeoModel<ThreshersharkEntity> {
    @Override
    public ResourceLocation getModelLocation(ThreshersharkEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "geo/Thresher.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ThreshersharkEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "textures/entity/Thresher/Thresher.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ThreshersharkEntity animatable) {
        return new ResourceLocation(Aquatical.MOD_ID, "animations/Thresher.animation.json");
    }
}