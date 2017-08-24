package org.onecmdb.repository;

import org.hibernate.cfg.reveng.dialect.ResultSetIterator;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.hibernate.tool.util.TableNameQualifier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by tom on 2017/8/23.
 */
public class MySQL5InnoDBDialectForDoc extends MySQL5InnoDBDialect {
    @Override
    public Iterator<Map<String, Object>> getColumns(final String xcatalog, final String xschema, final String xtable, String xcolumn) {
        try {
            final String catalog = caseForSearch( xcatalog );
            final String schema = caseForSearch( xschema );
            final String table = caseForSearch( xtable );
            final String column = caseForSearch( xcolumn );

            log.debug("getColumns(" + catalog + "." + schema + "." + table + "." + column + ")");
            ResultSet tableRs = getMetaData().getColumns(catalog, schema, table, column);

            return new ResultSetIterator(tableRs, getSQLExceptionConverter()) {

                Map<String, Object> element = new HashMap<String, Object>();
                protected Map<String, Object> convertRow(ResultSet rs) throws SQLException {
                    element.clear();
                    putTablePart(element, rs);
                    element.put("DATA_TYPE", new Integer(rs.getInt("DATA_TYPE")));
                    element.put("TYPE_NAME", rs.getString("TYPE_NAME"));
                    element.put("COLUMN_NAME", rs.getString("COLUMN_NAME"));
                    element.put("NULLABLE", new Integer(rs.getInt("NULLABLE")));
                    element.put("COLUMN_SIZE", new Integer(rs.getInt("COLUMN_SIZE")));
                    element.put("DECIMAL_DIGITS", new Integer(rs.getInt("DECIMAL_DIGITS")));
                    element.put("REMARKS", rs.getString("REMARKS"));
                    return element;
                }
                protected Throwable handleSQLException(SQLException e) {
                    throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + TableNameQualifier.qualify(catalog, schema, table), null);
                }
            };
        } catch (SQLException e) {
            throw getSQLExceptionConverter().convert(e, "Error while reading column meta data for " + TableNameQualifier.qualify(xcatalog, xschema, xtable), null);
        }
    }
}
