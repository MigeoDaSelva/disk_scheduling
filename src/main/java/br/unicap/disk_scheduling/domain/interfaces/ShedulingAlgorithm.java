package br.unicap.disk_scheduling.domain.interfaces;

import br.unicap.disk_scheduling.domain.domain.Disk;

public interface ShedulingAlgorithm {
    
    void sort(Disk disk);
}
