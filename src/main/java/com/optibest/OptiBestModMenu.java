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
                .setTitle(Text.of("OptiBest mbest700 Ayarları"));

            ConfigCategory general = builder.getOrCreateCategory(Text.of("Performans"));
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();

            // SİS AÇ/KAPAT
            general.addEntry(entryBuilder.startBooleanToggle(Text.of("Extreme Culling (Sis)"), OptiBestConfig.extremeCulling)
                .setDefaultValue(false)
                .setSaveConsumer(newValue -> OptiBestConfig.extremeCulling = newValue)
                .build());

            // MESAFE TEXTBAR (Sayı Girişi)
            general.addEntry(entryBuilder.startIntField(Text.of("Görüş Mesafesi (Blok)"), OptiBestConfig.renderDistanceLimit)
                .setDefaultValue(10)
                .setTooltip(Text.of("Sis kaç blok ötede başlasın?"))
                .setSaveConsumer(newValue -> OptiBestConfig.renderDistanceLimit = newValue)
                .build());

            return builder.build();
        };
    }
}
