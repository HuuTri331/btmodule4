package com.codegym.thuchanhmodule4.Service;

import com.codegym.thuchanhmodule4.model.KhachHang;
import com.codegym.thuchanhmodule4.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class khachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> getAllKhachHang() {
        return khachHangRepository.findAll();
    }
    public KhachHang getKhachHangById(Long id) {
        return khachHangRepository.findById(id).orElse(null);
    }
}
