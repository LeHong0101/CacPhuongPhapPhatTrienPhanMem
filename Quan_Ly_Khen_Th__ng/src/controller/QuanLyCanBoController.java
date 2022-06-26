/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import com.sun.javafx.util.Utils;
import java.net.URL;
import java.util.Date;
import javafx.collections.ObservableList;
import models.CanBo;
import models.KieuCanBo;
import models.object.CanBoNghienCuu;
import models.object.CanBoTapVu;
import models.object.GiaoVien;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import services.Until;

/**
 *
 * @author Admin
 */
public class QuanLyCanBoController {
    private static QuanLyCanBoController instance;
    private ObservableList<CanBo> danhSachCanBo;
    
    public static QuanLyCanBoController getInstance(){
        if(instance == null){
            instance = new QuanLyCanBoController();
        }
        return instance;
    }
    
    public KieuCanBo KieuCanBoStringToObj(String kieuCanBo){
        return switch (kieuCanBo) {
            case "GiaoVien" -> KieuCanBo.GiaoVien;
            case "CanBoTapVu" -> KieuCanBo.CanBoTapVu;
            case "CanBoNghienCuu" -> KieuCanBo.CanBoNghienCuu;
            default -> KieuCanBo.None;
        };
    }
    
    // khoi tao CanBo
    public CanBo taoMoiCanBo(String Ten, int MaCanBo, KieuCanBo KieuCanBo, Date NgaySinh, int soGioGiangDay, int soBaiBaoNghienCuu, int soGioPhucVu){
        switch(KieuCanBo){
            case GiaoVien: return new GiaoVien(Ten, MaCanBo, "GiaoVien", NgaySinh, soGioGiangDay);
            case CanBoTapVu: return new CanBoTapVu(Ten, MaCanBo, "CanBoTapVu", NgaySinh, soGioPhucVu);
            case CanBoNghienCuu: return new CanBoNghienCuu(Ten, MaCanBo, "CanBoNghienCuu", NgaySinh, soGioPhucVu);
            default:
        }
        return null;
    }
    
    public CanBo taoMoiCanBo(String Ten, String MaCanBo, String KieuCanBo, String NgaySinh, String soGioGiangDay, String soBaiBaoNghienCuu, String soGioPhucVu) {
        if(!dauVaoCoGiaTri(Ten, MaCanBo, KieuCanBo, NgaySinh, soGioGiangDay, soBaiBaoNghienCuu, soGioPhucVu)) return null;
        Date ngaySinh;
        try {
            ngaySinh = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
        } catch (ParseException ex) {
            return null;
        }
        return taoMoiCanBo(Ten, Integer.parseInt(MaCanBo), KieuCanBoStringToObj(KieuCanBo), ngaySinh, Integer.parseInt(soGioGiangDay), Integer.parseInt(soBaiBaoNghienCuu),Integer.parseInt(soGioPhucVu));
    }
    
    // kiem tra dau vao
    public boolean dauVaoCoGiaTri(String Ten, String MaCanBo, String KieuCanBo, String NgaySinh, String soGioGiangDay, String soBaiBaoNghienCuu, String soGioPhucVu){
        return !("".equals(Ten)||"".equals(MaCanBo)||"".equals(KieuCanBo)||"".equals(NgaySinh)||"".equals(soBaiBaoNghienCuu)||"".equals(soGioGiangDay)||"".equals(soGioPhucVu));
    }
    
