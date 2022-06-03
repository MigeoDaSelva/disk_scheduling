package br.unicap.disk_scheduling.domain.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Disk {

    private List<Integer> positions;

    private int size;

    public Disk(int size) {
        this.positions = new ArrayList<>();
        this.size = size;
    }

    public void addRequest(int position) {
        this.positions.add(position);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Integer position : this.positions) {
            builder.append(this.getLine(position));
            builder.append("\n");
        }

        return builder.toString();
    }

    private String getLine(int position) {
        StringBuilder line = new StringBuilder();

        IntStream.range(0, this.size).forEach(i -> {
            if (i == position) {
                line.append("X|");
            } else {
                line.append(" |");
            }
        });

        return line.toString();
    }

    public void remove(int position) {
        for (int i = 0; i < this.positions.size(); i++) {
            if (position == this.positions.get(i)) {
                this.positions.remove(i);
                break;
            }
        }
    }

    public List<Integer> getPositions() {
        return this.positions;
    }

    public void setPositions(List<Integer> positions) {
        this.positions = positions;
    }

    public boolean contains(int position) {
        return this.positions.contains(position);
    }

    public void definePositions(List<Integer> newPositions) {
        this.positions = newPositions;
    }

    public int getSize() {
        return this.size;
    }
}