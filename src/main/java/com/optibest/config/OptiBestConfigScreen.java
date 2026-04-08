package com.optibest.config;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class OptiBestConfigScreen extends Screen {
    private final Screen parent;

    public OptiBestConfigScreen(Screen parent) {
        super(Text.literal("OptiBest by mbest700"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Agresif Culling (25 Blok): " + (OptiBestConfig.aggressiveCulling ? "AÇIK" : "KAPALI")), button -> {
            OptiBestConfig.aggressiveCulling = !OptiBestConfig.aggressiveCulling;
            button.setMessage(Text.literal("Agresif Culling (25 Blok): " + (OptiBestConfig.aggressiveCulling ? "AÇIK" : "KAPALI")));
        }).dimensions(this.width / 2 - 100, 60, 200, 20).build());

        this.addDrawableChild(ButtonWidget.builder(Text.literal("Geri Dön"), button -> {
            this.client.setScreen(this.parent);
        }).dimensions(this.width / 2 - 100, this.height - 40, 200, 20).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 20, 0x00FF00);
        super.render(context, mouseX, mouseY, delta);
    }
}

