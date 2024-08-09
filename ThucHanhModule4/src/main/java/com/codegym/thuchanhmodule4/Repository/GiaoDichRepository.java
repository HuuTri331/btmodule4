package com.codegym.thuchanhmodule4.Repository;

import com.codegym.thuchanhmodule4.model.GiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GiaoDichRepository extends JpaRepository<GiaoDich, Long> {
      List<GiaoDich> findByKhachHang_TenKhachHangContainingAndLoaiDichVuContaining(String tenKhachHang, String loaiDichVu);
}
