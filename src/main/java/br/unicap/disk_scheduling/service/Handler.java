package br.unicap.disk_scheduling.service;

import java.util.Random;
import java.util.stream.Collectors;

import br.unicap.disk_scheduling.application.FCFSSchedulingAlgorithm;
import br.unicap.disk_scheduling.application.SSTFSchedulingAlgorithm;
import br.unicap.disk_scheduling.domain.domain.Disk;

public class Handler {

    public static void main(String[] args) {
        Random random = new Random();
        Disk disk1 = new Disk(20);
        Disk disk2 = new Disk(20);

        int requestsQuantity = 10;

        System.out.println("Adding requests to disk");

        int value;
        for (int i = 0; i < requestsQuantity; i++) {

            value = random.nextInt(disk1.getSize());
            while (disk1.contains(value)) {
                value = random.nextInt(disk1.getSize());
            }

            disk1.addRequest(value);
        }

        disk2.setPositions(disk1.getPositions().stream().map(val -> new Integer(val))
                .collect(Collectors.toList()));

        System.out.println("Disk:");
        System.out.println(disk1.getPositions());
        System.out.println(disk1.toString());

        SSTFSchedulingAlgorithm sstf = new SSTFSchedulingAlgorithm();
        FCFSSchedulingAlgorithm fcfs = new FCFSSchedulingAlgorithm();

        sstf.sort(disk1);

        System.out.println("Disk after SSTF:");
        System.out.println(disk1.getPositions());
        System.out.println(disk1.toString());

        fcfs.sort(disk2);

        System.out.println("Disk after FCFS:");
        System.out.println(disk2.getPositions());
        System.out.println(disk2.toString());
    }

}
