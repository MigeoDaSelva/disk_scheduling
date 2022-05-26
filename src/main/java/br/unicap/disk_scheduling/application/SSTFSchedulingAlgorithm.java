package br.unicap.disk_scheduling.application;

import java.util.ArrayList;
import java.util.List;

import br.unicap.disk_scheduling.domain.interfaces.ShedulingAlgorithm;
import br.unicap.disk_scheduling.domain.domain.Disk;

public class SSTFSchedulingAlgorithm implements ShedulingAlgorithm {

    public void sort(Disk disk) {
        List<Integer> positionsOrdered = new ArrayList<>();

        int actual = disk.getPositions().get(0);
        positionsOrdered.add(actual);
        int next;
        int size = disk.getPositions().size();

        do {
            next = this.getNext(actual, disk.getPositions());
            positionsOrdered.add(next);
            disk.remove(actual);
            actual = next;
        } while (positionsOrdered.size() < size);


        disk.setPositions(positionsOrdered);
    }

    private int getNext(int actual, List<Integer> positions) {
        int distance = 100000;
        int idx = 0;

        for (int i = 0; i < positions.size(); i++) {
            if (positions.get(i) != actual) {
                int cdistance = Math.abs(positions.get(i) - actual);
                if (cdistance < distance) {
                    idx = i;
                    distance = cdistance;
                }
            }
        }

        return positions.get(idx);
    }

}
