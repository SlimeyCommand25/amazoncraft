package net.slimey.aquatical.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.client.models.SardineModel;
import net.slimey.aquatical.entity.custom.SardineEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class SardineRenderer extends GeoEntityRenderer<SardineEntity> {
    public SardineRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SardineModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(SardineEntity instance) {
        return new ResourceLocation(Aquatical.MOD_ID, "textures/entity/sardine/sardine.png");
    }

    @Override
    public RenderType getRenderType(SardineEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.5F, 1.5F, 1.5F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

