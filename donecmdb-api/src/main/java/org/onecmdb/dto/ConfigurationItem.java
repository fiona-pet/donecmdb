package org.onecmdb.dto;

import lombok.Getter;
import lombok.Setter;
import org.onecmdb.entity.AttributeEntity;
import org.onecmdb.entity.CiEntity;

import java.io.InputStream;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tom on 2017/8/10.
 */
@Setter
@Getter
public class ConfigurationItem implements ICi {
    /**
     * ci 实体
     */
    private CiEntity ciEntity;
    private AttributeEntity attributeEntity;

    public ConfigurationItem(CiEntity ciEntity, AttributeEntity attributeEntity) {
        this.ciEntity = ciEntity;
        this.attributeEntity = attributeEntity;
    }

    @Override
    public String getDisplayNameExpression() {
        return ciEntity.getDisplayName();
    }

    @Override
    public ItemId getId() {
        return new ItemId(ciEntity.getId());
    }

    @Override
    public boolean isBlueprint() {
        return ciEntity.getIsBlueprint();
    }

    @Override
    public String getUniqueName() {
        return NAMESPACE + SPLIT_STR + ciEntity.getId();
    }

    @Override
    public String getAlias() {
        return ciEntity.getAlias();
    }

    @Override
    public String getDisplayName() {
        String name = "";
        if (getDisplayNameExpression() != null) {
            name = evaluate(getDisplayNameExpression());
        }
        return name;
    }

    public String evaluate(final String expr) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile("\\$\\{([^}]*)\\}");
        int start = 0;
        Matcher m = p.matcher(expr);
        while (m.find()) {
            int end = m.start();
            sb.append(expr.substring(start, end));
            String tok = m.group(1);
            sb.append(resolve(tok));
            start = m.end();
        }
        if (start < expr.length()) {
            sb.append(ciEntity.getDisplayName().substring(start));
        }
        return sb.toString().trim();
    }

    private String resolve(String tokens) {
        final int p = tokens.indexOf('.');
        final String tok;
        if (p != -1) {
            tok = tokens.substring(0, p);
            tokens = p + 1 < tokens.length() ? tokens.substring(p + 1) : null;
        } else {
            tok = tokens;
            tokens = null;
        }
//        for (ICi ciAttr : getAttributesWithAlias(tok)) {
//            if (ciAttr instanceof IAttribute) {
//                IAttribute attr = (IAttribute) ciAttr;
//                if (tokens == null) {
//                    IValue v = attr.getValue();
//                    return v != null ? v.getDisplayName() : "";
//                } else {
//                    IValue deref = attr.getValue();
//                    if (deref == null || !(deref instanceof ConfigurationItem)) {
//                        return "";
//                    }
//                    ConfigurationItem ci = (ConfigurationItem) deref;
//                    return ci.resolve(tokens);
//                }
//            }
//        }
        if ("alias".equals(tok)) {
            return(this.getAlias());
        }
        if ("id".equals(tok)) {
            return(this.getId().toString());
        }
        return "";
    }


    @Override
    public String getIcon() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public IValue parseString(String s) {
        return null;
    }

    @Override
    public IValue parseInputStream(InputStream in) {
        return null;
    }

    @Override
    public IValue fromValue(IValue value) {
        return null;
    }

    @Override
    public IValue getNullValue() {
        return null;
    }

    @Override
    public IPath<IType> getOffspringPath() {
        return null;
    }

    @Override
    public Set<IType> getAllOffspringTypes() {
        return null;
    }
}
