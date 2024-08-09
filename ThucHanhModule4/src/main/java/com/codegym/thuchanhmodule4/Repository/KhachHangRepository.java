package com.codegym.thuchanhmodule4.Repository;

import com.codegym.thuchanhmodule4.model.GiaoDich;
import com.codegym.thuchanhmodule4.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {

}

