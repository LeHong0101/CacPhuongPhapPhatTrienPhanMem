/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import controller.QuanLyCanBoController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.CanBo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author Admin
 */
public class Until {
    
    public static void readFileContent(String path) throws FileNotFoundException{
        String csvFile = path;
        List<CanBo> danhSachCanBo = readCanBoFromCSV(path);
        try (Reader reader = new FileReader(csvFile);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)){
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                System.out.println("CanBo[ten= "+ csvRecord.get(0)
                      +", maCanBo= " + csvRecord.get(1)
                       +", ngaySinh= " + csvRecord.get(2)
                       +", kieuCanBo= " + csvRecord.get(3)
                        +", soHGiangDay= " + csvRecord.get(4)
                        +", soBaiBaoCao= " + csvRecord.get(5)
                        +", soHPhucVu= " + csvRecord.get(6)
                        + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
    
    // lay tat ca thong tin can bo ra ngoai
    public static ObservableList<CanBo> readCanBoFromCSV(String path){
        List<CanBo> danhSachCanBo = new ArrayList<>();
        try(Reader reader = new FileReader(path);
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);){
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for(CSVRecord csvRecord : csvRecords){
                System.out.println("CanBo[ten= "+ csvRecord.get(0)
                      +", maCanBo= " + csvRecord.get(1)
                       +", ngaySinh= " + csvRecord.get(2)
                       +", kieuCanBo= " + csvRecord.get(3)
                        +", soHGiangDay= " + csvRecord.get(4)
                        +", soBaiBaoCao= " + csvRecord.get(5)
                        +", soHPhucVu= " + csvRecord.get(6)
                        + "]");
                QuanLyCanBoController quanLyCanBo = QuanLyCanBoController.getInstance();
                String Ten = csvRecord.get(0);
                String MaCanBo = csvRecord.get(1);
                String NgaySinh = csvRecord.get(2);
                String KieuCanBo = csvRecord.get(3);
                String soHGiangDay = csvRecord.get(4);
                String soBaiBaoCao = csvRecord.get(5);
                String soHPhucVu = csvRecord.get(6);
                CanBo canBo = quanLyCanBo.taoMoiCanBo(Ten, MaCanBo, KieuCanBo, NgaySinh, soHGiangDay, soBaiBaoCao, soHPhucVu);
                danhSachCanBo.add(canBo);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return FXCollections.observableArrayList(danhSachCanBo);
    }
    
    public static String chooseDirectoryOfNewFile(String extension){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("File Chooser");
        
        String fileType = extension.replace(".","");
        String desc = String.format("%s files (*%s)", fileType, extension);
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter(desc,"*"+extension));
        
        Stage stage = new Stage();
        File saveFile = fileChooser.showOpenDialog(stage);
        
        if(saveFile == null){
            return null;
        }
        
        String path = saveFile.getAbsolutePath();
        
        if(!path.endsWith(extension)){
            path+=extension;
        }
        
        return path;
    }
    
    public static void writeContentToFile(String content, String filePath){
        try {
            new File(filePath).getParentFile().mkdirs();
            PrintWriter out = new PrintWriter(filePath);
            out.println(content);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void saveContentToNewFile(String content){
        String filePath = chooseDirectoryOfNewFile(".csv");
        if(filePath != null) writeContentToFile(content, filePath);
    }
}
