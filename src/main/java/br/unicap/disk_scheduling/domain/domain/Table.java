package br.unicap.disk_scheduling.domain.domain;

import java.util.LinkedList;
import java.util.List;

import br.unicap.disk_scheduling.domain.interfaces.Element;

public class Table {
    private final String tag = "table";
    private final List<Row> values;
    private String style;

    public Table() {
        this.values = new LinkedList<Row>();
    }

    public void addRow(Row row) {
        this.values.add(row);
    }

    @Override
    public String toString() {
        String elements = "";
        for (Row el : this.values)
            elements = elements.concat(el.toString());
        return String.format("<%s " + ((this.style != null) ? String.format("style=%s", this.style) : "") + ">%s</%s>",
                this.tag, elements, this.tag);
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public static void main(String[] args) {

        Row row = new Row();
        Element element;

        element = new TableHeader("0");
        element.setStyle("\"color: green;\"");
        row.addElement(element);
        element = new TableData("Lorak");
        row.addElement(element);
        element = new TableData("Lorak");
        row.addElement(element);
        element = new TableData("Lorak");
        row.addElement(element);
        element = new TableData("Lorak");
        row.addElement(element);
        element = new TableData("Lorak");
        row.addElement(element);

        Row row2 = new Row();
        Element element2;

        element2 = new TableHeader("1");
        element2.setStyle("\"color: green;\"");
        row2.addElement(element2);
        element2 = new TableData("@");
        row2.addElement(element2);
        element2 = new TableData("@");
        row2.addElement(element2);
        element2 = new TableData("@");
        row2.addElement(element2);
        element2 = new TableData("@");
        row2.addElement(element2);
        element2 = new TableData("@");
        row2.addElement(element2);

        Table table = new Table();

        Row row3 = new Row();
        Element element3;

        element3 = new Caption("Indexes");
        row3.addElement(element3);

        table.addRow(row3);
        table.addRow(row);
        table.addRow(row2);
        table.setStyle("\"color: red;border: 1px solid black;\"");

        System.out.println(table);
    }
}
