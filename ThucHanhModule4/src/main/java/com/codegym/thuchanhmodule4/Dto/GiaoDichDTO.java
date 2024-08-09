package com.codegym.thuchanhmodule4.Dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GiaoDichDTO {

    private Long maGiaoDich;

    @NotNull(message = "Tên khách hàng là bắt buộc.")
    private Long maKhachHang;

    @NotBlank(message = "Loại dịch vụ là bắt buộc.")
    private String loaiDichVu;

    @Future(message = "Ngày giao dịch phải là ngày trong tương lai.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate ngayGiaoDich;

    @DecimalMin(value = "500000", message = "Đơn giá phải lớn hơn 500.000 (VND).")
    private BigDecimal donGia;

    @DecimalMin(value = "20", message = "Diện tích phải lớn hơn 20 (m2).")
    private BigDecimal dienTich;

    // Getters và Setters
    public Long getMaGiaoDich() {
        return maGiaoDich;
    }

    public void setMaGiaoDich(Long maGiaoDich) {
        this.maGiaoDich = maGiaoDich;
    }

    public Long getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Long maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(String loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public LocalDate getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(LocalDate ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDienTich() {
        return dienTich;
    }

    public void setDienTich(BigDecimal dienTich) {
        this.dienTich = dienTich;
    }
}