    public ObservableList<CanBo> getDanhSachCanBo(){
        if(this.danhSachCanBo==null){
            this.danhSachCanBo = new ObservableList<>(){
                @Override
                public void addListener(ListChangeListener<? super CanBo> ll) {
                    
                }

                @Override
                public void removeListener(ListChangeListener<? super CanBo> ll) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean addAll(CanBo... es) {
                   // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   return false;
                }

                @Override
                public boolean setAll(CanBo... es) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean setAll(Collection<? extends CanBo> clctn) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public boolean removeAll(CanBo... es) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean retainAll(CanBo... es) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public void remove(int i, int i1) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public int size() {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean contains(Object o) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public Iterator<CanBo> iterator() {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public Object[] toArray() {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public <T> T[] toArray(T[] a) {
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public boolean add(CanBo e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean remove(Object o) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean containsAll(Collection<?> c) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean addAll(Collection<? extends CanBo> c) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean addAll(int index, Collection<? extends CanBo> c) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean removeAll(Collection<?> c) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public boolean retainAll(Collection<?> c) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return false;
                }

                @Override
                public void clear() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public CanBo get(int index) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public CanBo set(int index, CanBo element) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public void add(int index, CanBo element) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
                }

                @Override
                public CanBo remove(int index) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public int indexOf(Object o) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return 0;
                }

                @Override
                public int lastIndexOf(Object o) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return 0;
                }

                @Override
                public ListIterator<CanBo> listIterator() {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public ListIterator<CanBo> listIterator(int index) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public List<CanBo> subList(int fromIndex, int toIndex) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    return null;
                }

                @Override
                public void addListener(InvalidationListener il) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }

                @Override
                public void removeListener(InvalidationListener il) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
                    
            };
            loadData();
        }
        return this.danhSachCanBo;
    }
    
    public void loadData(){
        try {
            URL resource = QuanLyCanBoController.class.getResource("/data.csv");
            String path = Paths.get(resource.toURI()).toString();
            danhSachCanBo = Until.readCanBoFromCSV(path);
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    public ObservableList<CanBo> timKiemBangTen(String ten, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> danhSach = new ArrayList<>();
        for(CanBo cb: danhSachCanBo){
            if(cb.getTen()== ten) danhSach.add(cb);
        }
        return FXCollections.observableArrayList(danhSach);
    }
    
    public ObservableList<CanBo> timKiemBangMaCanBo(int maCanBo, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> danhSach = new ArrayList<>();
        for(CanBo cb: danhSachCanBo){
            if(cb.getMaCanBo()== maCanBo) danhSach.add(cb);
        }
        return FXCollections.observableArrayList(danhSach);
    }
    
    public ObservableList<CanBo> timKiemBangNgaySinh(Date NgaySinh, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> danhSach = new ArrayList<>();
        for(CanBo cb: danhSachCanBo){
            if(cb.getNgaySinh().equals(NgaySinh)) danhSach.add(cb);
        }
        return FXCollections.observableArrayList(danhSach);
    }
    
    public ObservableList<CanBo> timKiemBangNgaySinh(String NgaySinh, ObservableList<CanBo> danhSachCanBo){
        Date ns;
        try {
            ns = new SimpleDateFormat("dd/MM/yyyy").parse(NgaySinh);
        } catch (ParseException ex) {
            return null;
        }
        return timKiemBangNgaySinh(ns, danhSachCanBo);
    }
    
    public ObservableList<CanBo> timKiemBangKieu(KieuCanBo kieuCanBo, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> ds = new ArrayList<>();
        for(CanBo cb : danhSachCanBo){
            if(cb.getKieuCanBo().equals(kieuCanBo)) ds.add(cb);
        }
        return FXCollections.observableArrayList(ds);
    }
    
    public ObservableList<CanBo> timKiemBangKieu(String kieuCanBo, ObservableList<CanBo> danhSachCanBo){
        return timKiemBangKieu(QuanLyCanBoController.getInstance().KieuCanBoStringToObj(kieuCanBo), danhSachCanBo);
    }
    
    // loc ra thong tin can bo co so gio giang day lon hon so nhap vao
    public ObservableList<CanBo> locBangHDay(int hDay, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> ds = new ArrayList<>();
        for(CanBo cb : danhSachCanBo){
            if(cb.getSoGioGiangDay() >= hDay) ds.add(cb);
        }
        return FXCollections.observableArrayList(ds);
    }
    
    //loc ra thong tin can bo co so bai bao cao lo hon so cho truoc
    public ObservableList<CanBo> locBangSoBaoCao(int soBaoCao, ObservableList<CanBo> danhSachCanBo){
        List<CanBo> ds = new ArrayList<>();
        for(CanBo cb: danhSachCanBo){
            if(cb.getSoBaiBaoNghienCuu()==soBaoCao) ds.add(cb);
        }
        return FXCollections.observableArrayList(ds);
    }
}
