package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import core.mate.academy.strategy.BulldozerProducer;
import core.mate.academy.strategy.ExcavatorProducer;
import core.mate.academy.strategy.TruckProducer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl<T extends Machine> implements MachineService<T> {
    @Override
    public List<T> getAll(Class<? extends T> type) {
        MachineProducer machineProducer;
        if (type == Bulldozer.class) {
            machineProducer = new BulldozerProducer();
            List<? extends T> machines = machineProducer.get();
            return new ArrayList<>(machines);
        } else if (type == Truck.class) {
            machineProducer = new TruckProducer();
            List<? extends T> machines = machineProducer.get();
            return new ArrayList<>(machines);
        } else if (type == Excavator.class) {
            machineProducer = new ExcavatorProducer();
            List<? extends T> machines = machineProducer.get();
            return new ArrayList<>(machines);
        }
        return new ArrayList<>();
    }

    @Override
    public void fill(List<? super T> machines, T value) {
        Collections.fill(machines, value);
    }

    @Override
    public void startWorking(List<? extends T> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
