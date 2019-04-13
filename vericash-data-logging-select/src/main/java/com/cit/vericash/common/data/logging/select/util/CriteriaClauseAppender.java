package com.cit.vericash.common.data.logging.select.util;


import com.cit.vericash.data.logging.dto.Criteria;

import java.util.List;

public class CriteriaClauseAppender {

    public static String append(List<Criteria> criteriaList, String queryStr, CriteriaClauseType criteriaClauseType) {
        if (criteriaList != null && criteriaList.size() == 0) {
            return queryStr;
        }
        System.out.println("size of vriteria List :" + criteriaList.size());
        StringBuilder appendWhereClause = new StringBuilder();
        if (criteriaClauseType.equals(CriteriaClauseType.WHERE_CRITERIA)) {
            if (!queryStr.contains("where ".toLowerCase())) {
                appendWhereClause.append(" where 1=1 ");
            }
        } else if (criteriaClauseType.equals(CriteriaClauseType.HAVING_CRITERIA)) {
            if (!queryStr.contains("Having ".toLowerCase())) {
                appendWhereClause.append(" Having 1=1 ");
            }
        }

        for (int i = 0; i < criteriaList.size(); i++) {
            Criteria criteria = criteriaList.get(i);
            String operator = getOperator(criteria);
            String columnParameter = criteria.getColumn().replace(".", "_");
            columnParameter = columnParameter.replace("(", "");
            columnParameter = columnParameter.replace(")", "");
            Boolean isDateTimeCriteria = (criteria.getType() == Criteria.Type.Date_Time);
            // check IN operator
            if (criteria.getOperator() == Criteria.Operator.IN) {

                appendWhereClause.append(" and " + criteria.getColumn() + " " + operator + "(:" + columnParameter + ")");
            }
            // check Range Operator
            else if (criteria.getOperator() == Criteria.Operator.RANGE) {
                if (isDateTimeCriteria) {
                    appendDateTimeRangeCriteria(criteria, appendWhereClause, columnParameter, operator);
                } else {
                    appendWhereClause.append(" and " + criteria.getColumn() + " " + operator + ":" + columnParameter + "1 and :" + columnParameter + "2");
                }
            }

            // check if Type is Date
            else if (isDateTimeCriteria) {
                appendDateTimeCriteria(criteria, appendWhereClause, columnParameter, operator);
            } else {

                appendWhereClause.append(" and " + criteria.getColumn() + " " + operator + ":" + columnParameter);
            }
        }
        System.out.println("where clause :" + appendWhereClause.toString());
        queryStr = queryStr.replace("@" + criteriaClauseType.getName(), appendWhereClause.toString());
        return queryStr;
    }

    private static void appendDateTimeCriteria(Criteria criteria, StringBuilder queryBuilder, String
            parameterValue, String operator) {

        queryBuilder.append(" and  DATE_FORMAT (" + criteria.getColumn() + " , '%d-%m-%Y %H:%i:%s' )" + operator + " :" + criteria.getColumn());
    }

    private static void appendDateTimeRangeCriteria(Criteria criteria, StringBuilder queryBuilder, String
            parameterValue, String operator) {

        queryBuilder.append(" and  DATE_FORMAT (" + criteria.getColumn() + " , '%d-%m-%Y %H:%i:%s' )" + operator + ":" + parameterValue + "1 and :" + parameterValue + "2");

    }

    // get the operator
    private static String getOperator(Criteria criteria) {
        String operator = "";
        if (criteria.getOperator() == Criteria.Operator.EQUALS) {
            operator = "= ";
        } else if (criteria.getOperator() == Criteria.Operator.GREATER_THAN) {
            operator = "> ";
        } else if (criteria.getOperator() == Criteria.Operator.LESS_THAN) {
            operator = "< ";
        } else if (criteria.getOperator() == Criteria.Operator.RANGE) {
            operator = "BETWEEN ";
        } else if (criteria.getOperator() == Criteria.Operator.Contains) {
            operator = "LIKE ";
        } else if (criteria.getOperator() == Criteria.Operator.GREATER_THAN_OR_EQUALS) {
            operator = ">=";
        } else if (criteria.getOperator() == Criteria.Operator.LESS_THAN_OR_EQUALS) {
            operator = "<=";
        } else if (criteria.getOperator() == Criteria.Operator.IN) {
            operator = "IN";
        } else if (criteria.getOperator() == Criteria.Operator.NotEquals) {
            operator = "!=";
        }
        return operator;
    }

}
