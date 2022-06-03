package br.unicap.disk_scheduling.domain.domain;

import br.unicap.disk_scheduling.domain.interfaces.Element;

public class TableHeader extends Element {

    public TableHeader(String value) {
        super(value, "th");
    }
}
