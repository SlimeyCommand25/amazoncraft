package net.slimey.aquatical.entity.client.models;

import net.minecraft.resources.ResourceLocation;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.custom.SardineEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class SardineModel extends AnimatedGeoModel<SardineEntity> {
    @Override
    public ResourceLocation getModelLocation(SardineEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "geo/sardine.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(SardineEntity object) {
        return new ResourceLocation(Aquatical.MOD_ID, "textures/entity/sardine/sardine.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(SardineEntity animatable) {
        return new ResourceLocation(Aquatical.MOD_ID, "animations/animation.sardine.json");
    }
}