package com.qweekyhyo.minechad.client.renderer.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.qweekyhyo.minechad.entity.SerfEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SerfModel<T extends SerfEntity> extends BipedModel<T> {
    private final ModelRenderer headwear;

    public SerfModel() {
        super(0.0F);
        this.texWidth = 64; // Texture width
        this.texHeight = 64; // Texture height

        this.head = new ModelRenderer(this);
        this.head.setPos(0.0F, 0.0F, 0.0F);
        this.head.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

        this.headwear = new ModelRenderer(this);
        this.headwear.setPos(0.0F, 0.0F, 0.0F);
        this.headwear.texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);

        this.body = new ModelRenderer(this);
        this.body.setPos(0.0F, 0.0F, 0.0F);
        this.body.texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

        this.leftArm = new ModelRenderer(this);
        this.leftArm.setPos(5.0F, 2.0F, 0.0F);
        this.leftArm.texOffs(40, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        this.rightArm = new ModelRenderer(this);
        this.rightArm.setPos(-5.0F, 2.0F, 0.0F);
        this.rightArm.texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

        this.leftLeg = new ModelRenderer(this);
        this.leftLeg.setPos(1.9F, 12.0F, 0.0F);
        this.leftLeg.texOffs(0, 16).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, true);

        this.rightLeg = new ModelRenderer(this);
        this.rightLeg.setPos(-1.9F, 12.0F, 0.0F);
        this.rightLeg.texOffs(0, 16).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        headwear.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        leftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public void setupAnim(T entity, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {
        super.setupAnim(entity, p_225597_2_, p_225597_3_, p_225597_4_, p_225597_5_, p_225597_6_);
        this.headwear.xRot = this.head.xRot;
        this.headwear.yRot = this.head.yRot;
        this.headwear.zRot = this.head.zRot;
    }

}