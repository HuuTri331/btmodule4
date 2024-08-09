package com.codegym.thuchanhmodule4.Service;

import com.codegym.thuchanhmodule4.Repository.GiaoDichRepository;
import com.codegym.thuchanhmodule4.model.GiaoDich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;

    public List<GiaoDich> getAllGiaoDich() {
        return giaoDichRepository.findAll();
    }

    public GiaoDich getGiaoDichById(Long id) {
        return giaoDichRepository.findById(id).orElse(null);
    }

    public List<GiaoDich> searchGiaoDich(String tenKhachHang, String loaiDichVu) {
        return giaoDichRepository.findByKhachHang_TenKhachHangContainingAndLoaiDichVuContaining(tenKhachHang, loaiDichVu);
    }

    public void saveGiaoDich(GiaoDich giaoDich) {
        giaoDichRepository.save(giaoDich);
    }

    public void deleteGiaoDichById(Long id) {
        giaoDichRepository.deleteById(id);
    }
}
