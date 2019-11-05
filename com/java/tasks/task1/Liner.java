package com.java.tasks.task1;

public class Liner extends AbstractShip {

    private int passengers;
    private String name;
    private float length;
    private float width;
    private float displacement;

    public static final float DEFAULT_RENTAL = 1000;

    public Liner(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    @Override
    public float calculatePayment() {
        return passengers * DEFAULT_RENTAL;
    }

    @Override
    protected String toPrint() {
        StringBuilder result = new StringBuilder();
        result.append(
                "{" + "Name=" + name +
                "Length=" + length +
                "Width=" + width +
                "Displacement=" + displacement + "}"
        );
        return result.toString();
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return passengers * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;
    private String name;
    private float length;
    private float width;
    private float displacement;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    @Override
    public float calculatePayment() {
        return volume * DEFAULT_RENTAL;
    }

    @Override
    protected String toPrint() {
        StringBuilder result = new StringBuilder();
        result.append(
                "{" + "Name=" + name +
                        "Length=" + length +
                        "Width=" + width +
                        "Displacement=" + displacement + "}"
        );
        return result.toString();
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return volume * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL = 550;
    private String name;
    private float length;
    private float width;
    private float displacement;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    @Override
    public float calculatePayment() {
        return tonnage * DEFAULT_RENTAL;
    }

    @Override
    protected String toPrint() {
        StringBuilder result = new StringBuilder();
        result.append(
                "{" + "Name=" + name +
                        "Length=" + length +
                        "Width=" + width +
                        "Displacement=" + displacement + "}"
        );
        return result.toString();
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return tonnage * rentTax;
        } else {
            return calculatePayment();
        }
    }
}


abstract class AbstractShip {
    private String name;
    private float length;
    private float width;
    private float displacement;

    public AbstractShip(String name, float length, float width, float displacement) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    public abstract float calculatePayment();

    protected abstract String toPrint();

    interface SeaPortQueue {
        public final static int LENGTH_QUEUE_SHIP = 3;

        public int addShipToEndQueue(AbstractShip ship);

        public int removeShipFromBeginQueue();

        public String printQueueShip();
    }
}

class OdessaSeaPort implements AbstractShip.SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    private int indexShipInPort = NO_SHIP_IN_ARRAY;
    private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];

    @Override
    public int addShipToEndQueue(AbstractShip ship) {

        for (int index = 0; index < arrayShip.length; index++) {
            if (arrayShip[index] == null) {
                arrayShip[index] = ship;
                indexShipInPort = index;
                return index;
            }
        }
        return NO_SHIP_IN_ARRAY;
    }

    @Override
    public int removeShipFromBeginQueue() {

        if (indexShipInPort == -1) {
            return -1;
        }

        for (int index = 0; index < indexShipInPort; index++) {
            arrayShip[index] = arrayShip[index + 1];
        }

        arrayShip[indexShipInPort] = null;

        indexShipInPort--;
        return 1;
    }

    @Override
    public String printQueueShip() {
        StringBuilder str = new StringBuilder();

        if (arrayShip[0] == null) { return "QueueEmpty"; }

        int i = 0;
        while (i < 3) {
            if (arrayShip[i] == null) {
                break;
            }
            str.append(arrayShip[i].toPrint() + ";");
            i++;
        }
        return str.toString();
    }
}