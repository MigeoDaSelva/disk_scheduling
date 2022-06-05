package br.unicap.disk_scheduling.service;

import java.util.stream.Collectors;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.awt.Desktop;
import java.util.Random;
import java.io.File;

import br.unicap.disk_scheduling.application.FCFSSchedulingAlgorithm;
import br.unicap.disk_scheduling.application.SSTFSchedulingAlgorithm;
import br.unicap.disk_scheduling.domain.interfaces.Element;
import br.unicap.disk_scheduling.domain.domain.Style;
import br.unicap.disk_scheduling.domain.domain.Table;
import br.unicap.disk_scheduling.domain.domain.Disk;

public class Handler {

    public static void main(String[] args) {
        Random random = new Random();
        int diskSize = 50;
        int requestsQuantity = 7;

        Disk disk1 = new Disk(diskSize);
        Disk disk2 = new Disk(diskSize);

        System.out.println("Adding requests to disk");

        int value;
        for (int i = 0; i < requestsQuantity; i++) {

            value = random.nextInt(disk1.getSize())+1;
            while (disk1.contains(value)) {
                value = random.nextInt(disk1.getSize());
            }
            disk1.addRequest(value);
        }

        disk2.setPositions(disk1.getPositions().stream().map(val -> new Integer(val))

                .collect(Collectors.toList()));

        Element style = new Style(
                "table,th,td{border: 1px solid black;text-align: center;color: red;}caption{color: black}");

        System.out.println("Disk:");
        System.out.println(disk1.getPositions());
        System.out.println(disk1.toString());

        Table table0 = disk1.getHTMLRepresentation("Disk:");

        SSTFSchedulingAlgorithm sstf = new SSTFSchedulingAlgorithm();
        FCFSSchedulingAlgorithm fcfs = new FCFSSchedulingAlgorithm();

        sstf.sort(disk1);

        System.out.println("Disk after SSTF:");
        System.out.println(disk1.getPositions());
        System.out.println(disk1.getTotalBlocksTraveled());
        System.out.println(disk1.toString());

        Table table1 = disk1.getHTMLRepresentation("Disk after SSTF:");

        fcfs.sort(disk2);

        System.out.println("Disk after FCFS:");
        System.out.println(disk2.getPositions());
        System.out.println(disk2.getTotalBlocksTraveled());
        System.out.println(disk2.toString());

        Table table2 = disk2.getHTMLRepresentation("Disk after FCFS:");

        try {
            makeAnHTMLFile(style, table0, table1, table2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeAnHTMLFile(Element style, Table... tables) throws IOException {
        File f = new File("index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        bw.write(style.toString());
        for (Table table : tables)
            bw.write(table.toString());
        bw.close();
        Desktop.getDesktop().browse(f.toURI());
    }
}
