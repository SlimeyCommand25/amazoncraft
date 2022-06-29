package net.slimey.amazoncraft.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.client.models.CapybaraModel;
import net.slimey.amazoncraft.entity.client.models.DwarfCaimanModel;
import net.slimey.amazoncraft.entity.custom.CapybaraEntity;
import net.slimey.amazoncraft.entity.custom.DwarfcaimanEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CapybaraRenderer extends GeoEntityRenderer<CapybaraEntity> {
    public CapybaraRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CapybaraModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraEntity instance) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "textures/entity/capybara/capybara.png");
    }

    @Override
    public RenderType getRenderType(CapybaraEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

