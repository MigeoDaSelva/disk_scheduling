package br.unicap.disk_scheduling.application;

import java.util.List;

import br.unicap.disk_scheduling.domain.domain.Row;
import br.unicap.disk_scheduling.domain.domain.Table;
import br.unicap.disk_scheduling.domain.domain.Caption;
import br.unicap.disk_scheduling.domain.domain.TableData;
import br.unicap.disk_scheduling.domain.domain.TableHeader;

public class TableFactoryMethod {

    public TableFactoryMethod() {

    }

    public Table buildeTable(String caption, int size, List<Integer> positions) {
        Table table = new Table();
        Row captionRow = new Row();
        captionRow.addElement(new Caption(caption));
        captionRow.addElement(new Caption(String.format("Positions: %s", positions)));
        table.addRow(captionRow);
        Row indexRow = this.makeRowOfIndex(size);
        table.addRow(indexRow);

        for (int i = 0; i < positions.size(); i++) {
            table.addRow(this.makeRow(i + 1, size, positions.get(i)));
        }
        return table;
    }

    private Row makeRowOfIndex(int length) {
        Row newRow = new Row();
        for (int i = 0; i <= length; i++) {
            TableHeader th = new TableHeader(Integer.toString(i));
            th.setStyle("\"color: black;\"");
            newRow.addElement(th);
        }
        return newRow;
    }

    private Row makeRow(int interation, int length, int position) {
        Row newRow = new Row();
        TableHeader th = new TableHeader(Integer.toString(interation));
        th.setStyle("\"color: black;\"");
        newRow.addElement(th);

        for (int i = 1; i <= length; i++) {
            if (i == position) {
                TableData td = new TableData("#");
                td.setStyle("\"color: black;background-color: green\"");
                newRow.addElement(td);
            } else {
                TableData td = new TableData("*");
                newRow.addElement(td);
            }
        }
        return newRow;
    }
}
