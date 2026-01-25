package com.human.common.data.fixer.migration;

import com.blib.api.common.data_fix.v1.BLibDataMigration;
import com.human.Human;
import com.human.common.data.fixer.migration.impl.AVP_0_3_0_To_Human_0_1_0;

import java.util.List;

public class HumanDataMigrations {

    private static final List<BLibDataMigration> MIGRATIONS = List.of(
        new AVP_0_3_0_To_Human_0_1_0()
    );

    public static void initialize() {
        var version = Human.MOD.version();

        if (version != null) {
            MIGRATIONS.forEach(BLibDataMigration::apply);
        }
    }
}
