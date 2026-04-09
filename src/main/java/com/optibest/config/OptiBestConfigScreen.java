package com.optibest.config;

import com.optibest.OptiBestConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

public class OptiBestConfigScreen extends Screen {
    public OptiBestConfigScreen() {
        super(Text.literal("OptiBest Ayarları"));
    }

    @Override
    protected void init() {
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Agresif Culling: " + (OptiBestConfig.aggressiveCulling ? "AÇIK" : "KAPALI")), button -> {
            OptiBestConfig.aggressiveCulling = !OptiBestConfig.aggressiveCulling;
            button.setMessage(Text.literal("Agresif Culling: " + (OptiBestConfig.aggressiveCulling ? "AÇIK" : "KAPALI")));
        }).dimensions(this.width / 2 - 100, 50, 200, 20).build());
    }
}
