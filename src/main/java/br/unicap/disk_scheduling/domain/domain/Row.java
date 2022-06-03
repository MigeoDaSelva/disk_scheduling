package br.unicap.disk_scheduling.domain.domain;

import java.util.LinkedList;
import java.util.List;

import br.unicap.disk_scheduling.domain.interfaces.Element;

public class Row {
    private final List<Element> values;
    private final String tag = "tr";
    private String style;

    public Row() {
        this.values = new LinkedList<Element>();
    }

    public void addElement(Element element) {
        this.values.add(element);
    }

    @Override
    public String toString() {
        String elements = "";
        for (Element el : this.values)
            elements = elements.concat(el.toString());
        return String.format("<%s " + ((this.style != null) ? String.format("style=%s", this.style) : "") + ">%s</%s>",
                this.tag, elements, this.tag);
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
