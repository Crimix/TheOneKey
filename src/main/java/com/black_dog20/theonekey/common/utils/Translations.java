package com.black_dog20.theonekey.common.utils;

import com.black_dog20.bml.utils.translate.ITranslation;
import com.black_dog20.theonekey.TheOneKey;

public enum Translations implements ITranslation {
    KEY_ONE_KEY("key.onekey"),
    KEY_CATEGORY("key.category");

    private final String modId;
    private final String key;

    Translations(String key) {
        this.modId = TheOneKey.MOD_ID;
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getModId() {
        return modId;
    }
}
