package com.xiao.deng.ast;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.expr.SQLAggregateExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.repository.SchemaRepository;
import com.alibaba.druid.stat.TableStat;

import java.sql.SQLSyntaxErrorException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author xiao
 * @date 2020/07/23
 */
public class Visitor {
    public static void main(String[] args) throws SQLSyntaxErrorException {
//        String sql = "select  name ,id ,select money from user  from acct where id =10";
        String sql = "SELECT tb.id, tb.date, test.f1, test.f2 FROM tb JOIN test on tb.id = test.f1";
        String dbType = "mysql";
        System.out.println("原始SQL 为 ： "+sql);
        SQLSelectStatement statement = (SQLSelectStatement) parser(sql, dbType);
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        statement.accept(visitor);
        System.out.println(visitor.getTables().toString());
        Collection<TableStat.Column> columns = visitor.getColumns();
        for (TableStat.Column column : columns) {
            System.out.println(column.getName());

        }
        List<TableStat.Condition> conditions = visitor.getConditions();
        Map<TableStat.Name, TableStat> tables = visitor.getTables();
        for (Map.Entry entry : tables.entrySet()) {
            entry.getKey();
            entry.getValue();

        }
        Set<TableStat.Relationship> relationships = visitor.getRelationships();
        List<TableStat.Column> orderByColumns = visitor.getOrderByColumns();
        Set<TableStat.Column> groupByColumns = visitor.getGroupByColumns();
        List<SQLAggregateExpr> aggregateFunctions = visitor.getAggregateFunctions();
        SchemaRepository repository = visitor.getRepository();
    }
    public static SQLStatement parser(String sql, String dbType) throws SQLSyntaxErrorException {
        List<SQLStatement> list = SQLUtils.parseStatements(sql, dbType);
        if (list.size() > 1) {
            throw new SQLSyntaxErrorException("MultiQueries is not supported,use single query instead ");
        }
        return list.get(0);
    }

}
