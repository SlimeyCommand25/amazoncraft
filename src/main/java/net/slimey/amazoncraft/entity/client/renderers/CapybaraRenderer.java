package net.slimey.amazoncraft.entity.client.renderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.client.models.DwarfCaimanModel;
import net.slimey.amazoncraft.entity.custom.DwarfcaimanEntity;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DwarfCaimanRenderer extends GeoEntityRenderer<DwarfcaimanEntity> {
    public DwarfCaimanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DwarfCaimanModel());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(DwarfcaimanEntity instance) {
        return new ResourceLocation(Amazoncraft.MOD_ID, "textures/entity/dwarfcaiman/dwarfcaiman.png");
    }

    @Override
    public RenderType getRenderType(DwarfcaimanEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1.1F, 1.1F, 1.1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

