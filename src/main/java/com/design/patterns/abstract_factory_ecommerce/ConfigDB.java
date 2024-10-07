package com.design.patterns.abstract_factory_ecommerce;

import com.design.patterns.abstract_factory_ecommerce.domains.MySQLFactory;
import com.design.patterns.abstract_factory_ecommerce.domains.OracleFactory;
import com.design.patterns.abstract_factory_ecommerce.domains.abstract_factory.AbstractFactory;

public class ConfigDB {
    public static AbstractFactory configureAdapterDB(String dbType) {
        if (dbType.equalsIgnoreCase("MySQL")) {
            return new MySQLFactory();
        } else if (dbType.equalsIgnoreCase("Oracle")) {
            return new OracleFactory();
        }
        return null;
    }
}
