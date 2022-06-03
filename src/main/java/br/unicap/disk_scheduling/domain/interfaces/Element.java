package br.unicap.disk_scheduling.domain.interfaces;

public abstract class Element {
    private final String value;
    private final String tag;
    private String style;

    public Element(String value, String tag) {
        this.value = value;
        this.tag = tag;
    }

    @Override
    public String toString() {
        return String.format("<%s " + ((this.style != null) ? String.format("style=%s", this.style) : "") + ">%s</%s>",
                this.tag, this.value, this.tag);
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
