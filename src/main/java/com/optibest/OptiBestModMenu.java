package com.optibest;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class OptiBestModMenu implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> {
            ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.of("OptiBest mbest700 Settings"));

            ConfigCategory general = builder.getOrCreateCategory(Text.of("Performance"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // ON/OFF Düğmesi
            general.addEntry(entryBuilder.startBooleanToggle(Text.of("Extreme Culling"), OptiBestConfig.extremeCulling)
                .setDefaultValue(false)
                .setSaveConsumer(newValue -> OptiBestConfig.extremeCulling = newValue)
                .build());

            // İŞTE O TEXTBAR (Sayı Girişi)
            general.addEntry(entryBuilder.startIntField(Text.of("Render Limit (Blocks)"), OptiBestConfig.renderDistanceLimit)
                .setDefaultValue(10)
                .setTooltip(Text.of("Kaç blok ötesi gizlensin? (Örn: 5, 10, 20)"))
                .setSaveConsumer(newValue -> OptiBestConfig.renderDistanceLimit = newValue)
                .build());

            return builder.build();
        };
    }
}

