package co.icesi.edu.model;

import co.icesi.edu.ui.Main;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class InfraestructureDeparment {

    public static final String BILLBOARD_FILE_NAME = "BillboardDataExported.csv";

    private Billboard first;

    public InfraestructureDeparment() throws Exception {
        // billboards = new ArrayList<>();
        loadBillboard();
    }

    public void addBillboard(double w, double h, boolean ui, String b) {

    }

    private void saveBillboard() {

    }

    private void loadBillboard() throws Exception {
        String resource = Main.class.getClassLoader().getResource(BILLBOARD_FILE_NAME).getFile();
        File file = new File(resource);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        line = br.readLine();
        while (line != null) {
            importData(line);
            line = br.readLine();
        }

        br.close();
        fr.close();

    }

    public void exportDangerousBillboardReport(String fn) {

    }

    public void importData(String fn) {
        String[] columns = fn.split("\\|");
        // System.out.println(Arrays.toString(columns));
        Billboard billboard = new Billboard(Double.parseDouble(columns[0]), Double.parseDouble(columns[1]),
                Boolean.parseBoolean(columns[2]), columns[3]);
        addBillboardStart(billboard);
    }

    public String toString() {
        return "";
    }

    public double averageHeight() {

        return 0;
    }

    public void exportToJSON() {
        Gson encoder = new GsonBuilder().create();
        String serial = encoder.toJson(first);
        System.out.println(serial);
        writeIntoFile(serial, "output.json");
    }

    public void exportSerializableObject() {
        try {
            FileOutputStream file = new FileOutputStream("output.obj");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(first);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeIntoFile(String data, String file) {
        try {
            File file1 = new File(file);
            FileWriter fw = new FileWriter(file1, true);
            PrintWriter pw = new PrintWriter(fw);
            // BufferedWriter bw = new BufferedWriter(fw);
            pw.append(data);
            // bw.write(data);
            pw.close();
            // bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void addBillboardEnd(Billboard b) {
        if (first == null) {
            first = b;
        } else {
            b.setNext(first);
            first = b;
        }
    }

    public void addBillboardStart(Billboard b) {
        if (first == null) {
            first = b;
        } else {
            first.addBillboard(b);
        }
    }

    public void addBillboardOrder(Billboard b) {
        if (first == null) {
            first = b;
        } else {
            if (first.compareTo(b) == 1) {
                b.setNext(first);
                first = b;
            } else {
                first.addBillboard(b);
            }
        }
    }

    public Billboard search(Billboard b, Comparator<Billboard> c) {
        return first.searchBillboard(b, c);
    }

}
