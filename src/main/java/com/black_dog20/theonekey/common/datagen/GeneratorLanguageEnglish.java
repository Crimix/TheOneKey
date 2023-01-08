package com.black_dog20.theonekey.common.datagen;

import com.black_dog20.bml.datagen.BaseLanguageProvider;
import com.black_dog20.theonekey.TheOneKey;
import net.minecraft.data.DataGenerator;

import static com.black_dog20.theonekey.common.utils.Translations.*;

public class GeneratorLanguageEnglish extends BaseLanguageProvider {

    public GeneratorLanguageEnglish(DataGenerator gen) {
        super(gen, TheOneKey.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addPrefixed(KEY_CATEGORY, "The One Key");
        addPrefixed(KEY_ONE_KEY, "Active held item");
        addPrefixed(TOOLTIP_BASIC, "Use %s to %s");
        addPrefixed(TOOLTIP_TWO_KEYS, "Use %s + %s to %s");
    }

    @Override
    public String getName() {
        return "The One Key: Languages: en_us";
    }
}
