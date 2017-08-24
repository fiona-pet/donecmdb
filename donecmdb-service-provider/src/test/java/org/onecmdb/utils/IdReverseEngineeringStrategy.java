package org.onecmdb.utils;

import com.google.common.collect.ImmutableList;
import org.hibernate.cfg.reveng.DefaultReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.criterion.Property;
import org.hibernate.mapping.IdGenerator;

import java.util.List;
import java.util.Properties;

/**
 * Created by tom on 2017/8/23.
 */
public class IdReverseEngineeringStrategy extends DefaultReverseEngineeringStrategy {
    public String getTableIdentifierStrategyName(TableIdentifier identifier) {
        return "uuid";
    }
    public List<String> getPrimaryKeyColumnNames(TableIdentifier identifier) {
        return ImmutableList.of("id");
    }

}
