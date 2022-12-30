package com.black_dog20.theonekey.common.datagen;

import com.black_dog20.bml.datagen.BaseLanguageProvider;
import com.black_dog20.theonekey.TheOneKey;
import net.minecraft.data.DataGenerator;

import static com.black_dog20.theonekey.common.utils.Translations.KEY_CATEGORY;
import static com.black_dog20.theonekey.common.utils.Translations.KEY_ONE_KEY;

public class GeneratorLanguageEnglish extends BaseLanguageProvider {

    public GeneratorLanguageEnglish(DataGenerator gen) {
        super(gen, TheOneKey.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addPrefixed(KEY_CATEGORY, "The One Key");
        addPrefixed(KEY_ONE_KEY, "Active held item");
    }

    @Override
    public String getName() {
        return "The One Key: Languages: en_us";
    }
}
