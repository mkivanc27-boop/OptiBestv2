package com.optibest;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mbest700
 */
public class OptiBest implements ClientModInitializer {
    public static final String MOD_ID = "optibest";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        // 1. Modun yüklendiğini loglara yaz
        LOGGER.info("OptiBest: mbest700 Edition başarıyla yüklendi! FPS uçuşa hazır.");

        // 2. Pearl koruması ve hız takibi için TickHandler'ı başlat
        // Not: OptiBestTickHandler sınıfını oluşturduysan bu satırı ekle
        OptiBestTickHandler.register();

        // 3. Mod Menu için gerekli olan Config yükleme işlemleri burada yapılabilir
        // Şu anlık sadece başladığımızı bildirmemiz yeterli
    }
}
