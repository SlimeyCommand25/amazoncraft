package net.slimey.aquatical.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.client.models.ThreshersharkModel;
import net.slimey.aquatical.entity.custom.ThreshersharkEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ThreshersharkRenderer extends GeoEntityRenderer<ThreshersharkEntity> {
    public ThreshersharkRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ThreshersharkModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(ThreshersharkEntity instance) {
        return new ResourceLocation(Aquatical.MOD_ID, "textures/entity/thresher/thresher.png");
    }

    @Override
    public RenderType getRenderType(ThreshersharkEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.3F, 1.3F, 1.3F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

