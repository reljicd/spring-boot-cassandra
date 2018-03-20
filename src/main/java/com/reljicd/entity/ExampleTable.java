package com.reljicd.entity;


import com.reljicd.dto.ExampleTableDTO;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.util.Objects;

@Table("example_table")
public class ExampleTable {

    @PrimaryKey
    private ExampleTablePrimaryKey ExampleTablePrimaryKey;

    public ExampleTable() {
    }

    public ExampleTable(String textField1,
                        String textField2,
                        int intField1,
                        int intField2) {
        this.ExampleTablePrimaryKey = new ExampleTablePrimaryKey(
                textField1,
                textField2,
                intField1,
                intField2);
    }

    public static ExampleTable instanceOf(ExampleTableDTO ExampleTableDTO) {
        return new ExampleTable(
                ExampleTableDTO.getTextField1(),
                ExampleTableDTO.getTextField2(),
                ExampleTableDTO.getIntField1(),
                ExampleTableDTO.getIntField2());
    }

    public ExampleTablePrimaryKey getExampleTablePrimaryKey() {
        return ExampleTablePrimaryKey;
    }

    @Override
    public String toString() {
        return "ExampleTable{" +
                "ExampleTablePrimaryKey=" + ExampleTablePrimaryKey +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExampleTable ExampleTable = (ExampleTable) o;

        return ExampleTablePrimaryKey.equals(ExampleTable.ExampleTablePrimaryKey);
    }

    @Override
    public int hashCode() {
        return ExampleTablePrimaryKey.hashCode();
    }

    @PrimaryKeyClass
    public static class ExampleTablePrimaryKey implements Serializable {

        @PrimaryKeyColumn(name = "text_field_1", type = PrimaryKeyType.PARTITIONED)
        private String textField1;
        @PrimaryKeyColumn(name = "text_field_2", type = PrimaryKeyType.CLUSTERED)
        private String textField2;
        @PrimaryKeyColumn(name = "int_field_1", type = PrimaryKeyType.CLUSTERED)
        private int intField1;
        @PrimaryKeyColumn(name = "int_field_2", type = PrimaryKeyType.CLUSTERED)
        private int intField2;

        public ExampleTablePrimaryKey(String textField1,
                                      String textField2,
                                      int intField1,
                                      int intField2) {
            this.textField1 = textField1;
            this.textField2 = textField2;
            this.intField1 = intField1;
            this.intField2 = intField2;
        }

        public String getTextField1() {
            return textField1;
        }

        public void setTextField1(String textField1) {
            this.textField1 = textField1;
        }

        public String getTextField2() {
            return textField2;
        }

        public void setTextField2(String textField2) {
            this.textField2 = textField2;
        }

        public int getIntField1() {
            return intField1;
        }

        public void setIntField1(int intField1) {
            this.intField1 = intField1;
        }

        public int getIntField2() {
            return intField2;
        }

        public void setIntField2(int intField2) {
            this.intField2 = intField2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ExampleTablePrimaryKey that = (ExampleTablePrimaryKey) o;
            return intField1 == that.intField1 &&
                    intField2 == that.intField2 &&
                    Objects.equals(textField1, that.textField1) &&
                    Objects.equals(textField2, that.textField2);
        }

        @Override
        public int hashCode() {

            return Objects.hash(textField1, textField2, intField1, intField2);
        }

        @Override
        public String toString() {
            return "ExampleTablePrimaryKey{" +
                    "textField1='" + textField1 + '\'' +
                    ", textField2='" + textField2 + '\'' +
                    ", intField1=" + intField1 +
                    ", intField2=" + intField2 +
                    '}';
        }
    }

}
