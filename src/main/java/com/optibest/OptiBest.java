package com.optibest;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mbest700
 */
public class OptiBest implements ModInitializer {
    public static final String MOD_ID = "optibest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // Bu kısım oyun açılırken çalışır
        LOGGER.info("OptiBest: mbest700 Edition başarıyla yüklendi! FPS uçuşa hazır.");
    }
}
